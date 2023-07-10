package com.br.pipocafaminta.adapters.persistence.pedido.model;

import com.br.pipocafaminta.adapters.persistence.produto.model.ProdutoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "pedido_produtos")
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProdutoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    private Integer quantidade;
}
