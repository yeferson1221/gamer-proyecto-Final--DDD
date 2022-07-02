package org.sofka.venta.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.asesor.values.AsesorId;

public class AsesorBonificacionCambiada extends DomainEvent {
    private final AsesorId asesorId;
    private final Long valor;
    private final Long cantidad;
    public AsesorBonificacionCambiada(AsesorId asesorId, Long valor, Long cantidad) {
        super("co.com.sofka.venta.AsesorBonificacionCambiada");
        this.valor = valor;
        this.cantidad = cantidad;
        this.asesorId = asesorId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Long getValor() {
        return valor;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }
}
