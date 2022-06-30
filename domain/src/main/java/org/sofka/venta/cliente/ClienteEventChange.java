package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.venta.cliente.events.ClienteCreado;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {
        apply((ClienteCreado event) ->{
            cliente.cuentaCliente = new CuentaCliente(event.getCuentaClienteId(), event.getRol());
        });
    }
}
