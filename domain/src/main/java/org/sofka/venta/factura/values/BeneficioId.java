package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.Identity;

public class BeneficioId extends Identity {
    private BeneficioId(String value) {
        super(value);
    }

    public BeneficioId(){
        //super -> auto generarlo
    }

    public static BeneficioId of(String value) {
        return new BeneficioId(value);
    }
}
