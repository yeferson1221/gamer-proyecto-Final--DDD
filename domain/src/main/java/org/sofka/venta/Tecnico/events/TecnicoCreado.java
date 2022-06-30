package org.sofka.venta.Tecnico.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;


public class TecnicoCreado extends DomainEvent {
    private final CuentaTecnicoId cuentaTecnicoId;
    private final RolTecnico rolTecnico;
    public TecnicoCreado(CuentaTecnicoId cuentaTecnicoId, RolTecnico rolTecnico) {
        super("co.com.sofka.venta.TecnicoCreado");
        this.cuentaTecnicoId=cuentaTecnicoId;
        this.rolTecnico=rolTecnico;
    }

    public CuentaTecnicoId getCuentaTecnicoId() {
        return cuentaTecnicoId;
    }

    public RolTecnico getRolTecnico() {
        return rolTecnico;
    }
}
