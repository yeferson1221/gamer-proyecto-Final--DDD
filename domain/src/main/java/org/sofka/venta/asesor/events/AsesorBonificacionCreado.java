package org.sofka.venta.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.asesor.values.BonificacionId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;
import org.sofka.venta.asesor.values.TipoBonificacion;

public class AsesorBonificacionCreado extends DomainEvent {
    private final CuentaAsesorId cuentaAsesorId;
    private final RolAsesor rolAsesor;
    private final BonificacionId bonificacionId;
    private final TipoBonificacion tipoBonificacion;
    public AsesorBonificacionCreado(CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor, BonificacionId bonificacionId, TipoBonificacion tipoBonificacion) {
        super("co.com.sofka.venta.AsesorBonificacionCreado");
        this.cuentaAsesorId=cuentaAsesorId;
        this.rolAsesor=rolAsesor;
        this.bonificacionId=bonificacionId;
        this.tipoBonificacion= tipoBonificacion;
    }

    public CuentaAsesorId getCuentaAsesorId() {
        return cuentaAsesorId;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public BonificacionId getBonificacionId() {
        return bonificacionId;
    }

    public TipoBonificacion getTipoBonificacion() {
        return tipoBonificacion;
    }
}
