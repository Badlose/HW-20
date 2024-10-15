package pro.sky.skyproemployeebook;

import org.springframework.web.bind.annotation.*;
import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.Service.EmployeeService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Map.Entry<Employee, Integer>> printEmployeeList() {
        return employeeService.printEmployees();
    }


    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName) {

        return employeeService.add(firstName, lastName);
    }


    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName) {

        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {

        return employeeService.find(firstName, lastName);
    }
}
