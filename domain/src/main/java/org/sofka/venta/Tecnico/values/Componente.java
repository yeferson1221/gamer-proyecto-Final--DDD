package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Componente implements ValueObject<Componente.Props> {
    private final String tipo;
    private final String descripcion;

    public Componente(String tipo, String descripcion) {
        this.tipo = Objects.requireNonNull(tipo);
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Tipo() {
                return tipo;
            }

            @Override
            public String Descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props{
        String Tipo();
        String Descripcion();
    }

}
