package org.sofka.venta.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.Profesion;
import org.sofka.venta.cliente.values.RolCliente;

public class ProfesionCambiadaCliente extends DomainEvent {

    private final String nombre;
    private final String cargo;
    public ProfesionCambiadaCliente(String nombre, String cargo){
        super("co.com.sofka.venta.ProfesionCuentaCambiadaCliente");

        this.nombre = nombre;
        this.cargo = cargo;

    }

    public String getCargo() {
        return cargo;
    }

    public String getNombre() {
        return nombre;
    }

}
