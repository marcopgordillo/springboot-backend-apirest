package com.example.springbootbackendapirest.models.dao;

import com.example.springbootbackendapirest.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

// import org.springframework.data.jpa.repository.Query;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

  Usuario findByUsername(String username); // Aqui se consulta por el nombre del metodo

/*  @Query("select u from Usuario u where u.username=?1")
  Usuario findByUsername2(String username);*/ // esta forma no importa el nombre sino el query, los parametros se los toma en la consulta con ?1 o ?2 el numero de parametros pasados al metodo.
}
