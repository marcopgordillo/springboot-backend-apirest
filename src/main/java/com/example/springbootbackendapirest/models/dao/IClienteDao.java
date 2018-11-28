package com.example.springbootbackendapirest.models.dao;

import com.example.springbootbackendapirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
