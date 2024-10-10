package pro.sky.skyproemployeebook.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int DEFAULT_CAPACITY = 7;
    private static final List<Employee> employeesList = new ArrayList<>(DEFAULT_CAPACITY);


    @Override
    public Employee add(Employee employee) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {

        if (employeesList.size() >= DEFAULT_CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }

        if (employeesList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employeesList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(Employee employee) throws EmployeeNotFoundException {
        find(employee);
        employeesList.remove(employee);
        return employee;
    }

    @Override
    public Employee find(Employee employee) throws EmployeeNotFoundException {
        if (!employeesList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public List<Employee> printEmployeeList() {
        return Collections.unmodifiableList(employeesList);
    }
}

