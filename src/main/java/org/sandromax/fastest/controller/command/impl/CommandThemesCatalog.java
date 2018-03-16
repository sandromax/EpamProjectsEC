package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.model.dao.imp.TestDao;

import javax.servlet.http.HttpServletRequest;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

public class CommandThemesCatalog implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.THEMES_CATALOG;

        String subject = request.getParameter("subject");

        Charset cset = Charset.forName("UTF-8");
        ByteBuffer buf = cset.encode(subject);
        byte[] b = buf.array();
        String utf8Subject = new String(b);

        System.out.println("param command: " + request.getParameter("command"));
        System.out.println("param subject: " + subject);
        System.out.println(subject.length());
        System.out.println("param utf-subject: " + utf8Subject);
        System.out.println(utf8Subject.length());

        System.out.println("attr subject: " + request.getAttribute("subject"));
        System.out.println("attr command: " + request.getAttribute("command"));


        TestDao testDao = new TestDao();
        List<Theme> themes = testDao.getThemesBySubject(subject);
        System.out.println("is empty: " + themes.isEmpty());
        System.out.println("size: " + themes.size());

        System.out.println("CommandThemesCatalog output");
        for(Theme theme : themes) {
            System.out.println(theme.toString());
        }
        request.setAttribute("subject", subject);
        request.setAttribute("title", subject);
        request.setAttribute("list", themes);

        return page;
    }
}
