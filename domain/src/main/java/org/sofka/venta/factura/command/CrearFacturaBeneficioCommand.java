package org.sofka.venta.factura.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.factura.values.*;

public class CrearFacturaBeneficioCommand extends Command {
    private final FacturaId facturaId;
    private final Valor valor;
    private final SectorId sectorId;
    private final Domicilio domicilio;
    private final BeneficioId beneficioId;
    private final Bono bono;

    public CrearFacturaBeneficioCommand(FacturaId facturaId, Valor valor, SectorId sectorId, Domicilio domicilio, BeneficioId beneficioId, Bono bono) {
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public SectorId getSectorId() {
        return sectorId;
    }

    public Valor getValor() {
        return valor;
    }

    public BeneficioId getBeneficioId() {
        return beneficioId;
    }

    public Bono getBono() {
        return bono;
    }
}
