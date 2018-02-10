package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.model.dao.imp.TestDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandThemesCatalog implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.THEMES_CATALOG;

        String subject = request.getParameter("subject");
        System.out.println("param subject: " + request.getParameter("subject"));
        System.out.println("param command: " + request.getParameter("command"));

        System.out.println("attr subject: " + request.getAttribute("subject"));
        System.out.println("attr command: " + request.getAttribute("command"));



        TestDao testDao = new TestDao();
        List<Theme> themes = testDao.getThemesBySubject(subject);

        System.out.println("CommandThemesCatalog output");
        for(Theme theme : themes) {
            System.out.println(theme.toString());
        }

        request.setAttribute("list", themes);

        return page;
    }
}
