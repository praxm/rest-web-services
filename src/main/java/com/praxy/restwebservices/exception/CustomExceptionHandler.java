package com.praxy.restwebservices.exception;

import com.praxy.restwebservices.model.ErrorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomException> handleException(Exception ex, WebRequest request) {
        ErrorObject errorObject =
                new ErrorObject(LocalDate.now(), ex.getLocalizedMessage(), request.getDescription(false));
        log.error(errorObject.toString());
        return new ResponseEntity(errorObject, HttpStatus.BAD_GATEWAY);
    }

}
