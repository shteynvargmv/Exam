package view.command;

import view.Console;

public class DeleteEmployee extends Command{

    public DeleteEmployee(Console console) {
        super(console);
        menuText = "Уволить сотрудника";
    }

    @Override
    public void execute() {
        console.deleteEmployee();
    }

}
