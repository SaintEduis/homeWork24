package pro.sky.MockitoHW.service;

import org.apache.coyote.BadRequestException;
import pro.sky.MockitoHW.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    void addEmployee(String name, Integer department, Integer salary) throws BadRequestException;

    void removeEmployee(String name);

    Employee findEmployee(String name);

    Collection<Employee> findAll();
}