package org.sofka.venta.asesor.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.asesor.values.*;

public class CrearBonificacionAsesorCommand extends Command {
   private final AsesorId entityId;
   private final CuentaAsesorId cuentaAsesorId;
   private final  RolAsesor rolAsesor;
   private final BonificacionId bonificacionid;
   private final TipoBonificacion tipoBonificacion;

    public CrearBonificacionAsesorCommand(AsesorId entityId, CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor, BonificacionId bonificacionid, TipoBonificacion tipoBonificacion) {
        this.entityId = entityId;
        this.cuentaAsesorId = cuentaAsesorId;
        this.rolAsesor = rolAsesor;
        this.bonificacionid = bonificacionid;
        this.tipoBonificacion = tipoBonificacion;
    }

    public AsesorId getEntityId() {
        return entityId;
    }

    public CuentaAsesorId getCuentaAsesorId() {
        return cuentaAsesorId;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public BonificacionId getBonificacionid() {
        return bonificacionid;
    }

    public TipoBonificacion getTipoBonificacion() {
        return tipoBonificacion;
    }
}
