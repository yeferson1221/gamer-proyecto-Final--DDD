package co.com.example.venta.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.factura.Factura;
import org.sofka.venta.factura.command.CrearFacturaCommand;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFacturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFacturaCommand> crearFacturaCommandRequestCommand) {
        var command = crearFacturaCommandRequestCommand.getCommand();
        var factura = new Factura(
                command.getFacturaId(),
                command.getValor(),
                command.getSectorId(),
                command.getDomicilio()
        );

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
