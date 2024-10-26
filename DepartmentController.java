package pro.sky.skyproemployeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployeebook.DepartmentService.DepartmentService;
import pro.sky.skyproemployeebook.Employee.Employee;

import java.util.List;
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
    public List<Employee> getEmployeeByDept(@RequestParam(defaultValue = "departmentId") String departmentId) {
        if (departmentId.equals("departmentId")) {
            return departmentService.getEmployeeSortedByDept();
        } else {
            return departmentService.getEmployeeByDept(departmentId);
        }
    }

    @RequestMapping("/min-salary")
    public Optional<Employee> getMinSalaryEmployeeByDept(@RequestParam(value = "departmentId") Integer deptId) {
        return departmentService.getMinSalaryEmployeeByDept(deptId);
    }

    @RequestMapping("/max-salary")
    public Optional<Employee> getMaxSalaryEmployeeByDept(@RequestParam(value = "departmentId") Integer deptId) {
        return departmentService.getMaxSalaryEmployeeByDept(deptId);
    }
}
