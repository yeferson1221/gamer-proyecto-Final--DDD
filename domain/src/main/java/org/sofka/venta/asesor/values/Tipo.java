package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<Tipo.Props> {
    private final Long valor;
    private final Long cantidad;

    public Tipo(Long valor, Long cantidad) {
        this.valor = Objects.requireNonNull(valor,"No puede ser null");
        this.cantidad = Objects.requireNonNull(cantidad,"No puede ser null");
    }


    public Tipo cambiarValor(Long valor, Long cantidad){
        return new Tipo(valor,cantidad);
    }

    @Override
    public Props value() {
        return null;
    }

    public interface Props{
        Long valor();
        Long cantidad();
    }
}
