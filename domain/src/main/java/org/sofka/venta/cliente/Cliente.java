package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.Preferencias;
import org.sofka.venta.cliente.values.Profesion;
import org.sofka.venta.cliente.values.Rol;

public class Cliente extends AggregateEvent<ClienteId> {
    protected CuentaCliente cuentaCliente;
    protected Preferencias preferencias;
    protected Profesion profesion;

    public Cliente(ClienteId entityId, Rol rol) {
        super(entityId);
        appendChange(new ClienteCreado(rol)).apply();

    }
}
