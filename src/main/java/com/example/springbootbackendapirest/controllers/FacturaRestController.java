package com.example.springbootbackendapirest.controllers;

import com.example.springbootbackendapirest.models.entity.Factura;
import com.example.springbootbackendapirest.models.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    private final IClienteService clienteService;

    public FacturaRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return clienteService.findFacturaById(id);
    }
}
