package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Domicilio implements ValueObject<String> {
    private final String domicilio;
    public Domicilio(String domicilio) {
        this.domicilio = Objects.requireNonNull(domicilio,"No puede ser null");
    }

    @Override
    public String value() {
        return domicilio;
    }

    public Domicilio cambiarSector(String domicilio){
        return new Domicilio(domicilio);
    }
}
