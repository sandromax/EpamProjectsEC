package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.RequestInfo;
import org.sandromax.fastest.controller.until.SessionInfo;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandSignInPankaj implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page, emailDb, passDb;

//        page = Pages.TEST_FIELD_PAGE;
        page = emailDb = passDb = null;

        String emailParam = request.getParameter("email");
        String passwordParam = request.getParameter("password");

        System.out.println("email: " + emailParam + ", " + "password: " + passwordParam);

        emailDb = UserDao.getEmailByPass(passwordParam);

        if(emailDb.length() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user", emailDb);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            page = Pages.SUBJECTS_CATALOG;
        } else {
            page = Pages.SIGN_IN_PAGE;
            request.setAttribute("error", "Wrong email or password!");
        }


//        if(emailDb.equals(emailParam) && passDb.equals(passwordParam)){
//            HttpSession session = request.getSession();
//            session.setAttribute("user", "Pankaj");
//            setting session to expiry in 30 mins
//            session.setMaxInactiveInterval(30*60);
//            Cookie userName = new Cookie("user", user);
//            response.addCookie(userName);
//            Get the encoded URL string
//            String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
//            response.sendRedirect(encodedURL);
//        }else{
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            PrintWriter out= response.getWriter();
//            out.println("<font color=red>Either user name or password is wrong.</font>");
//            rd.include(request, response);
//        }

        return page;
    }
}
