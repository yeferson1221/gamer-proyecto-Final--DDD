package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Experiencia implements ValueObject<Experiencia.Props> {
    private final String tipo;
    private final Long tiempo;

    public Experiencia(String tipo, Long tiempo) {
        this.tipo = Objects.requireNonNull(tipo,"No puede ser null");
        this.tiempo = Objects.requireNonNull(tiempo,"No puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Tipo() {
                return null;
            }

            @Override
            public Long tiempo() {
                return null;
            }
        };
    }

    public interface Props {
        String Tipo();
        Long tiempo();
    }

}
