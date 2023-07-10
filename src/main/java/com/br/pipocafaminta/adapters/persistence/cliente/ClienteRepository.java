package com.br.pipocafaminta.adapters.persistence.cliente;

import com.br.pipocafaminta.adapters.exceptions.notfound.ClienteNotFoundException;
import com.br.pipocafaminta.adapters.persistence.mapper.cliente.ClientePersistenceMapper;
import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.port.outgoing.cliente.BuscarClientePort;
import com.br.pipocafaminta.application.port.outgoing.cliente.SalvarClientePort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteRepository implements BuscarClientePort, SalvarClientePort {

    private final SpringDataClienteRepository springDataClienteRepository;
    private final ClientePersistenceMapper clientePersistenceMapper;


    public ClienteRepository(SpringDataClienteRepository springDataClienteRepository,
                             ClientePersistenceMapper clientePersistenceMapper) {
        this.springDataClienteRepository = springDataClienteRepository;
        this.clientePersistenceMapper = clientePersistenceMapper;
    }

    @Override
    public Cliente save(Cliente cliente) {
        var clienteEntity = clientePersistenceMapper.toClienteEntity(cliente);
        var clienteSaved = springDataClienteRepository.save(clienteEntity);

        return clientePersistenceMapper.toCliente(clienteSaved);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        var clienteEntity = springDataClienteRepository.findByCpf(cpf)
                .orElseThrow(ClienteNotFoundException::new);
        return clientePersistenceMapper.toCliente(clienteEntity);
    }

    @Override
    public List<Cliente> findAll() {
        var clienteList = springDataClienteRepository.findAll();
        return clientePersistenceMapper.toclienteList(clienteList);
    }

    @Override
    public Cliente findById(Long id) {
        var clienteEntity = springDataClienteRepository.findById(id)
                .orElseThrow(ClienteNotFoundException::new);
        return clientePersistenceMapper.toCliente(clienteEntity);
    }
}
