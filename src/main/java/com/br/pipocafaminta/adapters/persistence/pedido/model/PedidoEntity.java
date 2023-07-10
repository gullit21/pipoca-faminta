package com.br.pipocafaminta.adapters.persistence.pedido.model;

import com.br.pipocafaminta.adapters.persistence.cliente.model.ClienteEntity;
import com.br.pipocafaminta.adapters.persistence.produto.model.ProdutoEntity;
import com.br.pipocafaminta.application.domain.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pedidos")
@NoArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clienteId", columnDefinition = "int4")
    private ClienteEntity cliente;

    private LocalDateTime dataConfimacao;
    private LocalDateTime dataEntrega;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private BigDecimal valor;

//    @OneToMany(mappedBy = "pedido")
//    @JoinTable(name = "pedido_produtos",
//            joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "produdo_id", referencedColumnName = "id")
//    )
//    private List<ProdutoEntity> produtos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProdutoEntity> pedidoProduto;
}
