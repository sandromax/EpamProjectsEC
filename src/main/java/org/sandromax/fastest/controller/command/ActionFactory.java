package org.sandromax.fastest.controller.command;

import org.sandromax.fastest.controller.command.impl.CommandMainPage;
import org.sandromax.fastest.controller.command.impl.CommandSubjectsCatalog;

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
//        switch (cmd){
//            case MAIN_PAGE:
//                System.out.println("Creating command 'MainPage' and set up its receiver");
//                command = new CommandMainPage(this.receiver);
//                break;
//            case SUBJECTS_CATALOG:
//                System.out.println("Creating command 'SubjectsCatalog' and set up its receiver");
//                command = new CommandSubjectsCatalog(this.receiver);
//                break;
//        }
    }
}
