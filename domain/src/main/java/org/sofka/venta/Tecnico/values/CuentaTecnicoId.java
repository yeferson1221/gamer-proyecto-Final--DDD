package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.Identity;
import org.sofka.venta.cliente.values.CuentaClienteId;

public class CuentaTecnicoId extends Identity {
    public CuentaTecnicoId(String valor, CuentaTecnicoId.Type type){
        super(type+"-"+valor);
    }

    public CuentaTecnicoId(String id) {
        super(id);
    }

    public static CuentaTecnicoId of(CuentaTecnicoId.Type type, String value) {
        return new CuentaTecnicoId( value, type);
    }

    public static CuentaTecnicoId of(String id) {
        return new CuentaTecnicoId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
