package pro.sky.MockitoHW;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.MockitoHW.exceptions.EmployeeStorageIsEmptyException;
import pro.sky.MockitoHW.service.DepartmentService;
import pro.sky.MockitoHW.service.DepartmentServiceImp;
import pro.sky.MockitoHW.service.EmployeeServiceImp;
import static pro.sky.MockitoHW.DepartmentServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest
{
    @InjectMocks
    private EmployeeServiceImp mockEmployeeService = Mockito.mock(EmployeeServiceImp.class);

    private final DepartmentService out = new DepartmentServiceImp(mockEmployeeService);

    public void createMock() {
        Mockito.when(mockEmployeeService.findAll()).thenReturn(EMPLOYEE_LIST);
    }

    public void createInvalidMock() {
        Mockito.when(mockEmployeeService.findAll()).thenReturn(EMPTY_EMPLOYEE_LIST);
    }

    @Test
    public void maxEmployeeSalary() {
        createMock();
        Assertions.assertEquals(out.maxEmployeeSalary(1), ARTEM_SALARY);
    }

    @Test
    public void invalidMaxEmployeeSalary() {
        createInvalidMock();
        Assertions.assertThrows(EmployeeStorageIsEmptyException.class,
                () -> out.maxEmployeeSalary(1));
    }

    @Test
    public void minEmployeeSalary() {
        createMock();
        Assertions.assertEquals(out.minEmployeeSalary(1), DIMA_SALARY);
    }

    @Test
    public void invalidMinEmployeeSalary() {
        createInvalidMock();
        Assertions.assertThrows(EmployeeStorageIsEmptyException.class,
                () -> out.minEmployeeSalary(1));
    }

    @Test
    public void salarySumByDepartment() {
        createMock();
        Assertions.assertEquals(out.salarySumByDepartment(1), ARTEM_SALARY + DIMA_SALARY + NIKITA_SALARY);
    }

    @Test
    public void invalidSalarySumByDepartment() {
        createInvalidMock();
        Assertions.assertThrows(EmployeeStorageIsEmptyException.class,
                () -> out.salarySumByDepartment(1));
    }

    @Test
    public void allEmployeesByDepartmentsWithParameters() {
        createMock();
        Assertions.assertEquals(out.allEmployeesByDepartments(1), EMPLOYEES_1_DEPARTMENT);
    }

    @Test
    public void invalidAllEmployeesByDepartmentsWithParameters() {
        createInvalidMock();
        Assertions.assertThrows(EmployeeStorageIsEmptyException.class,
                () -> out.allEmployeesByDepartments(1));
    }

    @Test
    public void allEmployeesByDepartments() {
        createMock();
        Assertions.assertEquals(out.allEmployeesByDepartments(), EMPLOYEE_BY_DEPARTMENTS);
    }

    @Test
    public void invalidAllEmployeesByDepartments() {
        createInvalidMock();
        Assertions.assertThrows(EmployeeStorageIsEmptyException.class,
                () -> out.allEmployeesByDepartments());
    }
}