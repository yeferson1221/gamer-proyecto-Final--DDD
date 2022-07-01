package org.sofka.venta.Tecnico.Command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.Tecnico.values.TecnicoId;


public class CambiarRolTecnicoCommand extends Command {
    private final TecnicoId tecnicoId;
    private final CuentaTecnicoId cuentaTecnicoId;
    private final RolTecnico rolTecnico;

    public CambiarRolTecnicoCommand(TecnicoId tecnicoId, CuentaTecnicoId cuentaTecnicoId, RolTecnico rolTecnico) {
        this.tecnicoId = tecnicoId;
        this.cuentaTecnicoId = cuentaTecnicoId;
        this.rolTecnico = rolTecnico;
    }

    public RolTecnico getRolTecnico() {
        return rolTecnico;
    }

    public CuentaTecnicoId getCuentaTecnicoId() {
        return cuentaTecnicoId;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }
}
