package view.command;

import view.Console;

public class ChangeEmployeeDepartment extends Command{

    public ChangeEmployeeDepartment(Console console) {
        super(console);
        menuText = "Изменить отдел, в котором работает сотрудник";
    }

    @Override
    public void execute() {
        console.changeEmployeeDepartment();
    }
}
