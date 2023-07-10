package com.br.pipocafaminta.adapters.exceptions;

import java.util.function.Supplier;

public abstract class AbstractPipocaFamintaException extends RuntimeException implements Supplier<AbstractPipocaFamintaException> {

    private final transient Object[] objects;

    public AbstractPipocaFamintaException(String msg) {
        super(msg);
        this.objects = new Object[]{};
    }
    public AbstractPipocaFamintaException(String msg, Object object) {
        super(msg);
        this.objects = new Object[]{object};
    }
    public AbstractPipocaFamintaException(String msg, Object[] objects) {
        super(msg);
        this.objects = objects.clone();
    }
    public Object[] getObjects() {
        return objects.clone();
    }
    @Override
    public AbstractPipocaFamintaException get() {
        return this;
    }
}
