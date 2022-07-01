package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RolCliente implements ValueObject<String> {
    private final String rolCliente;

    public RolCliente(String rol) {
        this.rolCliente = Objects.requireNonNull(rol,"No puede ser null");
    }

    @Override
    public String value() {
        return rolCliente;
    }

    public RolCliente cambiarRol(String rolCliente){
        return new RolCliente(rolCliente);
    }
}
