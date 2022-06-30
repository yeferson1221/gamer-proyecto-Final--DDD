package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class RolCuentaCambiada extends DomainEvent {
    private final RolCliente rolClienteCuentaCliente;
    private final CuentaClienteId cuentaclienteId;
    public RolCuentaCambiada(CuentaClienteId cuentaClienteId, RolCliente rolClienteCuentaCliente) {
        super("co.com.sofka.venta.RolCuentaCambiada");
        this.cuentaclienteId = cuentaClienteId;
        this.rolClienteCuentaCliente = rolClienteCuentaCliente;
    }

    public CuentaClienteId getCuentaclienteId() {
        return cuentaclienteId;
    }

    public RolCliente getRolCuentaCliente() {
        return rolClienteCuentaCliente;
    }
}
