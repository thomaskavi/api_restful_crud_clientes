package com.thomaskavi.api_restful_crud_clientes.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thomaskavi.api_restful_crud_clientes.dto.CustomError;
import com.thomaskavi.api_restful_crud_clientes.services.exceptions.DatabaseException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
}
