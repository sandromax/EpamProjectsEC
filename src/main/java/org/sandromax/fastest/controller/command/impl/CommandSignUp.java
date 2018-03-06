package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.SIGN_IN_PAGE;

        String emailParam = request.getParameter("email");
        String nameParam = request.getParameter("name");
        String passParam = request.getParameter("pass");


        System.out.println("email: " + emailParam + ", name: " + nameParam + " password: " + passParam);

        if(UserDao.addStudent(nameParam, emailParam, passParam)) {
            return page;
        } else {
//            request.setAttribute("error", "Error");
            page = Pages.SIGN_UP_PAGE;
            return page;
        }



    }
}
