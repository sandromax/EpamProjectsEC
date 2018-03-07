package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;

import javax.servlet.http.HttpServletRequest;

public class CommandAdminPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.ADMIN_PAGE;

        return page;
    }
}
