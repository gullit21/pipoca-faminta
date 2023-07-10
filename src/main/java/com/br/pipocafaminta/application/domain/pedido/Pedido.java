package com.br.pipocafaminta.application.domain.pedido;

import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.enums.StatusEnum;
import com.br.pipocafaminta.application.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Long id;
    private Cliente cliente;

    private LocalDateTime dataConfimacao;
    private LocalDateTime dataEntrega;

    private StatusEnum status;

    private BigDecimal valor;

    private List<Produto> produtos;

    public void statusEmAndamento() {
        this.status = StatusEnum.EM_ANDAMENTO;
    }

    public void statusConfirmado() {
        this.status = StatusEnum.CONFIRMADO;
        this.dataConfimacao = LocalDateTime.now();
    }

    public void statusPago() {
        this.status = StatusEnum.PAGO;
    }

    public void statusRecebido() {
        this.status = StatusEnum.RECEBIDO;
    }

    public void statusEmPreparacao() {
        this.status = StatusEnum.EM_PREPARACAO;
    }

    public void statusPronto() {
        this.status = StatusEnum.PRONTO;
    }

    public void statusEntregue() {
        this.status = StatusEnum.FINALIZADO;
        this.dataEntrega = LocalDateTime.now();
    }

    public void calculaValorTotal() {
        Map<Produto, Long> count = this.produtos.stream()
                .collect(Collectors.groupingBy(produto -> produto, Collectors.counting()));

        BigDecimal value = new BigDecimal(0);

        for (Map.Entry<Produto, Long> entry : count.entrySet()) {
            BigDecimal somaQuantidadeProduto = entry.getKey().getPreco().multiply(BigDecimal.valueOf(entry.getValue()));

            value = value.add(somaQuantidadeProduto);
        }


        this.valor = value;
    }

    public void setProdutos(List<Produto> produtos) {
        if (Objects.isNull(this.produtos)) {
            this.produtos = new ArrayList<>();
        }

        this.produtos.addAll(produtos);
    }

    public void setProdutosPorCategoria(List<Produto> produtos, CategoriaEnum categoria) {
        if (Objects.isNull(this.produtos)) {
            this.produtos = new ArrayList<>();
        }

        List<Produto> produtosParaRemover = new ArrayList<>();
        this.produtos.stream()
                .filter(produto -> produto.getCategoria().equals(categoria))
                .forEach(produtosParaRemover::add);

        this.produtos.removeAll(produtosParaRemover);

        this.produtos.addAll(produtos);
    }
}
