package pro.sky.skyproemployeebook.Service;

import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(Employee employee) throws EmployeeNotFoundException;

    Employee find(Employee employee) throws EmployeeNotFoundException;

    List<Employee> printEmployeeList();
}
