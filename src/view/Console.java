package view;

import controller.OrganizationControllerImpl;
import java.util.Scanner;

public class Console implements View{
    private final Scanner scanner;
    private final OrganizationControllerImpl controller;
    private final Menu menu;
    private boolean work;

    public Console() {
        scanner = new Scanner(System.in);
        controller = new OrganizationControllerImpl(this);
        menu = new Menu(this);
        work = true;
    }

    public Object addValue;

    public void run() {
        System.out.println("\nСистема учета сотрудников");
        while (work) {
            System.out.println(menu.printMenu());
            execute();
        }
        System.out.println("Всего доброго! До свидания!");
        scanner.close();
    }

    private void execute() {
        System.out.print("Выберите пункт меню: ");
        menu.execute(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public void printAnswer(String info) {
        System.out.println(info);
    }

    public void addEmployee() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        controller.addEmployee(name);
    }

    public void exit() {
        work = false;
    }
}
