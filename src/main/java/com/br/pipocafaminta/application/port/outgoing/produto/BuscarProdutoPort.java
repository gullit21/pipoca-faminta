package com.br.pipocafaminta.application.port.outgoing.produto;

import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.produto.Produto;

import java.util.List;

public interface BuscarProdutoPort {

    Produto findById(Long id);

    List<Produto> findByCategoria(CategoriaEnum categoriaEnum);

    List<Produto> findAll();

    List<Produto> findAllById(List<Long> produtos);
}
