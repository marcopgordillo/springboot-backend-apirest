package com.example.springbootbackendapirest.models.dao;

import com.example.springbootbackendapirest.models.entity.Factura;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
    @Procedure(name = "factura_total")
    Factura findFacturaWithTotalById(@Param("factura_id") Long id);
}
