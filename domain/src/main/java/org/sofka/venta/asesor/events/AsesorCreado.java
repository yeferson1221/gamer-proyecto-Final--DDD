package org.sofka.venta.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.asesor.values.BonificacionId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;
import org.sofka.venta.asesor.values.TipoBonificacion;

public class AsesorCreado extends DomainEvent {
    private final CuentaAsesorId cuentaAsesorId;
    private final RolAsesor rolAsesor;

    public AsesorCreado(CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor) {
        super("co.com.sofka.venta.AsesorCreado");
        this.cuentaAsesorId=cuentaAsesorId;
        this.rolAsesor=rolAsesor;

    }

    public CuentaAsesorId getCuentaAsesorId() {
        return cuentaAsesorId;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }


}
