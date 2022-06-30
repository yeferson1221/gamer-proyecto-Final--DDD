package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;

public class CuentaAsesor extends Entity<CuentaAsesorId>{
    private RolAsesor rolAsesor;

    public CuentaAsesor(CuentaAsesorId id,RolAsesor rolAsesor) {
        super(id);
        this.rolAsesor = rolAsesor;
    }

    public void cambiarRolAsesor(RolAsesor role){
        this.rolAsesor = rolAsesor.cambiarRol(role.value());
    }

}
