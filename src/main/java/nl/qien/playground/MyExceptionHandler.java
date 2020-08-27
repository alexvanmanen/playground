package nl.qien.playground;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CONFLICT;



@RestControllerAdvice
public class MyExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    protected ResponseEntity<Object> handleSQLException(Exception ex, WebRequest request) {
        return createResponseEntity(ex.getMessage(), CONFLICT);
    }

    @ExceptionHandler({ EntityNotFoundException.class, NoSuchElementException.class })
    public ResponseEntity<Object> handleEntityNotFound(
            Exception ex, WebRequest request) {
        return createResponseEntity(ex.getMessage(), NOT_FOUND);
    }

    private ResponseEntity createResponseEntity(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(body(message, httpStatus), httpStatus);
    }

    private Map body(String message, HttpStatus httpStatus){
        HashMap<String, String> map = new HashMap<>();
        map.put("timestamp", new Timestamp(System.currentTimeMillis()).getTime()+"");
        map.put("Message", message);
        map.put("HTTP-code", httpStatus.value()+"");
        map.put("HTTP message", httpStatus.getReasonPhrase());
        return map;
    }



}
