package by.lilfrost.servermanager.exception.handler;

import by.lilfrost.servermanager.exception.ServerCreateErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerCreateErrorException.class)
    public ResponseEntity<?> serverCreateError(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(NOT_IMPLEMENTED).build();
    }
}
