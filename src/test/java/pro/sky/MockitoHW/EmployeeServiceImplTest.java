package pro.sky.MockitoHW;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.MockitoHW.exceptions.EmployeeAlreadyAddedException;
import pro.sky.MockitoHW.exceptions.EmployeeNotFoundException;
import pro.sky.MockitoHW.service.EmployeeService;
import pro.sky.MockitoHW.service.EmployeeServiceImp;

import java.util.stream.Stream;

import static pro.sky.MockitoHW.EmployeeServiceImplTestConstants.*;

public class EmployeeServiceImplTest {
    private final EmployeeService out = new EmployeeServiceImp();

    public static Stream<Arguments> provideParamsForAddEmployee() {
        return Stream.of(
                Arguments.of(ARTEM_NAME, TEN_NUMB, TEN_NUMB),
                Arguments.of(PETYA_NAME, HUNDRED_NUMB, TWO_HUNDRED_NUMB),
                Arguments.of(MAKSIM_NAME, TWENTY_NUMB, ZERO_NUMB)
        );
    }

    public static Stream<Arguments> provideParamsForRemoveEmployee() {
        return Stream.of(
                Arguments.of(PETYA_NAME)
        );
    }

    public static Stream<Arguments> provideParamsForFindEmployee() {
        return Stream.of(
                Arguments.of(ARTEM_NAME)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddEmployee")
    public void addEmployee(String name, int department, int salary) throws BadRequestException {
        out.addEmployee(name, department, salary);
    }

    @Test
    public void invalidAddEmployee() throws BadRequestException {
        out.addEmployee(PETYA_NAME, HUNDRED_NUMB, TWO_HUNDRED_NUMB);

        Assertions.assertThrows(pro.sky.MockitoHW.exceptions.BadRequestException.class,
                () -> out.addEmployee(EMPTY_NAME, TEN_NUMB, ZERO_NUMB));
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(PETYA_NAME, HUNDRED_NUMB, TWO_HUNDRED_NUMB));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForRemoveEmployee")
    public void removeEmployee(String name) throws BadRequestException {
        out.addEmployee(PETYA_NAME, HUNDRED_NUMB, TWO_HUNDRED_NUMB);

        out.removeEmployee(name);
    }

    @Test
    public void invalidRemoveEmployee() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(EMPTY_NAME));
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(PETYA_NAME));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForFindEmployee")
    public void findEmployee(String name) throws BadRequestException {
        out.addEmployee(ARTEM_NAME, HUNDRED_NUMB, TWO_HUNDRED_NUMB);

        out.findEmployee(name);
    }

    @Test
    public void invalidFindEmployee() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(EMPTY_NAME));
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(PETYA_NAME));
    }
}
