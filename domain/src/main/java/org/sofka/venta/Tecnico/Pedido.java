package org.sofka.venta.Tecnico;

import co.com.sofka.domain.generic.Entity;
import org.sofka.venta.Tecnico.values.Componente;
import org.sofka.venta.Tecnico.values.PedidoId;


public class Pedido extends Entity<PedidoId> {
    private Componente componente;

    public Pedido(PedidoId entityId ) {
        super(entityId);
    }
    //comportamiento falta
}
