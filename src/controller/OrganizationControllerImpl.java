package controller;

import model.service.OrganizationService;
import view.View;

public class OrganizationControllerImpl implements OrganizationController{
    private final View view;
    private final OrganizationService service;

    public OrganizationControllerImpl(View view) {
        super();
        this.view = view;
        service = new OrganizationService(this);
    }

    public void addEmployee(String name, String birthDateString, String gender, String telNumber, String position, String department, String bossName, String employmentDateString, String salaryString) {
        String info = service.addEmployee(name, birthDateString, gender, telNumber, position, department, bossName, employmentDateString, salaryString);
        view.printAnswer(info);
    }

    @Override
    public void deleteEmployee(String name) {
        String info = service.deleteEmployee(name);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeBirthDate(String name, String birthDateString) {
        String info = service.changeEmployeeBirthDate(name, birthDateString);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeBoss(String name, String bossName) {
        String info = service.changeEmployeeBoss(name, bossName);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeDepartment(String name, String department) {
        String info = service.changeEmployeeDepartment(name, department);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeEmploymentDate(String name, String employmentDateString) {
        String info = service.changeEmployeeEmploymentDate(name, employmentDateString);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeGender(String name, String gender) {
        String info = service.changeEmployeeGender(name, gender);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeePosition(String name, String position) {
        String info = service.changeEmployeePosition(name, position);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeSalary(String name, String salaryString) {
        String info = service.changeEmployeeSalary(name, salaryString);
        view.printAnswer(info);
    }

    @Override
    public void changeEmployeeTelNumber(String name, String telNumber) {
        String info = service.changeEmployeeTelNumber(name, telNumber);
        view.printAnswer(info);
    }

    @Override
    public void searchEmployeeByBossName(String bossName) {
        String info = service.searchEmployeeByBossName(bossName);
        view.printAnswer(info);
    }

    @Override
    public void searchEmployeeByDepartment(String department) {
        String info = service.searchEmployeeByDepartment(department);
        view.printAnswer(info);
    }

    @Override
    public void searchEmployeeByName(String name) {
        String info = service.searchEmployeeByName(name);
        view.printAnswer(info);
    }

    @Override
    public void searchEmployeeByPosition(String position) {
        String info = service.searchEmployeeByPosition(position);
        view.printAnswer(info);
    }

    @Override
    public void top10HighSalary() {
        String info = service.top10HighSalary();
        view.printAnswer(info);
    }

    @Override
    public void displayOrganizationStructure() {
        String info = service.displayOrganizationStructure();
        view.printAnswer(info);
    }

    @Override
    public void midOrganizationSalary() {
        String info = service.midOrganizationSalary();
        view.printAnswer(info);
    }

    @Override
    public void midDepartmentSalary() {
        String info = service.midDepartmentSalary();
        view.printAnswer(info);
    }

    @Override
    public void top10LongTimeWorked() {
        String info = service.top10LongTimeWorked();
        view.printAnswer(info);
    }

    @Override
    public void organizationOutput() {
        String info = service.organizationOutput();
        view.printAnswer(info);
    }

    @Override
    public void organizationInput() {
        String info = service.organizationInput();
        view.printAnswer(info);
    }

}