package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Preferencias implements ValueObject<Preferencias.Props> {
    private final String gusto;

    public Preferencias(String gusto) {
        this.gusto = Objects.requireNonNull(gusto);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Gusto() {
                return null;
            }
        };
    }

    public interface Props{
     String Gusto();
 }
}
