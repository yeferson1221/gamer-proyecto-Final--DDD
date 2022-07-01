package org.sofka.venta.cliente.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.cliente.values.ClienteId;

public class CambiarProfesionCommand extends Command {
    private final ClienteId clienteId;
    private final String nombre;
    private final String cargo;

    public CambiarProfesionCommand(ClienteId clienteId, String nombre, String cargo) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
