package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.venta.asesor.values.AsesorId;

public class Asesor extends AggregateEvent<AsesorId> {
    protected CuentaAsesor cuentaAsesor;
    protected Bonificacion bonificacion;
    protected Experiencia experiencia;

    public Asesor(AsesorId entityId) {
        super(entityId);
    }
}
