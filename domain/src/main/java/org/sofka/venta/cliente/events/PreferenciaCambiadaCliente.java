package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PreferenciaCambiadaCliente extends DomainEvent {
    private final String gusto;
    private final String actividad;
    public PreferenciaCambiadaCliente(String gusto, String actividad) {
        super("co.com.sofka.venta.PreferenciaCambiadaCliente");
        this.gusto = gusto;
        this.actividad = actividad;
    }

    public String getGusto() {
        return gusto;
    }

    public String getActividad() {
        return actividad;
    }
}
