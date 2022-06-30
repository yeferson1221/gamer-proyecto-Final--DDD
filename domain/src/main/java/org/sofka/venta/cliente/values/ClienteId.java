package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(String valor, Type type){
        super(type+"-"+valor);
    }

    public ClienteId(String id) {
        super(id);
    }

    public static ClienteId of(Type type, String value) {
        return new ClienteId( value, type);
    }

    public static ClienteId of(String id) {
        return new ClienteId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
