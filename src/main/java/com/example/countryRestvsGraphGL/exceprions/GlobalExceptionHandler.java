package com.example.countryRestvsGraphGL.exceprions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(ResourceNotFoundException exception) {
        final Errors errors = getErrors(exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        final Errors errors = getErrors(exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        final Errors errors = getErrors(exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errors);
    }

    private static Errors getErrors(Exception ex) {
        final List<String> errors = new ArrayList<>();
        for (var error : ex.getSuppressed()) {
            errors.add(error.getMessage());
        }

        return new Errors(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
    }
}
