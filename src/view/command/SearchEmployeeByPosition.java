package view.command;

import view.Console;

public class SearchEmployeeByPosition extends Command{

    public SearchEmployeeByPosition(Console console) {
        super(console);
        menuText = "Найти сотрудника по должности";
    }

    @Override
    public void execute() {
        console.searchEmployeeByPosition();
    }

}
