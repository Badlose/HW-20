package pro.sky.skyproemployeebook.Employee;

import java.util.Objects;

public class Employee {
    private final String employeeFirstName;
    private final String employeeLastName;
//    private final int employeeId;
//    private static int counter = 0;


    public Employee(String employeeFirstNAme, String employeeLastNAme) {
        this.employeeFirstName = employeeFirstNAme;
        this.employeeLastName = employeeLastNAme;
//        this.employeeId = counter;
//        counter++;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

//    public int getEmployeeId() {
//        return employeeId;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstNAme='" + employeeFirstName + '\'' +
                ", employeeLastNAme='" + employeeLastName + '\'' +
//                ", employeeId='" + employeeId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeFirstName, employee.employeeFirstName) && Objects.equals(employeeLastName, employee.employeeLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName);
    }
}