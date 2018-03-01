package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.model.dao.imp.TestDao;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandTestField implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.SIGN_IN_PAGE;

        String emailParam = request.getParameter("email");
        String passwordParam = request.getParameter("password");

        System.out.println("email: " + emailParam + ", " + "password: " + passwordParam);

        String emailDb = UserDao.getEmailByPass(passwordParam);

        HttpSession session = request.getSession();


        if(emailDb.length() != 0) {

            session.setAttribute("em", emailDb);

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
