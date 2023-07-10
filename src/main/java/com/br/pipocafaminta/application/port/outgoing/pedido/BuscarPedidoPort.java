package com.br.pipocafaminta.application.port.outgoing.pedido;

import com.br.pipocafaminta.application.domain.pedido.Pedido;

import java.util.List;

public interface BuscarPedidoPort {

    List<Pedido> listarTodos();

    Pedido findById(Long id);
}
