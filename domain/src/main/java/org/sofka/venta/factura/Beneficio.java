package org.sofka.venta.factura;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.factura.values.BeneficioId;
import org.sofka.venta.factura.values.Bono;


public class Beneficio extends Entity<BeneficioId> {
    private Bono bono;

    public Beneficio(BeneficioId id,Bono bono) {
        super(id);
        this.bono = bono;
    }
    /*
    public void cambiarBono(Bono bon){
        this.bono = bono.cambiarBono(bon.value());
    }

    */
}
