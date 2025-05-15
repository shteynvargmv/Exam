package view.command;

import view.Console;

public class ChangeEmployeeBoss extends Command{

    public ChangeEmployeeBoss(Console console) {
        super(console);
        menuText = "Изменить информацию о непосредственном начальнике сотрудника";
    }

    @Override
    public void execute() {
        console.changeEmployeeBoss();
    }
}
