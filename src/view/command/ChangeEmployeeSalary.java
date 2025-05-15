package view.command;

import view.Console;

public class ChangeEmployeeSalary extends Command{

    public ChangeEmployeeSalary(Console console) {
        super(console);
        menuText = "Изменить зарплату сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeeSalary();
    }
}
