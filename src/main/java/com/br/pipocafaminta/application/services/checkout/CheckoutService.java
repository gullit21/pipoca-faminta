package com.br.pipocafaminta.application.services.checkout;

import com.br.pipocafaminta.application.domain.checkout.Checkout;
import com.br.pipocafaminta.application.domain.checkout.CheckoutRQ;
import com.br.pipocafaminta.application.port.incoming.checkout.CheckoutUseCase;
import com.br.pipocafaminta.application.port.outgoing.checkout.BuscarCheckoutPort;
import com.br.pipocafaminta.application.port.outgoing.checkout.SalvarCheckoutPort;
import com.br.pipocafaminta.application.port.outgoing.pedido.BuscarPedidoPort;
import com.br.pipocafaminta.application.port.outgoing.pedido.SalvarPedidoPort;

public class CheckoutService implements CheckoutUseCase {

    private final BuscarPedidoPort buscarPedidoPort;
    private final SalvarPedidoPort salvarPedidoPort;
    private final BuscarCheckoutPort buscarCheckoutPort;
    private final SalvarCheckoutPort salvarCheckoutPort;

    public CheckoutService(BuscarPedidoPort buscarPedidoPort,
                           SalvarPedidoPort salvarPedidoPort,
                           BuscarCheckoutPort buscarCheckoutPort,
                           SalvarCheckoutPort salvarCheckoutPort) {
        this.buscarPedidoPort = buscarPedidoPort;
        this.salvarPedidoPort = salvarPedidoPort;
        this.buscarCheckoutPort = buscarCheckoutPort;
        this.salvarCheckoutPort = salvarCheckoutPort;
    }

    @Override
    public Checkout checkoutPedido(CheckoutRQ checkoutRQ) {
        var pedido = buscarPedidoPort.findById(checkoutRQ.getPedidoId());
        pedido.calculaValorTotal();
        pedido.statusPago();

        var checkout = Checkout.builder()
                .pedido(pedido)
                .valor(pedido.getValor())
                .build();

        checkout = salvarCheckoutPort.save(checkout);
        salvarPedidoPort.save(pedido);

        return checkout;
    }

    @Override
    public Checkout buscarCheckoutPorPedido(Long id) {
        return buscarCheckoutPort.findByPedidoId(id);
    }

}
