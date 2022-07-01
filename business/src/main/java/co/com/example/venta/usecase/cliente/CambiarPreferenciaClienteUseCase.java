package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.cliente.Cliente;
import org.sofka.venta.cliente.command.CambiarPreferenciaCommand;


public class CambiarPreferenciaClienteUseCase extends UseCase<RequestCommand<CambiarPreferenciaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarPreferenciaCommand> cambiarPreferenciaCommandCommandRequestCommand) {
        var command = cambiarPreferenciaCommandCommandRequestCommand.getCommand();
        var cliente = Cliente.from(
                command.getClienteId(), repository().getEventsBy(command.getClienteId().value())
        );

        cliente.cambiarPreferenciaCliente(command.getGusto(), command.getGusto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));

    }
}
