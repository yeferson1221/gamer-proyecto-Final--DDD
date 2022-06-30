package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.RolCuentaCambiada;
import org.sofka.venta.cliente.values.*;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {
    protected CuentaCliente cuentaCliente;
    protected Preferencias preferencias;
    protected Profesion profesion;

    public Cliente(ClienteId entityId,CuentaClienteId cuentaClienteId, RolCliente rolCliente) {
        super(entityId);
        appendChange(new ClienteCreado(cuentaClienteId, rolCliente)).apply();
        subscribe(new ClienteEventChange(this));

    }
    private Cliente(ClienteId id) {
        super(id);
        subscribe(new ClienteEventChange(this));
    }
    public void cambiarRolCuenta(CuentaClienteId cuentaClienteId, RolCliente rolClienteCuenta){
        appendChange(new RolCuentaCambiada(cuentaClienteId, rolClienteCuenta)).apply();
    }
    public static Cliente from(ClienteId id, List<DomainEvent> events){
        var cliente = new Cliente((id));
        events.forEach(cliente::applyEvent);
        return cliente;
    }
}
