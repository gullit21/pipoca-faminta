package com.br.pipocafaminta.adapters.web.mapper.pedido;

import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.pedido.Pedido;
import com.br.pipocafaminta.application.domain.pedido.PedidoRQ;
import com.br.pipocafaminta.application.domain.pedido.PedidoRS;
import com.br.pipocafaminta.application.domain.produto.Produto;
import org.mapstruct.*;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PedidoWebMapper {

//    @Mapping(target = "cliente", source = "cliente")
//    @Mapping(target = "id", ignore = true)
//    Pedido toPedido(PedidoRQ pedidoRQ, Cliente cliente);

//    @Mapping(target = "cliente", source = "cliente")
//    @Mapping(target = "id", source = "id")
//    Pedido toPedido(Long id, PedidoRQ pedidoRQ, Cliente cliente);

    PedidoRS toPedidoRS(Pedido pedidoSaved);

    List<PedidoRS> toPedidoRSList(List<Pedido> pedidos);

    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produtos", ignore = true)
    void toPedido(@MappingTarget Pedido pedido, PedidoRQ pedidoRQ, Cliente cliente, List<Produto> produtos,
                  CategoriaEnum categoria);

    @AfterMapping
    default void setProdutos(@MappingTarget Pedido pedido, PedidoRQ pedidoRQ, Cliente cliente, List<Produto> produtos,
                             CategoriaEnum categoria) {
        pedido.setProdutosPorCategoria(produtos, categoria);
    }

}
