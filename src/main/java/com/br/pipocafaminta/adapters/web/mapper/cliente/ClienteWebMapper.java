package com.br.pipocafaminta.adapters.web.mapper.cliente;

import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.cliente.ClienteRQ;
import com.br.pipocafaminta.application.domain.cliente.ClienteRS;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClienteWebMapper {

    Cliente toCliente(ClienteRQ clienteRQ);

    ClienteRS toClienteRS(Cliente clienteSaved);

    List<ClienteRS> toClienteRSList(List<Cliente> clienteRSList);
}
