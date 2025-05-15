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
        System.out.println("До свидания!");
        scanner.close();
    }

    private void execute() {
        System.out.print("Выберите пункт меню: ");
        try {
            int i = Integer.parseInt(scanner.nextLine());
            if (i <= menu.getSize()) {
                menu.execute(i);
            } else {
                System.out.println("Ошибка ввода");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
        }
    }

    @Override
    public void printAnswer(String info) {
        System.out.println(info);
    }

    public void addEmployee() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения в формате ГГГГ/ММ/ДД: ");
        String birthDate = scanner.nextLine();
        System.out.print("Введите пол (м/ж): ");
        String gender = scanner.nextLine();
        System.out.print("Введите контактный телефон: ");
        String telNumber = scanner.nextLine();
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();
        System.out.print("Введите название отдела: ");
        String department = scanner.nextLine();
        System.out.print("Введите ФИО начальника: ");
        String bossName = scanner.nextLine();
        System.out.print("Введите дату приема на работу в формате ГГГГ/ММ/ДД: ");
        String employmentDate = scanner.nextLine();
        System.out.print("Введите зарплату: ");
        String salary = scanner.nextLine();
        controller.addEmployee(name, birthDate, gender, telNumber, position, department, bossName, employmentDate, salary);
    }

    public void deleteEmployee() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        controller.deleteEmployee(name);
    }

    public void changeEmployeeBirthDate() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения в формате ГГГГ/ММ/ДД: ");
        String birthDate = scanner.nextLine();
        controller.changeEmployeeBirthDate(name,birthDate);
    }

    public void changeEmployeeBoss() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите ФИО начальника: ");
        String bossName = scanner.nextLine();
        controller.changeEmployeeBoss(name,bossName);
    }
    public void changeEmployeeDepartment() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите название отдела: ");
        String department = scanner.nextLine();
        controller.changeEmployeeDepartment(name,department);
    }
    public void changeEmployeeEmploymentDate() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату приема на работу в формате ГГГГ/ММ/ДД: ");
        String employmentDate = scanner.nextLine();
        controller.changeEmployeeEmploymentDate(name,employmentDate);
    }
    public void changeEmployeeGender() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (м/ж): ");
        String gender = scanner.nextLine();
        controller.changeEmployeeGender(name,gender);
    }
    public void changeEmployeePosition() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();
        controller.changeEmployeePosition(name,position);
    }
    public void changeEmployeeSalary() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите зарплату: ");
        String salary = scanner.nextLine();
        controller.changeEmployeeSalary(name,salary);
    }
    public void changeEmployeeTelNumber() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите контактный телефон: ");
        String telNumber = scanner.nextLine();
        controller.changeEmployeeTelNumber(name,telNumber);
    }

    public void searchEmployeeByBossName() {
        System.out.print("Введите ФИО начальника: ");
        String bossName = scanner.nextLine();
        controller.searchEmployeeByBossName(bossName);
    }

    public void searchEmployeeByDepartment() {
        System.out.print("Введите название отдела: ");
        String department = scanner.nextLine();
        controller.searchEmployeeByDepartment(department);
    }

    public void searchEmployeeByName() {
        System.out.print("Введите ФИО сотрудника: ");
        String name = scanner.nextLine();
        controller.searchEmployeeByName(name);
    }

    public void searchEmployeeByPosition() {
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();
        controller.searchEmployeeByPosition(position);
    }

    public void exit() {
        work = false;
    }

    public void displayOrganizationStructure() {
        controller.displayOrganizationStructure();
    }

    public void midOrganizationSalary() {
        controller.midOrganizationSalary();
    }

    public void midDepartmentSalary() {
        controller.midDepartmentSalary();
    }

    public void top10HighSalary() {
        controller.top10HighSalary();
    }

    public void top10LongTimeWorked() {
       controller.top10LongTimeWorked();
    }

    public void organizationOutput() {
        controller.organizationOutput();
    }

    public void organizationInput() {
        controller.organizationInput();
    }
}
