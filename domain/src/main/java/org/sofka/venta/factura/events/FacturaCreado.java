package org.sofka.venta.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.factura.values.Domicilio;
import org.sofka.venta.factura.values.FacturaId;
import org.sofka.venta.factura.values.SectorId;
import org.sofka.venta.factura.values.Valor;

public class FacturaCreado extends DomainEvent {
    private final FacturaId facturaId;
    private final Valor valor;
    private final SectorId sectorId;
    private final Domicilio domicilio;
    public FacturaCreado(FacturaId facturaId, Valor valor, SectorId sectorId, Domicilio domicilio) {
        super("co.com.sofka.venta.facturaCreado");
        this.facturaId = facturaId;
        this.valor = valor;
        this.sectorId = sectorId;
        this.domicilio = domicilio;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Valor getValor() {
        return valor;
    }


    public SectorId getSectorId() {
        return sectorId;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }
}
