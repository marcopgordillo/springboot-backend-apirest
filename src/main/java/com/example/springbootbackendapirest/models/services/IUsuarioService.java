package com.example.springbootbackendapirest.models.services;

import com.example.springbootbackendapirest.models.entity.Usuario;

public interface IUsuarioService {
  Usuario findByUsername(String username);
}
