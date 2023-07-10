package com.br.pipocafaminta.application.port.incoming.produto;

import com.br.pipocafaminta.application.domain.produto.Produto;

public interface EditarProdutoUseCase {

    Produto update(Long id, Produto produto);

}
