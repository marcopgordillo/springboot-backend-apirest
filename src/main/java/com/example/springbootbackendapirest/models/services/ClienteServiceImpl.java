package com.example.springbootbackendapirest.models.services;

import com.example.springbootbackendapirest.models.dao.IClienteDao;
import com.example.springbootbackendapirest.models.entity.Cliente;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;

    public ClienteServiceImpl(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    @Cacheable("clientes")
    @CacheEvict(key = "#clientes.id")
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) this.clienteDao.findAll();
    }

    @Override
    @Cacheable("clientes")
    @CacheEvict(key = "#clientes.id")
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
}
