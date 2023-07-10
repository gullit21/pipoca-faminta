package com.br.pipocafaminta.application.port.outgoing.cliente;

import com.br.pipocafaminta.application.domain.cliente.Cliente;

public interface SalvarClientePort {

    Cliente save(Cliente cliente);

}
