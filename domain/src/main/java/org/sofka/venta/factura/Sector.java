package org.sofka.venta.factura;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.factura.values.Domicilio;
import org.sofka.venta.factura.values.SectorId;

public class Sector extends Entity<SectorId> {
    private Domicilio domicilio;

    public Sector(SectorId id, Domicilio domicilio) {
        super(id);
        this.domicilio = domicilio;
    }

    public void cambiarSector(Domicilio domici){
        this.domicilio = domicilio.cambiarSector(domici.value());
    }

}
