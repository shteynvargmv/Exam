package view.command;

import view.Console;

public class Exit extends Command{
    public Exit(Console console) {
        super(console);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        console.exit();
    }
}
