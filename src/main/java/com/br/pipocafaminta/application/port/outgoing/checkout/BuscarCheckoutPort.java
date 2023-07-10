package com.br.pipocafaminta.application.port.outgoing.checkout;

import com.br.pipocafaminta.application.domain.checkout.Checkout;

public interface BuscarCheckoutPort {

    Checkout findById(Long id);

    Checkout findByPedidoId(Long id);
}
