package com.br.pipocafaminta.adapters.persistence.mapper.produto;

import com.br.pipocafaminta.adapters.persistence.produto.model.ProdutoEntity;
import com.br.pipocafaminta.application.domain.produto.Produto;
import org.mapstruct.*;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProdutoPersistenceMapper {

    ProdutoEntity toProdutoEntity(Produto produto);

    Produto toProduto(ProdutoEntity produtoEntity);

    List<Produto> toProdutoList(List<ProdutoEntity> produtoList);

    @Mapping(target = "id", ignore = true)
    void updateProduto(@MappingTarget Produto produtoFound, Produto produtoUpdate);

}
