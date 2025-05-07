package view.command;

import view.Console;

public class AddEmployee extends Command{

    public AddEmployee(Console console) {
        super(console);
        menuText = "Добавить сотрудника";
    }

    @Override
    public void execute() {
        console.addEmployee();
    }

}
