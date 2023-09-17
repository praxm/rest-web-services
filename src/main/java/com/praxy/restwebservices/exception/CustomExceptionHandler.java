package com.praxy.restwebservices.exception;

import com.praxy.restwebservices.model.ErrorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)//custom Advice handling exception.
    public ResponseEntity<ErrorObject> handleAllException(Exception ex, WebRequest request) {
        ErrorObject errorObject =
                new ErrorObject(LocalDate.now(), ex.getLocalizedMessage(), request.getDescription(false));
        log.error(errorObject.toString());
        return new ResponseEntity(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //Override Spring provided exception handler method. No @Exceptionhandler annotation used.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorObject errorObject =
                new ErrorObject(LocalDate.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        log.error(errorObject.toString());
        return new ResponseEntity(errorObject, HttpStatus.BAD_REQUEST);
    }
}
