package pro.sky.MockitoHW;

import pro.sky.MockitoHW.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentServiceImplTestConstants {
    public static final Employee ARTEM_EMPLOYEE = new Employee("Артём", 1, 40000);
    public static final Integer ARTEM_SALARY = 40000;
    public static final Employee DIMA_EMPLOYEE = new Employee("Дима", 1, 25000);
    public static final Integer DIMA_SALARY = 25000;
    public static final Employee NIKITA_EMPLOYEE = new Employee("Никита", 1, 39000);
    public static final Integer NIKITA_SALARY = 39000;
    public static final Employee MAKSIM_EMPLOYEE = new Employee("Максим", 2, 75000);

    public static final List<Employee> EMPLOYEE_LIST
            = new ArrayList<>(List.of(ARTEM_EMPLOYEE, DIMA_EMPLOYEE, NIKITA_EMPLOYEE, MAKSIM_EMPLOYEE));
    public static final List<Employee> EMPLOYEES_1_DEPARTMENT
            = new ArrayList<>(List.of(ARTEM_EMPLOYEE, DIMA_EMPLOYEE, NIKITA_EMPLOYEE));
    public static final Map<Integer, List<Employee>> EMPLOYEE_BY_DEPARTMENTS
            = new HashMap<>(Map.of(1, EMPLOYEES_1_DEPARTMENT, 2, new ArrayList<>(List.of(MAKSIM_EMPLOYEE))));
    public static final List<Employee> EMPTY_EMPLOYEE_LIST
            = new ArrayList<>();
}