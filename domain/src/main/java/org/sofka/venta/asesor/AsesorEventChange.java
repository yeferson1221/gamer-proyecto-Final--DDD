package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;

public class AsesorEventChange extends EventChange {
    public AsesorEventChange(Asesor asesor) {
        apply((AsesorCreado event) ->{
            asesor.cuentaAsesor = new CuentaAsesor(event.getCuentaAsesorId(), event.getRolAsesor());
        });
        /*
        apply((RolCuentaCambiadaAsesor event) ->{
            if(!asesor.cuentaAsesor.identity().equals(event.getCuentaAsesorId())){
                throw new IllegalArgumentException("La cuenta no existe para este identificador");
            }
            asesor.cuentaAsesor.cambiarRolAsesor(event.getRolCuentaAsesor());
        });

         */
    }
}
