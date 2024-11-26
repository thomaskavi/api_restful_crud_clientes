package com.thomaskavi.api_restful_crud_clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thomaskavi.api_restful_crud_clientes.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
