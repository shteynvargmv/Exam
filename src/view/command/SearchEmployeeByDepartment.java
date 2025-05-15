package view.command;

import view.Console;

public class SearchEmployeeByDepartment extends Command{

    public SearchEmployeeByDepartment(Console console) {
        super(console);
        menuText = "Найти сотрудника по названию отдела";
    }

    @Override
    public void execute() {
        console.searchEmployeeByDepartment();
    }

}
