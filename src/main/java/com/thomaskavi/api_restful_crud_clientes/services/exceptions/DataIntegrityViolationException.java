package com.thomaskavi.api_restful_crud_clientes.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

  DataIntegrityViolationException(String msg) {
    super(msg);
  }
}
