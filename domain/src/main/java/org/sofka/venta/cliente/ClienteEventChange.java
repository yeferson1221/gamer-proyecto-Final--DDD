package org.sofka.venta.cliente;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.PreferenciaCambiadaCliente;
import org.sofka.venta.cliente.events.ProfesionCambiadaCliente;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;
import org.sofka.venta.cliente.values.Preferencias;
import org.sofka.venta.cliente.values.Profesion;


public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {
        apply((ClienteCreado event) ->{
            cliente.cuentaCliente = new CuentaCliente(event.getCuentaClienteId(), event.getRol());
            cliente.preferencias= new Preferencias(event.getGusto(), event.getActividad());
            cliente.profesion= new Profesion(event.getNombre(), event.getCargo());
        });
        apply((RolCuentaCambiadaCliente event) ->{
            if(!cliente.cuentaCliente.identity().equals(event.getCuentaclienteId())){
                throw new IllegalArgumentException("La cuenta no existe para este identificador");
            }
            cliente.cuentaCliente.cambiarRolCliente(event.getRolCuentaCliente());
        });
        apply((ProfesionCambiadaCliente event) ->{
            cliente.profesion.cambiarProfesionCliente(event.getNombre(), event.getCargo());
        });
        apply((PreferenciaCambiadaCliente event) ->{
            cliente.preferencias.cambiarPreferenciaCliente(event.getGusto(), event.getActividad());
        });
    }
}
