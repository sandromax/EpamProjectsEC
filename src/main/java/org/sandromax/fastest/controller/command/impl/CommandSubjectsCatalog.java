package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.command.CommandList;
import org.sandromax.fastest.controller.command.Receiver;

public class CommandSubjectsCatalog implements Command {
    private Receiver receiver;
    public CommandSubjectsCatalog(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("Going to catalog of the subjects");
        receiver.action(CommandList.SUBJECTS_CATALOG);
    }
}
