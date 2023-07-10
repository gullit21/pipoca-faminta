package com.br.pipocafaminta.application.domain.pedido;

import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.enums.StatusEnum;
import com.br.pipocafaminta.application.domain.produto.Produto;
import com.br.pipocafaminta.application.domain.produto.ProdutoRS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRS {

    private Long id;
    private Cliente cliente;

    private StatusEnum status;

    private BigDecimal valor;

    private List<ProdutoRS> produtos;
}
