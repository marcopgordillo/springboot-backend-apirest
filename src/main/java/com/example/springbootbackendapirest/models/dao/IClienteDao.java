package com.example.springbootbackendapirest.models.dao;

import com.example.springbootbackendapirest.models.entity.Cliente;
import com.example.springbootbackendapirest.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {

    @Query("from Region") // Las consultas JPA se refieren a las clases no a la BD.
    List<Region> findAllRegiones();
}
