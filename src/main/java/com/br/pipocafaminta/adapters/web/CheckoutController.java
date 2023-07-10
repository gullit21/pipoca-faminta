package com.br.pipocafaminta.adapters.web;

import com.br.pipocafaminta.adapters.web.annotations.PipocaFamintaController;
import com.br.pipocafaminta.adapters.web.mapper.checkout.CheckoutWebMapper;
import com.br.pipocafaminta.application.domain.checkout.CheckoutRQ;
import com.br.pipocafaminta.application.domain.checkout.CheckoutRS;
import com.br.pipocafaminta.application.port.incoming.checkout.CheckoutUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@PipocaFamintaController
public class CheckoutController {

    private final CheckoutUseCase checkoutUseCase;
    private final CheckoutWebMapper checkoutWebMapper;

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutRS> checkoutPedido(@RequestBody CheckoutRQ checkoutRQ) {
        var checkout = checkoutUseCase.checkoutPedido(checkoutRQ);

        return ResponseEntity.ok(checkoutWebMapper.toCheckoutRS(checkout));
    }

    @GetMapping("/checkout/pedido/{id}")
    public ResponseEntity<CheckoutRS> buscarCheckoutPorPedido(@PathVariable Long id) {
        var checkout = checkoutUseCase.buscarCheckoutPorPedido(id);

        return ResponseEntity.ok(checkoutWebMapper.toCheckoutRS(checkout));
    }
}
