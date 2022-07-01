package org.sofka.venta.factura.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.factura.values.Domicilio;
import org.sofka.venta.factura.values.FacturaId;
import org.sofka.venta.factura.values.SectorId;
import org.sofka.venta.factura.values.Valor;

public class CrearFacturaCommand extends Command {
    private final FacturaId facturaId;
    private final Valor valor;
    private final SectorId sectorId;
    private final Domicilio domicilio;

    public CrearFacturaCommand(FacturaId facturaId, Valor valor, SectorId sectorId, Domicilio domicilio) {
        this.facturaId = facturaId;
        this.valor = valor;
        this.sectorId = sectorId;
        this.domicilio = domicilio;
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
}
