package org.sandromax.fastest.controller.command;

import org.sandromax.fastest.controller.command.impl.CommandMainPage;
import org.sandromax.fastest.controller.command.impl.CommandSubjectsCatalog;

public class Client {
    private Receiver receiver;

    public Client(Receiver receiver) {
        this.receiver = receiver;
    }

    public Command initCommand(CommandList cmd) {
        Command command = null;

        switch (cmd){
            case MAIN:
                System.out.println("Creating command 'MainPage' and set up its receiver");
                command = new CommandMainPage(this.receiver);
                break;
            case SUBJECTS_CATALOG:
                System.out.println("Creating command 'SubjectsCatalog' and set up its receiver");
                command = new CommandSubjectsCatalog(this.receiver);
                break;
        }
        return command;
    }
}
