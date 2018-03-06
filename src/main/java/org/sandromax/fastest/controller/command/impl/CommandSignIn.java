package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.model.dao.imp.BCrypt;
import org.sandromax.fastest.model.dao.imp.TestDao;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandSignIn implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.SIGN_IN_PAGE;

        String emailParam = request.getParameter("email");
        String passParam = request.getParameter("password");
        System.out.println("CommandSignIn output\nemail: " + emailParam + ", " + "password: " + passParam);

        String passDb = UserDao.getPassByEmail(emailParam);
        System.out.println("passDb: " + passDb);

        HttpSession session = request.getSession();

        System.out.println("check: " + BCrypt.checkpw(passParam, passDb));

        String name = UserDao.getNameByEmail(emailParam);

        if(passDb.length() != 0 && (BCrypt.checkpw(passParam, passDb))) {

            session.setAttribute("user_name", name);

            TestDao testDao = new TestDao();
            List<Subject> subjects = testDao.getAllSubjects();

            System.out.println("Subjects:");
            for(Subject s : subjects) {
                System.out.println("(id)" + s.getId() + " (name)" + s.getName() + " (lang)" +s.getLang());
            }

            request.setAttribute("title", "Subjects");
            session.setAttribute("list", subjects);

            page = Pages.SUBJECTS_CATALOG;
        } else {
            page = Pages.SIGN_IN_PAGE;
            request.setAttribute("error", "wrong email or password");
        }

        return page;
    }
}
