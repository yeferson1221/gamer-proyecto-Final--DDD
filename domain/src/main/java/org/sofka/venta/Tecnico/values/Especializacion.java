package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especializacion implements ValueObject<Especializacion.Props> {
    private final String tipo;
    private final String titulo;

    public Especializacion(String tipo, String titulo) {
        this.tipo = Objects.requireNonNull(tipo);
        this.titulo = Objects.requireNonNull(titulo);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Tipo() {
                return tipo;
            }

            @Override
            public String Titulo() {
                return titulo;
            }
        };
    }

    public interface Props{
        String Tipo();
        String Titulo();
    }
}
