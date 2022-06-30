package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.values.Rol;

public class ClienteCreado extends DomainEvent {
    private final Rol rol;
    public ClienteCreado(Rol rol) {
        super("co.com.sofka.venta.ClienteCreado");
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }
}
