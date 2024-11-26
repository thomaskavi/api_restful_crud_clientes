package com.thomaskavi.api_restful_crud_clientes.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thomaskavi.api_restful_crud_clientes.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class ClientDTO {

  private Long id;
  @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 carácteres")
  @NotBlank(message = "Nome é obrigatório")
  private String name;

  @Size(min = 11, max = 11, message = "CPF deve ter apenas 11 dígitos. Informe apenas números")
  private String cpf;

  @Positive(message = "Renda deve ser positivo")
  private Double income;

  @PastOrPresent(message = "A data de nascimento deve estar no passado ou ser hoje. Formato esperado: yyyy-MM-dd")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @PositiveOrZero(message = "A quantidade de filhos não pode ser menor do que 0")
  private Integer children;

  public ClientDTO(Client entity) {
    id = entity.getId();
    name = entity.getName();
    cpf = entity.getCpf();
    income = entity.getIncome();
    birthDate = entity.getBirthDate();
    children = entity.getChildren();
  }

}
