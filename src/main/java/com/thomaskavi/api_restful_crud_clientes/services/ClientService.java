package com.thomaskavi.api_restful_crud_clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thomaskavi.api_restful_crud_clientes.dto.ClientDTO;
import com.thomaskavi.api_restful_crud_clientes.entities.Client;
import com.thomaskavi.api_restful_crud_clientes.repositories.ClientRepository;
import com.thomaskavi.api_restful_crud_clientes.services.exceptions.DatabaseException;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  @Transactional(readOnly = true)
  public ClientDTO findById(Long id) {
    Client client = repository.findById(id)
        .orElseThrow(() -> new DatabaseException("O Id fornecido não foi encontrado"));
    return new ClientDTO(client);
  }
}
