package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Valor.Props> {
    private final Integer cantidad;
    private final Long precio;

    public Valor(Integer cantidad,Long precio) {
        this.cantidad = Objects.requireNonNull(cantidad,"No puede ser null");
        this.precio = Objects.requireNonNull(precio,"No puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer cantidad() {
                return cantidad;
            }

            @Override
            public Long precio() {
                return precio;
            }
        };
    }


    public interface Props {

        Integer cantidad();
        Long precio();

    }
}
