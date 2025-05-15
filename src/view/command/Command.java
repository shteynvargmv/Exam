package view.command;

import view.Console;

public class Command {

    public String menuText;
    Console console;

    public Command(Console console) {
        this.console = console;
    }

    public String getMenuText() {
        return menuText;
    }

    public void execute() {
    }
}
