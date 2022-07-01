package org.sofka.venta.cliente.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class CambiarRolClienteCommand extends Command {
    private final ClienteId clienteId;
    private final CuentaClienteId cuentaClienteId;
    private final RolCliente rolCliente;

    public CambiarRolClienteCommand(ClienteId clienteId, CuentaClienteId cuentaClienteId, RolCliente rolCliente) {
        this.clienteId = clienteId;
        this.cuentaClienteId = cuentaClienteId;
        this.rolCliente = rolCliente;
    }

    public RolCliente getRolCliente() {
        return rolCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CuentaClienteId getCuentaClienteId() {
        return cuentaClienteId;
    }
}
