package pro.sky.skyproemployeebook.Service;

import pro.sky.skyproemployeebook.Model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    int getSalarySum();

    long getTotalEmployees();

    Employee getMaxSalary();

    Employee getMinSalary();

    List<Employee> getEmployeeByDept(int deptId);

    Employee getMinSalaryEmployeeByDept(int deptId);

    Employee getMaxSalaryEmployeeByDept(int deptId);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDeptId();
}
