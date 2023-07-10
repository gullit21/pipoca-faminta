package com.br.pipocafaminta.application.port.outgoing.pedido;

import com.br.pipocafaminta.application.domain.pedido.Pedido;

public interface SalvarPedidoPort {

    Pedido save(Pedido pedido);
}
