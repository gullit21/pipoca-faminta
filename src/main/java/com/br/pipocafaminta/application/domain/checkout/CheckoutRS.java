package com.br.pipocafaminta.application.domain.checkout;

import com.br.pipocafaminta.application.domain.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRS {

    private Long id;
    private Pedido pedido;
    private BigDecimal valor;
}
