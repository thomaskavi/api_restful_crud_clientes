package com.thomaskavi.api_restful_crud_clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @Transactional(readOnly = true)
  public Page<ClientDTO> findAll(Pageable pageable) {
    Page<Client> result = repository.findAll(pageable);
    return result.map(x -> new ClientDTO(x));
  }

  @Transactional
  public ClientDTO insert(ClientDTO dto) {
    Client entity = new Client();
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new ClientDTO(entity);
  }

  private void copyDtoToEntity(ClientDTO dto, Client entity) {
    entity.setId(dto.getId());
    entity.setName(dto.getName());
    entity.setCpf(dto.getCpf());
    entity.setIncome(dto.getIncome());
    entity.setBirthDate(dto.getBirthDate());
    entity.setChildren(dto.getChildren());

  }
}
