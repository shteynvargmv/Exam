package view;

import java.util.ArrayList;


import java.util.List;

import view.command.AddEmployee;
import view.command.Command;
import view.command.Exit;

public class Menu {
    private final List<Command> commands;

    public Menu(Console console) {
        commands = new ArrayList<>();
        commands.add(new AddEmployee(console));
        commands.add(new Exit(console));
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nМеню\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getMenuText());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commands.size();
    }
}
