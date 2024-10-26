package pro.sky.skyproemployeebook.Service;

import pro.sky.skyproemployeebook.Model.Employee;
import pro.sky.skyproemployeebook.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeNotFoundException;
import pro.sky.skyproemployeebook.Exceptions.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException;

    Employee remove(int id) throws EmployeeNotFoundException;

    Employee find(int id) throws EmployeeNotFoundException;

    Iterable<Employee> printEmployees();

    List<Employee> getAll();
}
