package com.br.pipocafaminta.application.services.cliente;

import com.br.pipocafaminta.adapters.web.mapper.cliente.ClienteWebMapper;
import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.cliente.ClienteRQ;
import com.br.pipocafaminta.application.port.incoming.cliente.BuscarClienteUseCase;
import com.br.pipocafaminta.application.port.incoming.cliente.SalvarClienteUseCase;
import com.br.pipocafaminta.application.port.outgoing.cliente.BuscarClientePort;
import com.br.pipocafaminta.application.port.outgoing.cliente.SalvarClientePort;

import java.util.List;

public class ClienteService implements SalvarClienteUseCase, BuscarClienteUseCase {

    private final SalvarClientePort salvarClientePort;
    private final BuscarClientePort buscarClientePort;
    private final ClienteWebMapper clienteWebMapper;

    public ClienteService(SalvarClientePort salvarClientePort,
                          BuscarClientePort buscarClientePort,
                          ClienteWebMapper clienteWebMapper) {
        this.salvarClientePort = salvarClientePort;
        this.buscarClientePort = buscarClientePort;
        this.clienteWebMapper = clienteWebMapper;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return buscarClientePort.findByCpf(cpf);
    }

    @Override
    public List<Cliente> findAll() {
        return buscarClientePort.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return buscarClientePort.findById(id);
    }

    @Override
    public Cliente save(ClienteRQ clienteRQ) {
        var cliente = clienteWebMapper.toCliente(clienteRQ);
        return salvarClientePort.save(cliente);
    }
}
