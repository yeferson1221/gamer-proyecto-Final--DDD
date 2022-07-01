package org.sofka.venta.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.factura.Beneficio;
import org.sofka.venta.factura.values.*;

public class FacturaCreadoBeneficio extends DomainEvent {
    private final FacturaId facturaId;
    private final Valor valor;
    private final SectorId sectorId;
    private final Domicilio domicilio;
    private  final BeneficioId beneficioId;
    private  final Bono bono;
    public FacturaCreadoBeneficio(FacturaId facturaId, Valor valor, SectorId sectorId, Domicilio domicilio, BeneficioId beneficioId, Bono bono) {
        super("co.com.sofka.venta.facturaCreado");
        this.facturaId = facturaId;
        this.valor = valor;
        this.sectorId = sectorId;
        this.domicilio = domicilio;
        this.beneficioId = beneficioId;
        this.bono = bono;
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

    public BeneficioId getBeneficioId() {
        return beneficioId;
    }

    public Bono getBono() {
        return bono;
    }
}
