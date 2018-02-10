package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
//import org.sandromax.fastest.controller.command.Receiver;
import static org.sandromax.fastest.controller.until.constants.Pages.*;

import javax.servlet.http.HttpServletRequest;

public class CommandIndexPage implements Command {
//    private Receiver receiver;
//    public CommandIndexPage(Receiver receiver){
//        this.receiver = receiver;
//    }
    @Override
    public String execute(HttpServletRequest request) {
        String page = INDEX_PAGE;
//        System.out.println("Going to main page");
//        receiver.action(CommandList.MAIN);

        return page;
    }
}
