package pro.sky.MockitoHW.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.MockitoHW.domain.Employee;
import pro.sky.MockitoHW.exceptions.BadRequestException;
import pro.sky.MockitoHW.exceptions.EmployeeAlreadyAddedException;
import pro.sky.MockitoHW.exceptions.EmployeeNotFoundException;
import pro.sky.MockitoHW.exceptions.EmployeeStorageIsEmptyException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceImp() {employees = new HashMap<>();}

    @Override
    public void addEmployee(String name, Integer department, Integer salary) {
            if (!(employees.containsKey(name))) {
            if (!(StringUtils.containsAny(name, "1234567890-+=_!@#$%^&*()\\|/\"'?.,<>;:`~") || name.isEmpty())) {
                String newName = StringUtils.capitalize(name.toLowerCase());
                employees.put(newName, new Employee(newName, department, salary));
            }
            else {
                throw new BadRequestException();
            }
        }
        else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public void removeEmployee(String name) {
        if (employees.containsKey(name)) {
            employees.remove(name);
        }
        else{
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String name) {
        if (employees.containsKey(name)) {
            return employees.get(name);
        }
        else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> findAll() {
        if (!(employees.isEmpty())) {
            return Collections.unmodifiableCollection(employees.values());
        }
        else {
            throw new EmployeeStorageIsEmptyException();
        }
    }
}