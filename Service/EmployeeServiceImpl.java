package pro.sky.skyproemployeebook.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int DEFAULT_CAPACITY = 7;
    private static final Map<Employee, Integer> employeesMap = new HashMap<>(DEFAULT_CAPACITY);
    private static int employeeId = 0;

    @Override
    public Employee add(String firstName, String lastName) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {

        if (employeesMap.size() >= DEFAULT_CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);

        if (employeesMap.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException();
        }


        employeesMap.put(employee, employeeId);
        employeeId++;
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        if (!employeesMap.containsKey(employee)) {
            throw new EmployeeNotFoundException();
        }
        employeesMap.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        if (!employeesMap.containsKey(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Map.Entry<Employee, Integer>> printEmployees() {
        return Collections.unmodifiableCollection(employeesMap.entrySet());
    }
}

