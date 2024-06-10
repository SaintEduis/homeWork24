package pro.sky.MockitoHW.service;

import pro.sky.MockitoHW.domain.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer maxEmployeeSalary(int department);

    Integer minEmployeeSalary(int department);

    Integer salarySumByDepartment(int department);

    List<Employee> allEmployeesByDepartments(int department);

    Map<Integer, List<Employee>> allEmployeesByDepartments();
}
