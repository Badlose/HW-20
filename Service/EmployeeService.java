package pro.sky.skyproemployeebook.Service;

import pro.sky.skyproemployeebook.Employee.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Map.Entry<Employee, Integer>> printEmployees();
}
