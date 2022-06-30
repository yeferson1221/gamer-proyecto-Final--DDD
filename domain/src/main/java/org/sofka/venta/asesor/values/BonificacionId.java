package org.sofka.venta.asesor.values;

import co.com.sofka.domain.generic.Identity;

public class BonificacionId extends Identity {
    private BonificacionId(String value) {
        super(value);
    }

    public BonificacionId(){
        //super -> auto generarlo
    }

    public static BonificacionId of(String value) {
        return new BonificacionId(value);
    }
}
