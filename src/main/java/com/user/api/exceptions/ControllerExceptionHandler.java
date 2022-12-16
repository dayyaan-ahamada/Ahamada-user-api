package com.user.api.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
  
    @ExceptionHandler({ResponseStatusException.class})
  protected ResponseEntity<Object> handleConflict(
    ResponseStatusException ex, WebRequest request) {
      String bodyOfResponse = ex.getStatus() + " " + ex.getReason();
      log.error(bodyOfResponse);
      return handleExceptionInternal(ex, "Error : "+bodyOfResponse, 
        new HttpHeaders(), HttpStatus.CONFLICT, request);
  }
}