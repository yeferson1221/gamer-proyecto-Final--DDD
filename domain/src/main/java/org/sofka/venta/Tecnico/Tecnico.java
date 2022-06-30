package org.sofka.venta.Tecnico;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.venta.Tecnico.values.TecnicoId;

public class Tecnico extends AggregateEvent<TecnicoId> {
    protected CuentaTecnico cuentaTecnico;

    public Tecnico(TecnicoId entityId) {
        super(entityId);
    }
}
