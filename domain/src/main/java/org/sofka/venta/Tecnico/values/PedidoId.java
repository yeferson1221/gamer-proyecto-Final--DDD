package org.sofka.venta.Tecnico.values;

import co.com.sofka.domain.generic.Identity;


public class PedidoId extends Identity {
    public PedidoId(String valor, Type type){
        super(type+"-"+valor);
    }

    public PedidoId(String id) {
        super(id);
    }
    public enum Type {
        PASAPORTE, CC, TI
    }
    public static PedidoId of(String id) {
        return new PedidoId(id);
    }
}
