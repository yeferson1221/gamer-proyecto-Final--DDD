package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.Identity;

public class TecnicoId extends Identity {
    public TecnicoId(String valor, Type type){
        super(type+"-"+valor);
    }

    public TecnicoId(String id) {
        super(id);
    }
    public enum Type {
        PASAPORTE, CC, TI
    }
    public static TecnicoId of(String id) {
        return new TecnicoId(id);
    }
}
