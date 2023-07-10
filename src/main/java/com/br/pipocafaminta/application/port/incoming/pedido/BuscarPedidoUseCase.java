package com.br.pipocafaminta.application.port.incoming.pedido;

import com.br.pipocafaminta.application.domain.pedido.Pedido;

import java.util.List;

public interface BuscarPedidoUseCase {

    List<Pedido> listarTodos();

}
