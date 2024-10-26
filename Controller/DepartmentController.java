package pro.sky.skyproemployeebook.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployeebook.Service.DepartmentService;
import pro.sky.skyproemployeebook.Model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public int salarySum() {
        return departmentService.getSalarySum();
    }

    @RequestMapping("/count")
    public long count() {
        return departmentService.getTotalEmployees();
    }

    @RequestMapping("/max")
    public Optional<Employee> maxSalary() {
        return departmentService.getMaxSalary();
    }

    @RequestMapping("/min")
    public Optional<Employee> minSalary() {
        return departmentService.getMinSalary();
    }

    @RequestMapping("/all")
    public List<Employee> getEmployeeByDept(@RequestParam(defaultValue = "departmentId", required = false) int departmentId) {
            return departmentService.getEmployeeByDept(departmentId);
    }

    @RequestMapping("/all-grouped")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDeptId() {
        return departmentService.getAllEmployeesGroupedByDeptId();
    }

    @RequestMapping("/min-salary")
    public Employee getMinSalaryEmployeeByDept(@RequestParam(value = "departmentId", required = false) int deptId) {
        return departmentService.getMinSalaryEmployeeByDept(deptId);
    }

    @RequestMapping("/max-salary")
    public Employee getMaxSalaryEmployeeByDept(@RequestParam(value = "departmentId", required = false) int deptId) {
        return departmentService.getMaxSalaryEmployeeByDept(deptId);
    }
}
