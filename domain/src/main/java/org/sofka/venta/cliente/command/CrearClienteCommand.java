package org.sofka.venta.cliente.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.cliente.values.*;


public class CrearClienteCommand extends Command {
    private final ClienteId clienteId;
    private final RolCliente rolCliente;
    private final CuentaClienteId cuentaClienteId;
    private final String gusto;
    private final String actividad;
    private final String nombre;
    private final String cargo;

    public CrearClienteCommand(ClienteId clienteId, RolCliente rolCliente, CuentaClienteId cuentaClienteId, String gusto, String actividad, String nombre, String cargo) {
        this.clienteId = clienteId;
        this.rolCliente = rolCliente;
        this.cuentaClienteId = cuentaClienteId;
        this.gusto = gusto;
        this.actividad = actividad;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public RolCliente getRolCliente() {
        return rolCliente;
    }

    public CuentaClienteId getCuentaClienteId() {
        return cuentaClienteId;
    }

    public String getGusto() {
        return gusto;
    }

    public String getActividad() {
        return actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }
}
