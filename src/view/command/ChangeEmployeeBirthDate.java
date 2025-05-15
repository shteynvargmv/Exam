package view.command;

import view.Console;

public class ChangeEmployeeBirthDate extends Command{

    public ChangeEmployeeBirthDate(Console console) {
        super(console);
        menuText = "Изменить дату рождения сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeeBirthDate();
    }
}
