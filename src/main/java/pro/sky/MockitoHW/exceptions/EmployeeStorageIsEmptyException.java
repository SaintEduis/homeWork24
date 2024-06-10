package pro.sky.MockitoHW.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.LOCKED)
public class EmployeeStorageIsEmptyException extends RuntimeException{
}
