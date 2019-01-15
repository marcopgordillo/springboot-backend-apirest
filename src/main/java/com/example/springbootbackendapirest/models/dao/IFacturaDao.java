package com.example.springbootbackendapirest.models.dao;

import com.example.springbootbackendapirest.models.entity.Factura;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
    @Procedure(name = "factura_total")
    Optional<Factura> findFacturaWithTotalById(@Param("factura_id") Long id);
}
