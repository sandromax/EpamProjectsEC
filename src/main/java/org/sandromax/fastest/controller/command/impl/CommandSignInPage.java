package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.constants.Pages;

import javax.servlet.http.HttpServletRequest;

public class CommandSignInPage implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.SIGN_IN_PAGE;

        return page;
    }


}
