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

        TestDao testDao = new TestDao();
        List<Theme> themes = testDao.getThemesBySubject(subject);

        request.setAttribute("list", themes);

        return page;
    }
}
