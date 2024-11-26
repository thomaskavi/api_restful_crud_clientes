package com.thomaskavi.api_restful_crud_clientes.services.exceptions;

public class MethodArgumentNotValidException extends RuntimeException {

  MethodArgumentNotValidException(String msg) {
    super(msg);
  }

  public Object getBindingResult() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getBindingResult'");
  }
}
