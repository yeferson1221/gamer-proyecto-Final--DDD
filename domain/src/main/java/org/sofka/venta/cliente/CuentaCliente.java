package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class CuentaCliente extends Entity<CuentaClienteId> {
    private RolCliente rolCliente;

    public CuentaCliente(CuentaClienteId Id, RolCliente rolCliente) {
        super(Id);
        this.rolCliente = rolCliente;
    }
    public void cambiarRolCliente(RolCliente role){
        this.rolCliente = rolCliente.cambiarRol(role.value());
    }
}
