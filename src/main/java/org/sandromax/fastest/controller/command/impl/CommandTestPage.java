package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.RequestInfo;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class CommandTestPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.TEST_PAGE;
        System.out.println("test page");

//        RequestInfo.show(request);
        request.setAttribute("title", request.getParameter("title"));
        String theme = request.getParameter("theme");



        return page;
    }
}
