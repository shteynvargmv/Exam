package model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee implements Serializable {
    private String name; //ФИО
    private LocalDate birthDate; //Дата рождения
    private String telNumber; //Пол
    private String gender; //Контактный телефон
    private String position; //Должность
    private String department; //Отдел
    private Employee boss; //Начальник
    private LocalDate employmentDate; //Дата приема на работу
    private Integer salary; //Зарплата
    private Set<String> subordinates; //Подчиненные

    public Employee(String name, LocalDate birthDate, String gender, String telNumber, String position, String department, Employee boss, LocalDate employmentDate, Integer salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
        this.gender = gender;
        this.position = position;
        this.department = department;
        this.boss = boss;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.subordinates = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public Set<String> getSubordinates(){
        return subordinates;
    }

    public void setBoss(Employee boss){
        this.boss = boss;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public void setEmploymentDate(LocalDate employmentDate){
        this.employmentDate = employmentDate;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public boolean addSubordinates(String name) {
       return subordinates.add(name);
    }
    public boolean addSubordinates(Set<String> names) {
        return subordinates.addAll(names);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthDate, employee.birthDate) && Objects.equals(telNumber, employee.telNumber) && Objects.equals(gender, employee.gender) && Objects.equals(position, employee.position) && Objects.equals(department, employee.department) && Objects.equals(boss, employee.boss) && Objects.equals(employmentDate, employee.employmentDate) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, telNumber, gender, position, department, boss, employmentDate, salary);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ФИО=" + name + '\'');
        stringBuilder.append(", День рождения=" + birthDate);
        stringBuilder.append(", Пол='" + gender + '\'');
        stringBuilder.append(", Контактный телефон='" + telNumber + '\'');
        stringBuilder.append(", Должность='" + position + '\'');
        stringBuilder.append(", Отдел='" + department + '\'');
        stringBuilder.append(", Дата приема на работу=" + employmentDate);
        stringBuilder.append(", Зарплата=" + salary);
        if (boss != null) {
            stringBuilder.append(", Начальник=" + boss.getName());
        }
        return stringBuilder.toString();
    }
}
