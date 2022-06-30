package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaClienteId extends Identity {
    private CuentaClienteId(String value) {
        super(value);
    }

    public CuentaClienteId(){
        //super -> auto generarlo
    }

    public static CuentaClienteId of(String value) {
        return new CuentaClienteId(value);
    }
}
