package org.sofka.venta.cliente.command;

import co.com.sofka.domain.generic.Command;

public class CambiarPreferenciaCommand extends Command {
    private final String gusto;
    private final String actividad;

    public CambiarPreferenciaCommand(String gusto, String actividad) {
        this.gusto = gusto;
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public String getGusto() {
        return gusto;
    }
}
