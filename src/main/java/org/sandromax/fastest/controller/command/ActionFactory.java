package org.sandromax.fastest.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public Command defineCommand(HttpServletRequest request) {
        Command command = null;
        String commandParam = request.getParameter("command");

        if(commandParam == null || commandParam.isEmpty())
            return command;

        try {
            CommandList currentEnum = CommandList.valueOf(commandParam.toUpperCase());
            command = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("someWrong", commandParam);
        }

        return command;
    }
}
