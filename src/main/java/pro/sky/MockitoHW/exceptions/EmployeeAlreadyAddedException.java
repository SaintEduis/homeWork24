package pro.sky.MockitoHW.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND)
public class EmployeeAlreadyAddedException extends RuntimeException{
}
