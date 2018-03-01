package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandSignOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.SIGN_IN_PAGE;

        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return page;
    }
}
