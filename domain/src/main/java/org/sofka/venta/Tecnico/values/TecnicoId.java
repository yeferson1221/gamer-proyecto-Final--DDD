package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.Identity;
import org.sofka.venta.cliente.values.ClienteId;

public class TecnicoId extends Identity {
    public TecnicoId(String valor, TecnicoId.Type type){
        super(type+"-"+valor);
    }

    public TecnicoId(String id) {
        super(id);
    }

    public static TecnicoId of(TecnicoId.Type type, String value) {
        return new TecnicoId( value, type);
    }

    public static TecnicoId of(String id) {
        return new TecnicoId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
