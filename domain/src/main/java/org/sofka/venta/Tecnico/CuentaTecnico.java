package org.sofka.venta.Tecnico;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;

public class CuentaTecnico extends Entity<CuentaTecnicoId> {
    private RolTecnico rolTecnico;

    public CuentaTecnico(CuentaTecnicoId entityId, RolTecnico rolTecnico) {
        super(entityId);
        this.rolTecnico = rolTecnico;
    }
    public void cambiarRolTecnico(RolTecnico role) {
        this.rolTecnico = rolTecnico.cambiarRolTecnico(role.value());
    }
}
