package com.br.pipocafaminta.application.port.outgoing.produto;

import com.br.pipocafaminta.application.domain.produto.Produto;

public interface SalvarProdutoPort {

    Produto save(Produto produto);

}
