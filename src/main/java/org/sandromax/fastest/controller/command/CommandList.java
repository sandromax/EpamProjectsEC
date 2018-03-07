package org.sandromax.fastest.controller.command;

import org.sandromax.fastest.controller.command.impl.*;

/**
 * Перечисление констант с
 привязкой к ним значений –
 экземпляров «Команда»
 */
public enum CommandList {
    SIGN_IN_PAGE(new CommandSignInPage()),
    SIGN_IN(new CommandSignIn()),
    SIGN_UP_PAGE(new CommandSignUpPage()),
    SIGN_UP(new CommandSignUp()),
    SIGN_OUT(new CommandSignOut()),
    MAIN_PAGE(new CommandIndexPage()),
    SUBJECTS_CATALOG(new CommandSubjectsCatalog()),
    THEMES_CATALOG(new CommandThemesCatalog()),
    TEST_PAGE(new CommandTestPage()),
    TEST_RESULT_PAGE(new CommandTestResultPage()),
    ADMIN_PAGE(new CommandAdminPage()),
    GET_TESTS_FROM_FILE(new CommandGetTestsFromFile()),
    TEST_FIELD(new CommandTestField());

    private CommandList(Command command) {
        this.command = command;
    }
    private Command command;

    public Command getCommand() {
        return command;
    }
}
