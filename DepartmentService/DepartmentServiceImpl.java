package pro.sky.skyproemployeebook.DepartmentService;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.EmployeeService.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int getSalarySum() {
        return employeeService.getAll().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public long getTotalEmployees() {
        return employeeService.getAll().stream()
                .count();
    }

    @Override
    public Optional<Employee> getMaxSalary() {
        return employeeService.getAll().stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getMinSalary() {
        return employeeService.getAll().stream()
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public List<Employee> getEmployeeByDept(String deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == Integer.parseInt(deptId))
                .toList();
    }

    @Override
    public List<Employee> getEmployeeSortedByDept() {
        return employeeService.getAll().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .toList();
    }

    @Override
    public Optional<Employee> getMaxSalaryEmployeeByDept(Integer deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == deptId)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getMinSalaryEmployeeByDept(Integer deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == deptId)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

}

