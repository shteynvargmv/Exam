package view.command;

import view.Console;

public class OrganizationOutput extends Command{

    public OrganizationOutput(Console console) {
        super(console);
        menuText = "Выгрузить данные организации в файл";
    }

    @Override
    public void execute() {
        console.organizationOutput();
    }
}
