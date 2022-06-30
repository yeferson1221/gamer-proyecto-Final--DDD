package org.sofka.venta.cliente.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;


public class CrearClienteCommand extends Command {
    private final ClienteId clienteId;
    private final RolCliente rolCliente;
    private final CuentaClienteId cuentaClienteId;


    public CrearClienteCommand(ClienteId clienteId, RolCliente rolCliente, CuentaClienteId cuentaClienteId) {
        this.clienteId = clienteId;
        this.rolCliente = rolCliente;
        this.cuentaClienteId = cuentaClienteId;
    }

    public CuentaClienteId getCuentaClienteId() {
        return cuentaClienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public RolCliente getRolCliente() {
        return rolCliente;
    }
}
