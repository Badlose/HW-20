package pro.sky.skyproemployeebook;

import org.springframework.web.bind.annotation.*;
import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.Service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> printEmployeeList() {
        return employeeService.printEmployeeList();
    }


    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);

        return employeeService.add(employee);
    }


    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);

        return employeeService.remove(employee);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        Employee employee = new Employee(firstName, lastName);

        return employeeService.find(employee);
    }
}
