package com.br.pipocafaminta.application.port.incoming.checkout;

import com.br.pipocafaminta.application.domain.checkout.Checkout;
import com.br.pipocafaminta.application.domain.checkout.CheckoutRQ;

public interface CheckoutUseCase {

    Checkout checkoutPedido(CheckoutRQ checkoutRQ);

    Checkout buscarCheckoutPorPedido(Long id);
}
