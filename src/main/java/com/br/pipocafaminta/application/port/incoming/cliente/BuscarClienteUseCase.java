package com.br.pipocafaminta.application.port.incoming.cliente;

import com.br.pipocafaminta.application.domain.cliente.Cliente;

import java.util.List;

public interface BuscarClienteUseCase {

    Cliente findByCpf(String cpf);

    List<Cliente> findAll();

    Cliente findById(Long cliente);
}
