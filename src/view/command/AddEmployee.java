package view.command;

import view.Console;

public class AddEmployee extends Command{

    public AddEmployee(Console console) {
        super(console);
        menuText = "Принять на работу нового сотрудника";
    }

    @Override
    public void execute() {
        console.addEmployee();
    }

}
