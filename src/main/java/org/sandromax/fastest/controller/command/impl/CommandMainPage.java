package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.command.CommandList;
import org.sandromax.fastest.controller.command.Receiver;

public class CommandMainPage implements Command {
    private Receiver receiver;
    public CommandMainPage(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("Going to main page");
        receiver.action(CommandList.MAIN);
    }
}
