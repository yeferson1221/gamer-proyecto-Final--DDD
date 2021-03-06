package org.sofka.venta.asesor;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.venta.asesor.events.AsesorBonificacionCambiada;
import org.sofka.venta.asesor.events.AsesorBonificacionCreado;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.asesor.events.RolCuentaCambiadaAsesor;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;
import org.sofka.venta.factura.Beneficio;
import org.sofka.venta.factura.Sector;
import org.sofka.venta.factura.events.FacturaCreadoBeneficio;
import org.sofka.venta.factura.values.Valor;

public class AsesorEventChange extends EventChange {
    public AsesorEventChange(Asesor asesor) {
        apply((AsesorCreado event) ->{
            asesor.cuentaAsesor = new CuentaAsesor(event.getCuentaAsesorId(), event.getRolAsesor());
        });

        apply((RolCuentaCambiadaAsesor event) ->{
            if(!asesor.cuentaAsesor.identity().equals(event.getCuentaAsesorId())){
                throw new IllegalArgumentException("La cuenta no existe para este identificador");
            }
            asesor.cuentaAsesor.cambiarRolAsesor(event.getRolAsesor());
        });

        apply((AsesorBonificacionCreado event) ->{
            asesor.cuentaAsesor = new CuentaAsesor(event.getCuentaAsesorId(), event.getRolAsesor());
            asesor.bonificacion = new Bonificacion(event.getBonificacionId(),event.getTipoBonificacion());
        });
        apply((AsesorBonificacionCambiada event) ->{
            asesor.cambiarTipoBonificacion(event.getAsesorId(), event.getValor(), event.getCantidad());
        });
    }
}
