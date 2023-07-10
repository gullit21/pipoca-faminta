package com.br.pipocafaminta.adapters.persistence.mapper.cliente;

import com.br.pipocafaminta.adapters.persistence.cliente.model.ClienteEntity;
import com.br.pipocafaminta.application.domain.cliente.Cliente;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientePersistenceMapper {

    Cliente toCliente(ClienteEntity clienteEntity);

    List<Cliente> toclienteList(List<ClienteEntity> cliente);

    ClienteEntity toClienteEntity(Cliente cliente);
}
