package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaClienteId extends Identity {
    public CuentaClienteId(String valor, CuentaClienteId.Type type){
        super(type+"-"+valor);
    }

    public CuentaClienteId(String id) {
        super(id);
    }

    public static CuentaClienteId of(CuentaClienteId.Type type, String value) {
        return new CuentaClienteId( value, type);
    }

    public static CuentaClienteId of(String id) {
        return new CuentaClienteId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
