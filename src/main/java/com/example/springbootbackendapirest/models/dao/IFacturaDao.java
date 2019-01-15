package com.example.springbootbackendapirest.models.dao;

import com.example.springbootbackendapirest.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
}
