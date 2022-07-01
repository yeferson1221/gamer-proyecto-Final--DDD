package org.sofka.venta.Tecnico;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.Tecnico.events.RolCuentaCambiadaTecnico;
import org.sofka.venta.Tecnico.events.TecnicoCreado;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.Especializacion;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.Tecnico.values.TecnicoId;

import java.util.List;


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

    public void cambiarRolTecnico(CuentaTecnicoId cuentaTecnicoId, RolTecnico rolTecnico){
        appendChange(new RolCuentaCambiadaTecnico(cuentaTecnicoId, rolTecnico)).apply();
    }

    public static Tecnico from(TecnicoId id, List<DomainEvent> events){
        var tecnico = new Tecnico((id));
        events.forEach(tecnico::applyEvent);
        return tecnico;
    }
}
