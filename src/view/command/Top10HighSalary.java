package view.command;

import view.Console;

public class Top10HighSalary extends Command{

    public Top10HighSalary(Console console) {
        super(console);
        menuText = "ТОП-10 самых дорогих сотрудников по зарплате";
    }

    @Override
    public void execute() {
        console.top10HighSalary();
    }
}
