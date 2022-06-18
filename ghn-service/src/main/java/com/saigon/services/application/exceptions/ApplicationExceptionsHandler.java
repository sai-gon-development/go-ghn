package com.saigon.services.application.exceptions;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.saigon.services.application.apis.models.reponses.Notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionsHandler {

  @ExceptionHandler(value = { ApplicationException.class })
  public ResponseEntity<Notification> handleUserServiceException(ApplicationException ex, WebRequest request) {
    Notification errorMessage = new Notification(ZonedDateTime.now(), ex.getMessage());
    log.error(ex.getMessage());
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), ex.getHttpStatus());
  }

  @ExceptionHandler(value = { Exception.class })
  public ResponseEntity<Notification> handleUserServiceException(Exception ex, WebRequest request) {
    Notification errorMessage = new Notification(ZonedDateTime.now(), ex.getMessage());
    log.error(ex.getMessage());
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    log.error(ex.getMessage());
    return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

}
