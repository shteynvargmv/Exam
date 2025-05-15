package view.command;

import view.Console;

public class SearchEmployeeByBossName extends Command{

    public SearchEmployeeByBossName(Console console) {
        super(console);
        menuText = "Найти сотрудника по ФИО начальника";
    }

    @Override
    public void execute() {
        console.searchEmployeeByBossName();
    }

}
