package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class ClienteCreado extends DomainEvent {
    private final CuentaClienteId cuentaClienteId;
    private final RolCliente rolCliente;
    public ClienteCreado(CuentaClienteId cuentaClienteId, RolCliente rolCliente) {
        super("co.com.sofka.venta.ClienteCreado");
        this.cuentaClienteId=cuentaClienteId;
        this.rolCliente = rolCliente;

    }

    public CuentaClienteId getCuentaClienteId() {
        return cuentaClienteId;
    }



    public RolCliente getRol() {
        return rolCliente;
    }
}
