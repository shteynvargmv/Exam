package view;

import java.util.ArrayList;


import java.util.List;

import view.command.*;

public class Menu {
    private final List<Command> commands;

    public Menu(Console console) {
        commands = new ArrayList<>();
        commands.add(new AddEmployee(console));
        commands.add(new DeleteEmployee(console));
        commands.add(new ChangeEmployeeBirthDate(console));
        commands.add(new ChangeEmployeeBoss(console));
        commands.add(new ChangeEmployeeDepartment(console));
        commands.add(new ChangeEmployeeEmploymentDate(console));
        commands.add(new ChangeEmployeeGender(console));
        commands.add(new ChangeEmployeePosition(console));
        commands.add(new ChangeEmployeeSalary(console));
        commands.add(new ChangeEmployeeTelNumber(console));
        commands.add(new SearchEmployeeByBossName(console));
        commands.add(new SearchEmployeeByDepartment(console));
        commands.add(new SearchEmployeeByName(console));
        commands.add(new SearchEmployeeByPosition(console));
        commands.add(new DisplayOrganizationStructure(console));
        commands.add(new MidDepartmentSalary(console));
        commands.add(new MidOrganizationSalary(console));
        commands.add(new Top10HighSalary(console));
        commands.add(new Top10LongTimeWorked(console));
        commands.add(new OrganizationOutput(console));
        commands.add(new OrganizationInput(console));
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
