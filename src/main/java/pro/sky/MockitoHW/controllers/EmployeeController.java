package pro.sky.MockitoHW.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.MockitoHW.domain.Employee;
import pro.sky.MockitoHW.exceptions.BadRequestException;
import pro.sky.MockitoHW.exceptions.EmployeeAlreadyAddedException;
import pro.sky.MockitoHW.exceptions.EmployeeNotFoundException;
import pro.sky.MockitoHW.service.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public String addWorker(@RequestParam("name") String name,
                            @RequestParam("department") Integer department,
                            @RequestParam("salary") Integer salary) {
        try {
            employeeService.addEmployee(name, department, salary);
            return "Сотрудник успешно добавлен!";
        }
        catch (EmployeeAlreadyAddedException e) {
            System.out.println("Пользователь пытается добавить уже существующего работника!");
            throw new EmployeeAlreadyAddedException();
        }
        catch (BadRequestException | org.apache.coyote.BadRequestException e) {
            System.out.println("Пользователь ввёл некоректные данные!");
            throw new BadRequestException();
        }
    }

    @GetMapping(path = "/employee/remove")
    public String removeWorker(@RequestParam("name") String name) {
        try {
            employeeService.removeEmployee(name);
            return "Сотрудник успешно удалён!";
        }
        catch (EmployeeNotFoundException e) {
            System.out.println("Пользователь пытается удалить несуществующего работника!");
            throw new EmployeeNotFoundException();
        }
    }

    @GetMapping(path = "/employee/find")
    public Employee findWorker(@RequestParam("name") String name) {
        try {
            return employeeService.findEmployee(name);
        }
        catch (EmployeeNotFoundException e) {
            System.out.println("Пользователь пытается найти несуществующего работника!");
            throw new EmployeeNotFoundException();
        }
    }
}
