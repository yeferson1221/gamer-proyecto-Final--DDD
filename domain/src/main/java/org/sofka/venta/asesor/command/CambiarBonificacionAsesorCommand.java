package org.sofka.venta.asesor.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.asesor.values.AsesorId;


public class CambiarBonificacionAsesorCommand extends Command {
    private final AsesorId asesorId;
    private final Long valor;
    private final Long cantidad;

    public CambiarBonificacionAsesorCommand(AsesorId asesorId, Long valor, Long cantidad) {
        this.asesorId = asesorId;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public Long getValor() {
        return valor;
    }

    public Long getCantidad() {
        return cantidad;
    }
}
