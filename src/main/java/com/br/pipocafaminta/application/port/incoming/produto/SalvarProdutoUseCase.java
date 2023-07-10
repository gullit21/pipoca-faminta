package com.br.pipocafaminta.application.port.incoming.produto;

import com.br.pipocafaminta.application.domain.produto.Produto;

public interface SalvarProdutoUseCase {

    Produto save(Produto produto);

}
