package model.service;

import controller.OrganizationControllerImpl;
import model.entity.Employee;
import model.repository.OrganizationRepository;

public class OrganizationService {
    private final OrganizationRepository repository;
    private final OrganizationControllerImpl controller;

    public OrganizationService(OrganizationControllerImpl controller) {
        this.controller = controller;
        repository = new OrganizationRepository();
    }

    public String addEmployee(String name) {
        Employee employee = new Employee(name);
        return repository.add(employee).toString();
    }

}
