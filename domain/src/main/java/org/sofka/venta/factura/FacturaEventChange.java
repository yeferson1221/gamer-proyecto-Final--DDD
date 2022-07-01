package org.sofka.venta.factura;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.venta.factura.events.FacturaCreado;
import org.sofka.venta.factura.values.Valor;

public class FacturaEventChange extends EventChange {
    public FacturaEventChange(Factura factura) {
        apply((FacturaCreado event) ->{
           factura.valor = new Valor(45,7L);
            factura.sector = new Sector(event.getSectorId(), event.getDomicilio());
        });
    }
}
