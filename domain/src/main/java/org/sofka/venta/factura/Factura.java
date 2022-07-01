package org.sofka.venta.factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.factura.events.FacturaCreado;
import org.sofka.venta.factura.events.FacturaCreadoBeneficio;
import org.sofka.venta.factura.values.*;

import java.util.List;


public class Factura extends AggregateEvent<FacturaId> {
    protected Sector sector;
    protected Beneficio beneficio;
    protected Valor valor;

    public Factura(FacturaId facturaId, Valor valor, SectorId sectorId, Domicilio domicilio ) {
        super(facturaId);
        appendChange(new FacturaCreado(facturaId, valor,sectorId, domicilio)).apply();
        subscribe(new FacturaEventChange(this));
    }

    public Factura(FacturaId facturaId, Valor valor, SectorId sectorId, Domicilio domicilio, BeneficioId beneficioId, Bono bono ) {
        super(facturaId);
        appendChange(new FacturaCreadoBeneficio(facturaId, valor,sectorId, domicilio, beneficioId, bono)).apply();
        subscribe(new FacturaEventChange(this));
    }

    public Factura(FacturaId facturaId ) {
        super(facturaId);
        subscribe(new FacturaEventChange(this));
    }

    public static Factura from(FacturaId id, List<DomainEvent> events){
        var factura = new Factura((id));
        events.forEach(factura::applyEvent);
        return factura;
    }
}
