package org.sofka.venta.cliente.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.cliente.values.ClienteId;

public class CambiarPreferenciaCommand extends Command {
    private final ClienteId clienteId;
    private final String gusto;
    private final String actividad;

    public CambiarPreferenciaCommand(ClienteId clienteId, String gusto, String actividad) {
        this.clienteId = clienteId;
        this.gusto = gusto;
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public String getGusto() {
        return gusto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
