package com.br.pipocafaminta.adapters.persistence.mapper.pedido;

import com.br.pipocafaminta.adapters.persistence.mapper.produto.ProdutoPersistenceMapper;
import com.br.pipocafaminta.adapters.persistence.pedido.model.PedidoEntity;
import com.br.pipocafaminta.adapters.persistence.pedido.model.PedidoProdutoEntity;
import com.br.pipocafaminta.adapters.persistence.produto.model.ProdutoEntity;
import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.pedido.Pedido;
import com.br.pipocafaminta.application.domain.pedido.PedidoRQ;
import com.br.pipocafaminta.application.domain.produto.Produto;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(uses = {ProdutoPersistenceMapper.class},
        builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PedidoPersistenceMapper {

    PedidoEntity toPedidoEntity(Pedido pedido);

    @AfterMapping
    default void setProdutos(@MappingTarget PedidoEntity pedidoEntity, Pedido pedido) {
        if (Objects.isNull(pedidoEntity.getPedidoProduto())) {
            pedidoEntity.setPedidoProduto(new ArrayList<>());
        }

        pedido.getProdutos().forEach(produto -> {
            pedidoEntity.getPedidoProduto().add(PedidoProdutoEntity.builder()
                    .pedido(pedidoEntity)
                    .produto(ProdutoEntity.builder()
                            .id(produto.getId())
                            .categoria(produto.getCategoria())
                            .descricao(produto.getDescricao())
                            .nome(produto.getNome())
                            .preco(produto.getPreco())
                            .urlImagem(produto.getUrlImagem())
                            .build())
                    .build());
        });
    }

    Pedido toPedidoList(PedidoEntity pedidoSaved);

    @AfterMapping
    default void setProdutos(@MappingTarget Pedido pedido, PedidoEntity pedidoSaved) {
        if (Objects.isNull(pedido.getProdutos())) {
            pedido.setProdutos(new ArrayList<>());
        }

        pedidoSaved.getPedidoProduto().forEach(pedidoProdutoEntity -> {
            pedido.getProdutos().add(Produto.builder()
                            .id(pedidoProdutoEntity.getProduto().getId())
                            .categoria(pedidoProdutoEntity.getProduto().getCategoria())
                            .descricao(pedidoProdutoEntity.getProduto().getDescricao())
                            .nome(pedidoProdutoEntity.getProduto().getNome())
                            .preco(pedidoProdutoEntity.getProduto().getPreco())
                            .urlImagem(pedidoProdutoEntity.getProduto().getUrlImagem())
                    .build()
            );
        });
    }

    List<Pedido> toPedidoList(List<PedidoEntity> pedidoEntityList);
}
