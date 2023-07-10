package com.br.pipocafaminta.adapters.persistence.checkout.model;

import com.br.pipocafaminta.adapters.persistence.pedido.model.PedidoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "checkouts")
@NoArgsConstructor
public class CheckoutEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedidoId", columnDefinition = "int4")
    private PedidoEntity pedido;

    private BigDecimal valor;
}
