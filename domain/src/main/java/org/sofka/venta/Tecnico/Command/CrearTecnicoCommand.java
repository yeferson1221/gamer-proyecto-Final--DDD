package org.sofka.venta.Tecnico.Command;

import co.com.sofka.domain.generic.Command;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.Tecnico.values.TecnicoId;

public class CrearTecnicoCommand extends Command {
    private final TecnicoId tecnicoId;
    private final RolTecnico rolTecnico;
    private final CuentaTecnicoId cuentaTecnicoId;

    public CrearTecnicoCommand(TecnicoId tecnicoId, RolTecnico rolTecnico, CuentaTecnicoId cuentaTecnicoId) {
        this.tecnicoId = tecnicoId;
        this.rolTecnico = rolTecnico;
        this.cuentaTecnicoId = cuentaTecnicoId;
    }

    public CuentaTecnicoId getCuentaTecnicoId() {
        return cuentaTecnicoId;
    }

    public RolTecnico getRolTecnico() {
        return rolTecnico;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }
}
