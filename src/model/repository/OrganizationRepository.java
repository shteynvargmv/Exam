package model.repository;

import model.entity.Employee;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OrganizationRepository {
    private Map<String,Employee> employees;

    public OrganizationRepository() {
        employees = new HashMap<>();
    }

    public String add(Employee employee) {
        String result;
        String name = employee.getName();
        if (employees.containsKey(name)) {
            result = "Сотрудник " + name +" уже существует";
        }
        else {
            employees.put(name, employee);
            if (employees.containsKey(name)) {
                Employee boss = employee.getBoss();
                if (boss != null ) {
                    boss.addSubordinates(name);
                }
                result = "Сотрудник успешно добавлен";
            } else {
                result = "При добавлении сотрудника возникла ошибка";
            }
        }
        return result;
    }

    public String delete(Employee employee) {
        String result;
        String name = employee.getName();
        employees.remove(name);
        if (!employees.containsKey(name)) {
            Employee boss = employee.getBoss();
            //Переносим всех подчиненных в подчинение вышестоящему начальнику
            Set<String> subordinates = employee.getSubordinates();
            Iterator<String> iterator = subordinates.iterator();
            while (iterator.hasNext()){
                String subordinateName = iterator.next();
                Employee subordinate = employees.get(subordinateName);
                subordinate.setBoss(boss); //Если boss null, у подчиненных тоже очистим
            }
            if (boss != null ) {
                boss.addSubordinates(subordinates);
            }
            result = "Сотрудник успешно удален";
        } else {
            result = "При удалении сотрудника возникла ошибка";
        }
        return result;
    }

    public String changeEmployeeBoss(Employee employee, Employee newBoss){
        Employee oldBoss = employee.getBoss();
        String name = employee.getName();
        if (newBoss != null) {
            Employee newBossBoss = newBoss.getBoss();
            if (newBossBoss != null && newBossBoss.getName().equals(name)) {
                return "Ошибка ввода: " + name + " начальник " + newBoss.getName();
            }
        }
        Set<String> subordinates = new HashSet<>();
        if (oldBoss != null) {
            subordinates = oldBoss.getSubordinates();
            subordinates.remove(name);
        }
        if (newBoss != null) {
            subordinates = newBoss.getSubordinates();
            subordinates.add(name);
        }
        employee.setBoss(newBoss);
        return "Начальник успешно изменен";
    }

    public Employee search(String name){
        Employee employee = employees.get(name);
        return employee;
    }

    public String searchByBoss(Employee boss) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> subordinates = boss.getSubordinates();
        Iterator<String> iterator = subordinates.iterator();
        while (iterator.hasNext()) {
            String subordinate = iterator.next();
            stringBuilder.append(employees.get(subordinate).toString());
            stringBuilder.append("\n");
        }
        if (stringBuilder.isEmpty()){
            return "Сотрудники не найдены";
        } else {
            return stringBuilder.toString();
        }
    }

    public String searchByDepartment(String department) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if ( employee.getDepartment().equals(department)) {
                stringBuilder.append(employee.toString());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.isEmpty()){
            return "Сотрудники не найдены";
        } else {
            return stringBuilder.toString();
        }
    }

    public String searchByPosition(String position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if ( employee.getPosition().equals(position)) {
                stringBuilder.append(employee.toString());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.isEmpty()){
            return "Сотрудники не найдены";
        } else {
            return stringBuilder.toString();
        }
    }

    public String top10HighSalary() {
        StringBuilder stringBuilder = new StringBuilder();
        this.employees.values().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .limit(10).collect(Collectors.toList())
                .forEach(e-> stringBuilder.append(e.toString() + "\n"));
        if (stringBuilder.isEmpty()) {
            return "Сотрудники не найдены";
        } else {
            return stringBuilder.toString();
        }
    }

    private String getOrganizationStructure(Employee subordinate) {
        StringBuilder stringBuilder = new StringBuilder();
        subordinate.getSubordinates().stream()
                .forEach(s -> {
                    Employee newSubordinate = this.employees.get(s);
                    if (!subordinate.getDepartment().equals(newSubordinate.getDepartment())) {
                        stringBuilder.append(newSubordinate.getDepartment() + " " + newSubordinate.getName() + "\n");
                    }
                    stringBuilder.append(this.getOrganizationStructure(newSubordinate));
                });
        return stringBuilder.toString();
    }

    public String displayOrganizationStructure() {
        StringBuilder stringBuilder = new StringBuilder();
        this.employees.entrySet().stream()
                .filter(e -> ( e.getValue().getBoss() == null || e.getValue().getBoss().equals("") ))
                .forEach(e -> {
                    Employee employee = e.getValue();
                    stringBuilder.append(employee.getDepartment() + " " + employee.getName() + "\n");
                    employee.getSubordinates().stream()
                            .forEach(s -> {
                                Employee subordinate = this.employees.get(s);
                                if (!employee.getDepartment().equals(subordinate.getDepartment())) {
                                    stringBuilder.append(subordinate.getDepartment() + " " + subordinate.getName() + "/n");
                                }
                                stringBuilder.append(this.getOrganizationStructure(subordinate));
                            });
                } );


       if (stringBuilder.isEmpty()) {
           return "Сотрудники не найдены";
       } else {
           return stringBuilder.toString();
       }
    }

    public String midOrganizationSalary() {
        return "result";
    }

    public String midDepartmentSalary() {
        return "result";
    }

    public String top10LongTimeWorked() {
        return "result";
    }

    public String organizationOutput() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("organization.dat")));
            out.writeObject(this.employees);
            out.close();
            return "Файл успешно выгружен";
        } catch (FileNotFoundException e) {
            return "Ошибка выгрузки";
        } catch (IOException e) {
            return "Ошибка выгрузки";
        }
    }

    public String organizationInput() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(("organization.dat")));
            employees = (Map<String,Employee>) in.readObject();
            return "Файл успешно загружен";
        } catch (FileNotFoundException e) {
            return "Ошибка загрузки";
        } catch (IOException e) {
            return "Ошибка загрузки";
        } catch (ClassNotFoundException e) {
            return "Ошибка загрузки";
        }
    }
}
