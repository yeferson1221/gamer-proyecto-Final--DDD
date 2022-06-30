package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaAsesorId extends Identity {
    private CuentaAsesorId(String value) {
        super(value);
    }

    public CuentaAsesorId(){
        //super -> auto generarlo
    }

    public static CuentaAsesorId of(String value) {
        return new CuentaAsesorId(value);
    }
}
