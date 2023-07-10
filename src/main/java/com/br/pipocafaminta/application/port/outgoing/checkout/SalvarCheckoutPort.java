package com.br.pipocafaminta.application.port.outgoing.checkout;

import com.br.pipocafaminta.application.domain.checkout.Checkout;

public interface SalvarCheckoutPort {

    Checkout save(Checkout checkout);

}
