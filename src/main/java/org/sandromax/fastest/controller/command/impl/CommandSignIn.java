package org.sandromax.fastest.controller.command.impl;

import org.apache.log4j.Logger;
import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.model.dao.imp.BCrypt;
import org.sandromax.fastest.model.dao.imp.TestDao;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//import org.apache.log4j.Logger;



public class CommandSignIn implements Command {
    @Override
    public String execute(HttpServletRequest request) {

//        Logger logger = (Logger)request.getServletContext().getAttribute("log4");
//         Logger logger = Logger.getLogger(CommandSignIn.class);


        String page;    // = Pages.SIGN_IN_PAGE;

        sessionLogOut(request);

        String emailParam = request.getParameter("email");
        String passParam = request.getParameter("password");
//        System.out.println("CommandSignIn output\nemail: " + emailParam + ", " + "password: " + passParam);

        String passDb = UserDao.getPassByEmail(emailParam);
//        System.out.println("passDb: " + passDb.isEmpty());
        String nameDb = UserDao.getNameByEmail(emailParam);


        HttpSession session = request.getSession();

//        System.out.println("check: " + BCrypt.checkpw(passParam, passDb));


//        boolean isValid = BCrypt.checkpw(passParam, passDb);
        if(passDb.length() != 0 && (BCrypt.checkpw(passParam, passDb))) {

            session.setAttribute("user_name", nameDb);

            List<Subject> subjects = TestDao.getAllSubjects();

//            System.out.println("Subjects:");
//            for(Subject s : subjects) {
//                System.out.println("(id)" + s.getId() + " (name)" + s.getName() + " (lang)" +s.getLang());
//            }
//          Note: Code repeating (CommandSubjectsCatalog.java:18-23)
            request.setAttribute("title", "Subjects");
            session.setAttribute("list", subjects);

            page = Pages.SUBJECTS_CATALOG;
//            logger.info("entered by " + nameDb);

        } else {
            page = Pages.SIGN_IN_PAGE;
            request.setAttribute("error", "wrong email or password");
        }

        return page;
    }

    private void sessionLogOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
    }
}
