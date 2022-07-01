package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.cliente.Cliente;
import org.sofka.venta.cliente.command.CrearClienteCommand;


public class CrearClienteUseCase extends UseCase<RequestCommand<CrearClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClienteCommand> crearClienteCommandRequestCommand) {
        var command = crearClienteCommandRequestCommand.getCommand();
        var cliente = new Cliente(
                command.getClienteId(),
                command.getCuentaClienteId(),
                command.getRolCliente(),
                command.getNombre(),
                command.getCargo(),
                command.getGusto(),
                command.getActividad()

        );

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
