package org.sofka.venta.cliente.command;

public class CambiarProfesionCommand {
    private final String nombre;
    private final String cargo;

    public CambiarProfesionCommand(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }
}
