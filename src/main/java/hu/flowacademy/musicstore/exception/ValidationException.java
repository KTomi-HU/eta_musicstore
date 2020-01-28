package hu.flowacademy.musicstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidationException extends ResponseStatusException {

    public ValidationException(String reason) { super(HttpStatus.BAD_REQUEST, reason); }
}
