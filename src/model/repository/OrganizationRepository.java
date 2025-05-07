package model.repository;

import model.entity.Employee;
import java.util.ArrayList;
import java.util.List;

public class OrganizationRepository {
    private List<Employee> employees;

    public OrganizationRepository() {
        employees = new ArrayList<>();
    }

    public String add(Employee employee) {
        String result;
        if (employees.add(employee) == true) {
            result = "Сотрудник успешно добавлен";
        } else {
            result = "При добавлении сотрудника возникла ошибка";
        }
        return result;
    }

}
