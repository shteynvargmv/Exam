package view.command;

import view.Console;

public class DisplayOrganizationStructure extends Command{

    public DisplayOrganizationStructure(Console console) {
        super(console);
        menuText = "Вывести структуру организации";
    }

    @Override
    public void execute() {
        console.displayOrganizationStructure();
    }
}
