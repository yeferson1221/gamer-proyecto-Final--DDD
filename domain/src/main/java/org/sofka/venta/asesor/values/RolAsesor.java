package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RolAsesor implements ValueObject<String> {
    private  final String rolAsesor;

    public RolAsesor(String rolAsesor) {
        this.rolAsesor = Objects.requireNonNull(rolAsesor,"No puede ser null");
    }

    @Override
    public String value() {
        return rolAsesor;
    }

    public RolAsesor cambiarRol(String rolAsesor){
        return new RolAsesor(rolAsesor);
    }
}
