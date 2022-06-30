package org.sofka.venta.Tecnico;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.venta.Tecnico.events.TecnicoCreado;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.Especializacion;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.Tecnico.values.TecnicoId;


public class Tecnico extends AggregateEvent<TecnicoId> {
    protected CuentaTecnico cuentaTecnico;
    protected Pedido pedido;
    protected Especializacion especializacion;

    public Tecnico(TecnicoId entityId, CuentaTecnicoId cuentaTecnicoId, RolTecnico rolTecnico) {
        super(entityId);
        appendChange(new TecnicoCreado(cuentaTecnicoId, rolTecnico)).apply();
        subscribe(new TecnicoEventChange(this));
    }

    public Tecnico(TecnicoId id) {
        super(id);
        subscribe(new TecnicoEventChange(this));
    }
}
