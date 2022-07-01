package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.asesor.values.AsesorId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.Experiencia;
import org.sofka.venta.asesor.values.RolAsesor;
import org.sofka.venta.cliente.Cliente;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

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

    private Asesor(AsesorId id) {
        super(id);
        subscribe(new AsesorEventChange(this));
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
