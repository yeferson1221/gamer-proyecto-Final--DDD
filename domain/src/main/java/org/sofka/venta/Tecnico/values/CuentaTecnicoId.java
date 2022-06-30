package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaTecnicoId extends Identity {
    public CuentaTecnicoId(String valor, CuentaTecnicoId.Type type){
        super(type+"-"+valor);
    }

    public CuentaTecnicoId(String id) {
        super(id);
    }
    public enum Type {
        PASAPORTE, CC, TI
    }
}
