package view.command;

import view.Console;

public class ChangeEmployeeEmploymentDate extends Command{

    public ChangeEmployeeEmploymentDate(Console console) {
        super(console);
        menuText = "Изменить дату приема на работу сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeeEmploymentDate();
    }
}
