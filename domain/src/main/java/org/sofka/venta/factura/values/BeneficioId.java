package org.sofka.venta.factura.values;

import co.com.sofka.domain.generic.Identity;
import org.sofka.venta.asesor.values.CuentaAsesorId;

public class BeneficioId extends Identity {
    public BeneficioId(String valor, BeneficioId.Type type){
        super(type+"-"+valor);
    }

    public BeneficioId(String id) {
        super(id);
    }

    public static BeneficioId of(BeneficioId.Type type, String value) {
        return new BeneficioId( value, type);
    }

    public static BeneficioId of(String id) {
        return new BeneficioId(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
