package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.cliente.Cliente;
import org.sofka.venta.cliente.command.CambiarProfesionCommand;


public class CambiarProfesionClienteUseCase extends UseCase<RequestCommand<CambiarProfesionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarProfesionCommand> cambiarProfesionCommandCommandRequestCommand) {
        var command = cambiarProfesionCommandCommandRequestCommand.getCommand();
        var cliente = Cliente.from(
                command.getClienteId(), repository().getEventsBy(command.getClienteId().value())
        );

        cliente.cambiarProfesionCliente(command.getCargo(), command.getNombre());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));

    }
}
