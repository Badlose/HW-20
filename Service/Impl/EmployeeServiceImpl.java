package pro.sky.skyproemployeebook.Service.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebook.Exceptions.IncorrectEmployeeNameException;
import pro.sky.skyproemployeebook.Model.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;
import pro.sky.skyproemployeebook.Service.EmployeeService;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int DEFAULT_CAPACITY = 7;
    private static final Map<Integer, Employee> employeesMap = new HashMap<>(DEFAULT_CAPACITY);
    private static int employeeId = 0;


    @PostConstruct
    public void initEmployees() {
        add("ivan", "ivanov", 1, 1000);
        add("ivan", "ivanov     ", 1, 1200);
        add("ivan", "Ivanov", 1, 1300);
        add("ivan", "Ivanov", 1, 1400);
        add("ivan", "Ivanov", 1, 1500);

    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException,
            IncorrectEmployeeNameException {

        if (employeesMap.size() >= DEFAULT_CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }

        checkName(firstName, lastName);

        Employee employee = new Employee(
                firstName,
                lastName,
                department,
                salary);

        if (employeesMap.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }


        if (isNotBlank(firstName) && isNotBlank(lastName)) {
            employeesMap.put(employeeId, employee);
        }

        employeeId++;
        return employee;
    }

    private void checkName(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new IncorrectEmployeeNameException();
        }
    }

    @Override
    public Employee remove(int id) throws EmployeeNotFoundException {
        if (!employeesMap.containsKey(id)) {
            throw new EmployeeNotFoundException();
        }
        employeesMap.remove(id);
        return employeesMap.get(id);
    }

    @Override
    public Employee find(int id) throws EmployeeNotFoundException {

        if (!employeesMap.containsKey(id)) {
            throw new EmployeeNotFoundException();
        }
        return employeesMap.get(id);
    }

    @Override
    public Collection<Employee> printEmployees() {
        return employeesMap.values();
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<Employee>(employeesMap.values().stream().toList());
    }
}

