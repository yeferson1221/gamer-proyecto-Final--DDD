package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.asesor.values.BonificacionId;

public class Bonificacion extends Entity<BonificacionId> {

    private Tipo tipo;


    public Bonificacion(BonificacionId id, Tipo tipo) {
        super(id);
        this.tipo = tipo;
    }
/*
    public  void cambiarValor(Tipo tipos){
        this.tipo = tipo.cambiarValor(tipos.value());
    }
 */
}
