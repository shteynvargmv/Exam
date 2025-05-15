package view.command;

import view.Console;

public class OrganizationInput extends Command{

    public OrganizationInput(Console console) {
        super(console);
        menuText = "Загрузить данные организации из файла";
    }

    @Override
    public void execute() {
        console.organizationInput();
    }
}
