package pro.sky.skyproemployeebook.DepartmentService;

import pro.sky.skyproemployeebook.Employee.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    int getSalarySum();

    long getTotalEmployees();

    Optional<Employee> getMaxSalary();

    Optional<Employee> getMinSalary();

    List<Employee> getEmployeeByDept(String DeptNo);

    List<Employee> getEmployeeSortedByDept();

    Optional<Employee> getMaxSalaryEmployeeByDept(Integer deptId);

    Optional<Employee> getMinSalaryEmployeeByDept(Integer deptId);
}
