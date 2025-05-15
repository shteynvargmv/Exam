package view.command;

import view.Console;

public class SearchEmployeeByName extends Command{

    public SearchEmployeeByName(Console console) {
        super(console);
        menuText = "Найти сотрудника по ФИО";
    }

    @Override
    public void execute() {
        console.searchEmployeeByName();
    }

}
