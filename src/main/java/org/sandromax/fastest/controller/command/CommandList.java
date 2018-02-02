package org.sandromax.fastest.controller.command;

import org.sandromax.fastest.controller.command.impl.CommandMainPage;
import org.sandromax.fastest.controller.command.impl.CommandSubjectsCatalog;

/**
 * Перечисление констант с
 привязкой к ним значений –
 экземпляров «Команда»
 */
public enum CommandList {
    SUBJECTS_CATALOG(new CommandSubjectsCatalog()),
    MAIN_PAGE(new CommandMainPage());
    private CommandList(Command command) {
        this.command = command;
    }
    private Command command;

    public Command getCommand() {
        return command;
    }
}
