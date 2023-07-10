package com.br.pipocafaminta.application.port.incoming.pedido;

import com.br.pipocafaminta.application.domain.pedido.Pedido;
import com.br.pipocafaminta.application.domain.pedido.PedidoRQ;

public interface FazerPedidoEtapaSobremesaUseCase {

    Pedido etapaSobremesa(PedidoRQ pedidoRQ);

}
