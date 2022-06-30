package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.cliente.Cliente;
import org.sofka.venta.cliente.command.CrearClienteCommand;
import org.sofka.venta.cliente.values.CuentaClienteId;


public class CrearClienteUseCase extends UseCase<RequestCommand<CrearClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClienteCommand> crearClienteCommandRequestCommand) {
        var command = crearClienteCommandRequestCommand.getCommand();
        var cliente = new Cliente(
                command.getClienteId(),
                new CuentaClienteId(),
                command.getRolCliente()
        );

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
