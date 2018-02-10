package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class CommandTestPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "web23/index.jsp";
        return page;
    }
}
