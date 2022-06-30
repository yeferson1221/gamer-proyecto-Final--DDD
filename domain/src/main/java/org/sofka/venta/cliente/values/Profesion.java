package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Profesion implements ValueObject<Profesion.Props> {
    private final String nombre;
    private final String cargo;

    public Profesion(String nombre, String cargo) {
        this.nombre = Objects.requireNonNull(nombre);
        this.cargo = Objects.requireNonNull(cargo);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Nombre() {
                return null;
            }

            @Override
            public String Cargo() {
                return null;
            }
        };
    }

    public interface Props{
        String Nombre();
        String Cargo();
    }
}
