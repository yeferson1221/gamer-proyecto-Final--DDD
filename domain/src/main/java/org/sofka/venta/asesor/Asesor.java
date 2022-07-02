package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.asesor.events.AsesorBonificacionCambiada;
import org.sofka.venta.asesor.events.AsesorBonificacionCreado;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.asesor.events.RolCuentaCambiadaAsesor;
import org.sofka.venta.asesor.values.*;

import java.util.List;


public class Asesor extends AggregateEvent<AsesorId> {
    protected CuentaAsesor cuentaAsesor;
    protected Bonificacion bonificacion;
    protected Experiencia experiencia;

    public Asesor(AsesorId entityId, CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor) {
        super(entityId);
        appendChange(new AsesorCreado(cuentaAsesorId, rolAsesor)).apply();
        subscribe(new AsesorEventChange(this));

    }

    public Asesor(AsesorId entityId, CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor, BonificacionId bonificacionid, TipoBonificacion tipoBonificacion) {
        super(entityId);
        appendChange(new AsesorBonificacionCreado(cuentaAsesorId, rolAsesor,bonificacionid,tipoBonificacion)).apply();
        subscribe(new AsesorEventChange(this));

    }

    private Asesor(AsesorId id) {
        super(id);
        subscribe(new AsesorEventChange(this));
    }

    public void cambiarTipoBonificacion(AsesorId asesorId, Long valor, Long cantidad){
        appendChange(new AsesorBonificacionCambiada(asesorId, valor,cantidad)).apply();
    }

    public void cambiarRolAsesor(CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor){
        appendChange(new RolCuentaCambiadaAsesor(cuentaAsesorId, rolAsesor)).apply();
    }
    public static Asesor from(AsesorId id, List<DomainEvent> events){
        var asesor = new Asesor((id));
        events.forEach(asesor::applyEvent);
        return asesor;
    }
}
