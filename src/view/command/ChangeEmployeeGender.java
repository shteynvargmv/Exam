package view.command;

import view.Console;

public class ChangeEmployeeGender extends Command{

    public ChangeEmployeeGender(Console console) {
        super(console);
        menuText = "Изменить пол сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeeGender();
    }
}
