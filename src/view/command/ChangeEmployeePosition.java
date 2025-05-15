package view.command;

import view.Console;

public class ChangeEmployeePosition extends Command{

    public ChangeEmployeePosition(Console console) {
        super(console);
        menuText = "Изменить должность сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeePosition();
    }
}
