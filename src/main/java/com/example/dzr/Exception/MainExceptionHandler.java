package com.example.dzr.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler({FoundException.class, NotFoundException.class})
    public ResponseEntity<?> foundAndNotFoundEx(RuntimeException e){
        return ResponseEntity.ok(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> runtimeException(RuntimeException e){
        return ResponseEntity.ok(new AppError(HttpStatus.BAD_REQUEST.value(), "Упс, что то случилось."));
    }
}
