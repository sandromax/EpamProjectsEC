package org.sandromax.fastest.controller.command;

import org.sandromax.fastest.controller.command.impl.*;

/**
 * Перечисление констант с
 привязкой к ним значений –
 экземпляров «Команда»
 */
public enum CommandList {
    SIGN_IN(new CommandSignIn()),
    SIGN_UP(new CommandSignUp()),
    MAIN_PAGE(new CommandMainPage()),
    SUBJECTS_CATALOG(new CommandSubjectsCatalog()),
    THEMES_CATALOG(new CommandThemesCatalog()),
    TEST_PAGE(new CommandTestPage()),
    TEST_RESULT_PAGE(new CommandTestResultPage()),
    ADMIN_PAGE(new CommandAdminPage());

    private CommandList(Command command) {
        this.command = command;
    }
    private Command command;

    public Command getCommand() {
        return command;
    }
}
