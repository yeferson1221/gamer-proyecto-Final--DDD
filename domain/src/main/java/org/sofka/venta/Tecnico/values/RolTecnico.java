package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RolTecnico implements ValueObject<String> {
    private final String rolTecnico;

    public RolTecnico(String rolTecnico) {
        this.rolTecnico = Objects.requireNonNull(rolTecnico);
    }

    public RolTecnico cambiarRolTecnico(String rolTecnico){
        return new RolTecnico(rolTecnico);
    }

    @Override
    public String value() {
        return rolTecnico;
    }
}
