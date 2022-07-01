package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Bono implements ValueObject<Bono.Props> {
    private final String tipo;
    private final Integer cantidad;

    public Bono(String tipo, Integer cantidad) {
        this.tipo = Objects.requireNonNull(tipo,"No puede ser null");
        this.cantidad = Objects.requireNonNull(cantidad,"No puede ser null");

    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipo() {
                return tipo;
            }

            @Override
            public Integer cantidad() {
                return cantidad;
            }
        };
    }
    public interface Props {

        String tipo();
        Integer cantidad();


    }
}
