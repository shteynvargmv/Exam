package controller;

public interface OrganizationController {
   void addEmployee(String name, String birthDateString, String gender, String telNumber, String position, String department, String bossName, String employmentDateString, String salaryString);
   public void deleteEmployee(String name);
   public void changeEmployeeBirthDate(String name, String birthDateString);
   public void changeEmployeeBoss(String name,String bossName);
   public void changeEmployeeDepartment(String name,String department);
   public void changeEmployeeEmploymentDate(String name,String employmentDateString);
   public void changeEmployeeGender(String name,String gender);
   public void changeEmployeePosition(String name,String position);
   public void changeEmployeeSalary(String name,String salaryString);
   public void changeEmployeeTelNumber(String name,String telNumber);
   public void searchEmployeeByBossName(String bossName);
   public void searchEmployeeByDepartment(String department);
   public void searchEmployeeByName(String name);
   public void searchEmployeeByPosition(String position);
   public void top10HighSalary();
   public void displayOrganizationStructure();
   public void midOrganizationSalary();
   public void midDepartmentSalary();
   public void top10LongTimeWorked();
   public void organizationOutput();
   public void organizationInput();
}
