package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;

import javax.servlet.http.HttpServletRequest;

public class CommandTestField implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.TEST_FIELD_PAGE;

        return page;
    }
}
