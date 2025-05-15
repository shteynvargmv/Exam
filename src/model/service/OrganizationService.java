package model.service;

import controller.OrganizationControllerImpl;
import model.entity.Employee;
import model.repository.OrganizationRepository;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class OrganizationService {
    private final OrganizationRepository repository;
    private final OrganizationControllerImpl controller;

    public OrganizationService(OrganizationControllerImpl controller) {
        this.controller = controller;
        repository = new OrganizationRepository();
    }

    public String addEmployee(String name, String birthDateString, String gender, String telNumber, String position, String department, String bossName, String employmentDateString, String salaryString) {
        //Проверки:
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        //Дата рождения
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            return "Ошибка ввода: Дата рождения";
        }
        if (birthDate == null) {
            return "Ошибка ввода: Дата рождения";
        }
        //Пол
        if (gender == null || (!gender.equals("м") && !gender.equals("ж"))) {
            return "Ошибка ввода: Пол";

        }
        //Контактный телефон
         if (telNumber == null || telNumber.equals("")) {
            return "Ошибка ввода: Контактный телефон";
        }
        //Должность
         if (position == null || position.equals("")) {
            return "Ошибка ввода: Должность";
        }
        //Отдел
        if (department == null || department.equals("")) {
            return "Ошибка ввода: Отдел";
        }
        //Начальник
        Employee boss = this.searchEmployee(bossName);
        if ((bossName != null && !bossName.equals("")) && boss == null) {
            return "Ошибка ввода: Начальник не найден";
        }
        //Дата приема на работу
        LocalDate employmentDate;
        try {
            employmentDate = LocalDate.parse(employmentDateString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            return "Ошибка ввода: Дата приема на работу";
        }
        if (employmentDate == null) {
            return "Ошибка ввода: Дата приема на работу";
        }
        //Зарплата
        Integer salary = 0;
        if (salaryString != null) {
            try {
                salary = Integer.parseInt(salaryString);
            } catch (NumberFormatException e) {
                return "Ошибка ввода: Зарплата";
            }
        }
        if (salary.equals(0)) {
            return "Ошибка ввода: Зарплата";
        }

        Employee employee = new Employee(name, birthDate, gender, telNumber, position, department, boss, employmentDate, salary);
        return repository.add(employee);
    }

     public String deleteEmployee(String name) {
         //ФИО
         if (name == null || name.equals("")) {
             return "Ошибка ввода: ФИО не заполнено";
         }
         Employee employee = repository.search(name);
         if (employee == null) {
           return  "Сотрудник " + name +" не существует";
         }
         return repository.delete(employee);
    }

    public String changeEmployeeBirthDate(String name, String birthDateString) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Дата рождения
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            return "Ошибка ввода: Дата рождения";
        }
        if (birthDate == null) {
            return "Ошибка ввода: Дата рождения";
        }
        employee.setBirthDate(birthDate);
        return "Дата рождения успешно изменена";
    }

    public String changeEmployeeBoss(String name, String bossName) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Начальник
        Employee boss = null;
        if (bossName != null && !bossName.equals("")) {
        boss = repository.search(bossName);
           if (boss == null) {
            return  "Сотрудник " + bossName +" не существует";
           }
        }

        if (name.equals(bossName)) {
            return "Ошибка ввода";
        }
        return repository.changeEmployeeBoss(employee, boss);
    }

    public String changeEmployeeDepartment(String name, String department) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Отдел
        if (department == null || department.equals("")) {
            return "Ошибка ввода: Отдел";
        }
        employee.setDepartment(department);
        return "Отдел успешно изменен";
    }

    public String changeEmployeeEmploymentDate(String name, String employmentDateString) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Дата приема на работу
        LocalDate employmentDate;
        try {
            employmentDate = LocalDate.parse(employmentDateString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            return "Ошибка ввода: Дата приема на работу";
        }
        if (employmentDate == null) {
            return "Ошибка ввода: Дата приема на работу";
        }
        employee.setEmploymentDate(employmentDate);
        return "Дата приема на работу успешно изменена";
    }

    public String changeEmployeeGender(String name, String gender) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Пол
        if (gender == null || (!gender.equals("м") && !gender.equals("ж"))) {
            return "Ошибка ввода: Пол";

        }
        employee.setGender(gender);
        return "Пол успешно изменен";
    }

    public String changeEmployeePosition(String name, String position) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Должность
        if (position == null || position.equals("")) {
            return "Ошибка ввода: Должность";
        }
        employee.setPosition(position);
        return "Должность успешно изменена";
    }

    public String changeEmployeeSalary(String name, String salaryString) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Зарплата
        Integer salary = 0;
        if (salaryString != null) {
            try {
                salary = Integer.parseInt(salaryString);
            } catch (NumberFormatException e) {
                return "Ошибка ввода: Зарплата";
            }
        }
        if (salary.equals(0)) {
            return "Ошибка ввода: Зарплата";
        }
        employee.setSalary(salary);
        return "Зарплата успешно изменена";
    }

    public String changeEmployeeTelNumber(String name, String telNumber) {
        //ФИО
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        }
        Employee employee = repository.search(name);
        if (employee == null) {
            return  "Сотрудник " + name +" не существует";
        }
        //Контактный телефон
        if (telNumber == null || telNumber.equals("")) {
            return "Ошибка ввода: Контактный телефон";
        }
        employee.setTelNumber(telNumber);
        return "Контактный телефон успешно изменен";
    }
    public Employee searchEmployee(String name) {
        if (name == null) {
            return null;
        } else {
            return repository.search(name);
        }
    }

    public String searchEmployeeByPosition(String position) {
        //Должность
        if (position == null || position.equals("")) {
            return "Ошибка ввода: Должность";
        }
        return repository.searchByPosition(position);
    }

    public String searchEmployeeByName(String name) {
        //Сотрудник
        Employee employee = null;
        if (name == null || name.equals("")) {
            return "Ошибка ввода: ФИО не заполнено";
        } else {
            employee = repository.search(name);
            if (employee == null) {
                return  "Сотрудник " + name +" не существует";
            }
        }
        return employee.toString();
    }

    public String searchEmployeeByDepartment(String department) {
        //Отдел
        if (department == null || department.equals("")) {
            return "Ошибка ввода: Отдел";
        }
        return repository.searchByDepartment(department);
    }

    public String searchEmployeeByBossName(String bossName) {
        //Начальник
        Employee boss = null;
        if (bossName == null || bossName.equals("")) {
            return "Ошибка ввода: ФИО начальника не заполнено";
        } else {
            boss = repository.search(bossName);
            if (boss == null) {
                return  "Сотрудник " + bossName +" не существует";
            }
        }
        return repository.searchByBoss(boss);
    }

    public String top10HighSalary() {
        return repository.top10HighSalary();
    }

    public String displayOrganizationStructure() {
        return repository.displayOrganizationStructure();
    }

    public String midOrganizationSalary() {
        return repository.midOrganizationSalary();
    }

    public String midDepartmentSalary() {
        return repository.midDepartmentSalary();
    }

    public String top10LongTimeWorked() {
        return repository.top10LongTimeWorked();
    }

    public String organizationOutput() {
       return repository.organizationOutput();
    }

    public String organizationInput() {
        return repository.organizationInput();
    }
}
