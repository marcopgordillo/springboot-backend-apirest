package com.example.springbootbackendapirest.models.services;

import com.example.springbootbackendapirest.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();
}
