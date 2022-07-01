package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.Identity;

public class SectorId extends Identity {
    private SectorId(String value) {
        super(value);
    }

    public SectorId(){
        //super -> auto generarlo
    }

    public static SectorId of(String value) {
        return new SectorId(value);
    }
}
