package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {
        apply((ClienteCreado event) ->{
            cliente.cuentaCliente = new CuentaCliente(event.getCuentaClienteId(), event.getRol());
        });
        apply((RolCuentaCambiadaCliente event) ->{
            if(!cliente.cuentaCliente.identity().equals(event.getCuentaclienteId())){
                throw new IllegalArgumentException("La cuenta no existe para este identificador");
            }
            cliente.cuentaCliente.cambiarRolCliente(event.getRolCuentaCliente());
        });
    }
}
