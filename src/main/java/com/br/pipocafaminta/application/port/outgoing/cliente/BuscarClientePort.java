package com.br.pipocafaminta.application.port.outgoing.cliente;

import com.br.pipocafaminta.application.domain.cliente.Cliente;

import java.util.List;

public interface BuscarClientePort {

    Cliente findByCpf(String cpf);

    List<Cliente> findAll();

    Cliente findById(Long id);
}
