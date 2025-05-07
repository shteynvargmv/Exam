package controller;

import model.entity.Employee;
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

    public void addEmployee(String name) {
        String info = service.addEmployee(name);
        view.printAnswer(info);
    }
}