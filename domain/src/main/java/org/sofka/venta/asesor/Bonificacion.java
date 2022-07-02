package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.asesor.values.BonificacionId;
import org.sofka.venta.asesor.values.TipoBonificacion;

public class Bonificacion extends Entity<BonificacionId> {

    private TipoBonificacion tipoBonificacion;


    public Bonificacion(BonificacionId id, TipoBonificacion tipoBonificacion) {
        super(id);
        this.tipoBonificacion = tipoBonificacion;
    }
/*
    public  void cambiarValor(Tipo tipos){
        this.tipo = tipo.cambiarValor(tipos.value());
    }
 */
}
