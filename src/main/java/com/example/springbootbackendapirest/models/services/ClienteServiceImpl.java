package com.example.springbootbackendapirest.models.services;

import com.example.springbootbackendapirest.models.dao.IClienteDao;
import com.example.springbootbackendapirest.models.dao.IFacturaDao;
import com.example.springbootbackendapirest.models.dao.IProductoDao;
import com.example.springbootbackendapirest.models.entity.Cliente;
import com.example.springbootbackendapirest.models.entity.Factura;
import com.example.springbootbackendapirest.models.entity.Producto;
import com.example.springbootbackendapirest.models.entity.Region;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;
    private final IFacturaDao facturaDao;
    private final IProductoDao productoDao;

    public ClienteServiceImpl(IClienteDao clienteDao, IFacturaDao facturaDao, IProductoDao productoDao) {
        this.clienteDao = clienteDao;
        this.facturaDao = facturaDao;
        this.productoDao = productoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) this.clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
      return this.clienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Cacheable("regiones")
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return clienteDao.findAllRegiones();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void deleteFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return productoDao.findByNombreContainingIgnoreCase(term);
    }
}
