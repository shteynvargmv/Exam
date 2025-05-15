package view.command;

import view.Console;

public class Top10LongTimeWorked extends Command{

    public Top10LongTimeWorked(Console console) {
        super(console);
        menuText = "ТОП-10 самых преданных сотрудников по количеству лет работы";
    }

    @Override
    public void execute() {
        console.top10LongTimeWorked();
    }
}
