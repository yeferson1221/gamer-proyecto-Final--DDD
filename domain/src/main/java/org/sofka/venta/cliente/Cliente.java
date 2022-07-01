package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.PreferenciaCambiadaCliente;
import org.sofka.venta.cliente.events.ProfesionCambiadaCliente;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;
import org.sofka.venta.cliente.values.*;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {
    protected CuentaCliente cuentaCliente;
    protected Preferencias preferencias;
    protected Profesion profesion;

    public Cliente(ClienteId entityId, CuentaClienteId cuentaClienteId, RolCliente rolCliente, String nombre, String cargo, String gusto, String actividad) {
        super(entityId);
        appendChange(new ClienteCreado(cuentaClienteId, rolCliente, nombre, actividad, cargo, gusto)).apply();
        subscribe(new ClienteEventChange(this));

    }


    private Cliente(ClienteId id) {
        super(id);
        subscribe(new ClienteEventChange(this));
    }

    public void cambiarRolCliente(CuentaClienteId cuentaClienteId, RolCliente rolCliente) {
        appendChange(new RolCuentaCambiadaCliente(cuentaClienteId, rolCliente)).apply();
    }

    public void cambiarProfesionCliente( String nombre, String cargo) {
        appendChange(new ProfesionCambiadaCliente(nombre, cargo)).apply();
    }
    public void cambiarPreferenciaCliente(String gusto, String actividad) {
        appendChange(new PreferenciaCambiadaCliente(gusto, actividad)).apply();
    }

    public static Cliente from(ClienteId id, List<DomainEvent> events){
        var cliente = new Cliente((id));
        events.forEach(cliente::applyEvent);
        return cliente;
    }

}
