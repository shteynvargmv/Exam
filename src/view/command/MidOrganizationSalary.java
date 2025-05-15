package view.command;

import view.Console;

public class MidOrganizationSalary extends Command{

    public MidOrganizationSalary(Console console) {
        super(console);
        menuText = "Средняя зарплата по организации";
    }

    @Override
    public void execute() {
        console.midOrganizationSalary();
    }
}
