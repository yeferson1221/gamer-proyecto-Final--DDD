package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {
    public FacturaId(String valor, Type type){
        super(type+"-"+valor);
    }

    public FacturaId(String id) {
        super(id);
    }

    public static FacturaId of(Type type, String value) {
        return new FacturaId( value, type);
    }

    public static FacturaId of(String id) {
        return new FacturaId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
