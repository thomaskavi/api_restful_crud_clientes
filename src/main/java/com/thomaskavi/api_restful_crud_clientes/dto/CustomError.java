package com.thomaskavi.api_restful_crud_clientes.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomError {

  private Instant timestamp;
  private Integer status;
  private String error;
  private String path;

}
