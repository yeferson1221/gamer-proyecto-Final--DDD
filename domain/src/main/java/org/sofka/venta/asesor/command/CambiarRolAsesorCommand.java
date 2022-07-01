package org.sofka.venta.asesor.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.asesor.values.AsesorId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;


public class CambiarRolAsesorCommand extends Command {
    private final AsesorId asesorId;
    private final CuentaAsesorId cuentaAsesorId;
    private final RolAsesor rolAsesor;

    public CambiarRolAsesorCommand(AsesorId asesorId, CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor) {
        this.asesorId = asesorId;
        this.cuentaAsesorId = cuentaAsesorId;
        this.rolAsesor = rolAsesor;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public CuentaAsesorId getCuentaAsesorId() {
        return cuentaAsesorId;
    }
}
