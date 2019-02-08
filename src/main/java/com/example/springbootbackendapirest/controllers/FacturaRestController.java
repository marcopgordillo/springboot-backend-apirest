package com.example.springbootbackendapirest.controllers;

import com.example.springbootbackendapirest.models.entity.Factura;
import com.example.springbootbackendapirest.models.entity.Producto;
import com.example.springbootbackendapirest.models.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://clientes-app-angular-c559f.firebaseapp.com"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    private final IClienteService clienteService;

    public FacturaRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return clienteService.findFacturaById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.deleteFacturaById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/facturas/filtrar-productos/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String term) {
        return clienteService.findProductoByNombre(term);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return clienteService.saveFactura(factura);
    }
}
