package view.command;

import view.Console;

public class MidDepartmentSalary extends Command{

    public MidDepartmentSalary(Console console) {
        super(console);
        menuText = "Средняя зарплата по отделам";
    }

    @Override
    public void execute() {
        console.midDepartmentSalary();
    }
}
