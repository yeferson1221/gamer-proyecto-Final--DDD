package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rol implements ValueObject<String> {
    private final String rol;

    public Rol(String rol) {
        this.rol = Objects.requireNonNull(rol,"No puede ser null");
    }

    @Override
    public String value() {
        return rol;
    }

    public Rol cambiarRol(String rol){
        return new Rol(rol);
    }
}
