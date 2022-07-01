package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.cliente.Cliente;
import org.sofka.venta.cliente.command.CambiarProfesionCommand;
import org.sofka.venta.cliente.command.CambiarRolClienteCommand;

public class CambiarProfesionClienteUseCase extends UseCase<RequestCommand<CambiarProfesionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarRolClienteCommand> cambiarRolClienteCommandRequestCommand) {
        var command = cambiarRolClienteCommandRequestCommand.getCommand();
        var cliente = Cliente.from(
                command.getClienteId(), repository().getEventsBy(command.getClienteId().value())
        );

        cliente.cambiarRolCliente(command.getCuentaClienteId(), command.getRolCliente());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));

    }
}
