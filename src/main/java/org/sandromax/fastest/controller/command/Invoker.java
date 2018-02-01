package org.sandromax.fastest.controller.command;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void invokeCommand() {
        System.out.println("Refer to command for execution");
        command.execute();
    }

}
