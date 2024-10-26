package pro.sky.skyproemployeebook.Model;

import java.util.Objects;

public class Employee {
    private final String employeeFirstName;
    private final String employeeLastName;
    private int departmentId;
    private  int salary;

    public Employee(String employeeFirstNAme, String employeeLastNAme, int department, int salary) {
        this.employeeFirstName = employeeFirstNAme;
        this.employeeLastName = employeeLastNAme;
        if (department <= 0 || department >= 6) {
            throw new IllegalArgumentException("Введен неверный отдел");
        } else {
            this.departmentId = department;
        }
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId &&
                salary == employee.salary &&
                Objects.equals(employeeFirstName, employee.employeeFirstName) &&
                Objects.equals(employeeLastName, employee.employeeLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", department=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}
