package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.Identity;

public class BonificacionId extends Identity {
    public BonificacionId(String valor, BonificacionId.Type type){
        super(type+"-"+valor);
    }

    public BonificacionId(String id) {
        super(id);
    }

    public static BonificacionId of(BonificacionId.Type type, String value) {
        return new BonificacionId( value, type);
    }

    public static BonificacionId of(String id) {
        return new BonificacionId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
