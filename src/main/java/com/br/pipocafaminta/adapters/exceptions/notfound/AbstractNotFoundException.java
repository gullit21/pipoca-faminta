package com.br.pipocafaminta.adapters.exceptions.notfound;

import com.br.pipocafaminta.adapters.exceptions.AbstractPipocaFamintaException;

public abstract class AbstractNotFoundException extends AbstractPipocaFamintaException {

    public AbstractNotFoundException(String msg) {
        super(msg);
    }
    public AbstractNotFoundException(String msg, Object[] objects) {
        super(msg, objects);
    }
}
