package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.Identity;
import org.sofka.venta.cliente.values.CuentaClienteId;

public class CuentaAsesorId extends Identity {
    public CuentaAsesorId(String valor, CuentaAsesorId.Type type){
        super(type+"-"+valor);
    }

    public CuentaAsesorId(String id) {
        super(id);
    }

    public static CuentaAsesorId of(CuentaAsesorId.Type type, String value) {
        return new CuentaAsesorId( value, type);
    }

    public static CuentaAsesorId of(String id) {
        return new CuentaAsesorId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
