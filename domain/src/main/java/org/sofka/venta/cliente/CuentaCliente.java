package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.Rol;

public class CuentaCliente extends Entity<CuentaClienteId> {
    private Rol rol;

    public CuentaCliente(CuentaClienteId Id) {
        super(Id);
        this.rol = rol;
    }
    public void cambiarRol(Rol role){
        this.rol = rol.cambiarRol(role.value());
    }
}
