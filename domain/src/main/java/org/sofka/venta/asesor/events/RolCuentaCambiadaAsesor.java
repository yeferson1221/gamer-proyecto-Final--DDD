package org.sofka.venta.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

public class RolCuentaCambiadaAsesor extends DomainEvent {
    private final RolAsesor rolAsesor;
    private final CuentaAsesorId cuentaAsesorId;
    public RolCuentaCambiadaAsesor(CuentaAsesorId cuentaAsesorId, RolAsesor rolAsesor) {
        super("co.com.sofka.venta.RolCuentaCambiadaAsesor");
        this.rolAsesor=rolAsesor;
        this.cuentaAsesorId=cuentaAsesorId;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public CuentaAsesorId getCuentaAsesorId() {
        return cuentaAsesorId;
    }
}
