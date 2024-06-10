package pro.sky.MockitoHW.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.MockitoHW.domain.Employee;
import pro.sky.MockitoHW.exceptions.EmployeeStorageIsEmptyException;
import pro.sky.MockitoHW.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {this.departmentService = departmentService;}

    @GetMapping(path = "/departments/max-salary")
    public Integer maxEmployeeSalary(@RequestParam("departmentId") int department) {
        try {
            return departmentService.maxEmployeeSalary(department);
        }
        catch (EmployeeStorageIsEmptyException e) {
            System.out.println("Пользователь ищет максимум среди одного или нуля работников!");
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @GetMapping(path = "/departments/min-salary")
    public Integer minSalaryWorker(@RequestParam("departmentId") int department) {
        try {
            return departmentService.minEmployeeSalary(department);
        }
        catch (EmployeeStorageIsEmptyException e) {
            System.out.println("Пользователь ищет минимум среди одного или нуля работников!");
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @GetMapping(path = "/departments/salary-sum")
    public Integer salarySumByDepartment(@RequestParam("departmentId") int department) {
        try {
            return departmentService.salarySumByDepartment(department);
        }
        catch (EmployeeStorageIsEmptyException e) {
            System.out.println("Пользователь суммирует зарплаты нуля работников!");
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public List<Employee> allDepartmentWorker(@RequestParam("departmentId") int department) {
        try {
            return departmentService.allEmployeesByDepartments(department);
        }
        catch (EmployeeStorageIsEmptyException e) {
            System.out.println("Пользователь вызывает показ работников при пустом списке работников!!");
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @GetMapping(path = "/departments/all")
    public Map<Integer, List<Employee>> allDepartmentWorker() {
        try {
            return departmentService.allEmployeesByDepartments();
        }
        catch (EmployeeStorageIsEmptyException e) {
            System.out.println("Пользователь вызывает показ работников при пустом списке работников!!");
            throw new EmployeeStorageIsEmptyException();
        }
    }
}
