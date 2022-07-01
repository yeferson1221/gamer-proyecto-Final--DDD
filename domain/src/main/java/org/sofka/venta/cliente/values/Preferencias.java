package org.sofka.venta.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Preferencias implements ValueObject<Preferencias.Props> {
    private final String gusto;
    private final String actividad;

    public Preferencias(String gusto, String actividad) {

        this.gusto = Objects.requireNonNull(gusto);
        this.actividad = Objects.requireNonNull(actividad);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Gusto() {
                return gusto;
            }
            @Override
            public String Actividad() {
                return actividad;
            }
        };
    }

    public interface Props{
     String Gusto();
     String Actividad();
 }
    public Preferencias cambiarPreferenciaCliente(String gusto, String actividad){

        return new Preferencias(gusto,actividad);
    }
}
