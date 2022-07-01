package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class RolCuentaCambiadaCliente extends DomainEvent {
    private final RolCliente rolCliente;
    private final CuentaClienteId cuentaClienteId;
    public RolCuentaCambiadaCliente(CuentaClienteId cuentaClienteId, RolCliente rolCliente) {
        super("co.com.sofka.venta.RolCuentaCambiadaCliente");
        this.cuentaClienteId = cuentaClienteId;
        this.rolCliente = rolCliente;
    }

    public CuentaClienteId getCuentaclienteId() {
        return cuentaClienteId;
    }

    public RolCliente getRolCuentaCliente() {
        return rolCliente;
    }
}
