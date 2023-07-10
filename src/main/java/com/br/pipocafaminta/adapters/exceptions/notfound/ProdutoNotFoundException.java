package com.br.pipocafaminta.adapters.exceptions.notfound;

public class ProdutoNotFoundException extends AbstractNotFoundException {

    public ProdutoNotFoundException() {
        super("produto nao encontrado");
    }

}
