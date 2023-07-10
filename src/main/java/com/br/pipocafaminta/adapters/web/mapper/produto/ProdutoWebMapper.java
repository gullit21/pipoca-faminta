package com.br.pipocafaminta.adapters.web.mapper.produto;

import com.br.pipocafaminta.application.domain.produto.Produto;
import com.br.pipocafaminta.application.domain.produto.ProdutoRQ;
import com.br.pipocafaminta.application.domain.produto.ProdutoRS;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProdutoWebMapper {

    ProdutoRS toProdutoRS(Produto produto);

    List<ProdutoRS> toProdutoRSList(List<Produto> produtoList);

    Produto toProduto(ProdutoRQ produtoRQ);
}
