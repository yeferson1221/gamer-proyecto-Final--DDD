package org.sofka.venta.asesor.command;

import co.com.sofka.domain.generic.Command;

import org.sofka.venta.asesor.values.AsesorId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;


public class CrearAsesorCommand extends Command {
    private  final AsesorId asesorId;
    private  final RolAsesor rolAsesor;
    private  final CuentaAsesorId cuentaAsesorId;

    public CrearAsesorCommand(AsesorId asesorId, RolAsesor rolAsesor, CuentaAsesorId cuentaAsesorId) {
        this.asesorId = asesorId;
        this.rolAsesor = rolAsesor;
        this.cuentaAsesorId = cuentaAsesorId;
    }

    public CuentaAsesorId getCuentaAsesorId() {
        return cuentaAsesorId;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }
}
