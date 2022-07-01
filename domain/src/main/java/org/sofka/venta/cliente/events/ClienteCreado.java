package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.Preferencias;
import org.sofka.venta.cliente.values.Profesion;
import org.sofka.venta.cliente.values.RolCliente;

public class ClienteCreado extends DomainEvent {
    private final CuentaClienteId cuentaClienteId;
    private final RolCliente rolCliente;
    private final String gusto;
    private final String actividad;
    private final String nombre;
    private final String cargo;


    public ClienteCreado(CuentaClienteId cuentaClienteId, RolCliente rolCliente, String gusto, String actividad, String nombre, String cargo) {
        super("co.com.sofka.venta.ClienteCreado");
        this.cuentaClienteId=cuentaClienteId;
        this.rolCliente = rolCliente;
        this.gusto = gusto;
        this.nombre = nombre;
        this.cargo = cargo;
        this.actividad = actividad;


    }

    public CuentaClienteId getCuentaClienteId() {
        return cuentaClienteId;
    }



    public RolCliente getRol() {
        return rolCliente;
    }

    public RolCliente getRolCliente() {
        return rolCliente;
    }

    public String getCargo() {
        return cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGusto() {
        return gusto;
    }

    public String getActividad() {
        return actividad;
    }
}
