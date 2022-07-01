package org.sofka.venta.Tecnico.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class RolCuentaCambiadaTecnico extends DomainEvent {
    private final RolTecnico rolTecnico;
    private final CuentaTecnicoId cuentaTecnicoId;
    public RolCuentaCambiadaTecnico(CuentaTecnicoId cuentaTecnicoId, RolTecnico rolTecnico) {
        super("co.com.sofka.venta.RolCuentaCambiadaTecnico");
        this.cuentaTecnicoId=cuentaTecnicoId;
        this.rolTecnico=rolTecnico;
    }

    public RolTecnico getRolTecnico() {
        return rolTecnico;
    }

    public CuentaTecnicoId getCuentaTecnicoId() {
        return cuentaTecnicoId;
    }
}
