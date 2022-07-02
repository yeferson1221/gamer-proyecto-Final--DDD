package org.sofka.venta.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;

public class AsesorBonificacionCambiada extends DomainEvent {
    private final Long valor;
    private final Long cantidad;
    public AsesorBonificacionCambiada(Long valor, Long cantidad) {
        super("co.com.sofka.venta.AsesorBonificacionCambiada");
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Long getValor() {
        return valor;
    }
}
