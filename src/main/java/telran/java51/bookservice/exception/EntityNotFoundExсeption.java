package telran.java51.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundExсeption extends RuntimeException {
 public final static long serialVersionUID = 1;

}
