package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.Identity;

public class AsesorId extends Identity {
    public AsesorId(String valor, Type type){
        super(type+"-"+valor);
    }

    public AsesorId(String id) {
        super(id);
    }

    public static AsesorId of(Type type, String value) {
        return new AsesorId( value, type);
    }

    public static AsesorId of(String id) {
        return new AsesorId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
