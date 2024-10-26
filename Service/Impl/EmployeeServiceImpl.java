package pro.sky.skyproemployeebook.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebook.Model.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;
import pro.sky.skyproemployeebook.Service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int DEFAULT_CAPACITY = 7;
    private static final Map<Integer, Employee> employeesMap = new HashMap<>(DEFAULT_CAPACITY);
    private static int employeeId = 0;

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {

        if (employeesMap.size() >= DEFAULT_CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName, department, salary);

        if (employeesMap.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employeesMap.put(employeeId, employee);

        employeeId++;
        return employee;
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

