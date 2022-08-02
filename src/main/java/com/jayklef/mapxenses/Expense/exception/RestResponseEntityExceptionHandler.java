package com.jayklef.mapxenses.Expense.exception;

import com.jayklef.mapxenses.Expense.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorMessage> CategoryNotFoundException(CategoryNotFoundException exception,
                                                                  WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setMessage(message.getMessage());
        message.setPath(message.getPath());
        message.setTimestamp(message.getTimestamp());
        message.setStatus(message.getStatus());

        exception.getMessage();
        request.getClass();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserNotFoundException(UserNotFoundException exception,
                                                              WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setMessage(message.getMessage());
        message.setPath(message.getPath());
        message.setTimestamp(message.getTimestamp());
        message.setStatus(message.getStatus());

        exception.getMessage();
        request.getClass();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<ErrorMessage> ExpenseNotFoundException(ExpenseNotFoundException exception,
                                                                 WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setMessage(message.getMessage());
        message.setPath(message.getPath());
        message.setTimestamp(message.getTimestamp());
        message.setStatus(message.getStatus());

        exception.getMessage();
        request.getClass();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }
}
