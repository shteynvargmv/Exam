package view.command;

import view.Console;

public class ChangeEmployeeTelNumber extends Command{

    public ChangeEmployeeTelNumber(Console console) {
        super(console);
        menuText = "Изменить контактный телефон сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeeTelNumber();
    }
}
