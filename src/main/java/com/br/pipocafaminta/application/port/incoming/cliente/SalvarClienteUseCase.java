package com.br.pipocafaminta.application.port.incoming.cliente;

import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.cliente.ClienteRQ;

public interface SalvarClienteUseCase {

    Cliente save(ClienteRQ clienteRQ);

}
