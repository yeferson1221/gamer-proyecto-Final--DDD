package co.com.example.venta.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.factura.Factura;
import org.sofka.venta.factura.command.CrearFacturaBeneficioCommand;



public class CrearFacturaBonoCaseUse extends UseCase<RequestCommand<CrearFacturaBeneficioCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFacturaBeneficioCommand> CrearFacturaBeneficioCommandRequestCommand) {
        var command = CrearFacturaBeneficioCommandRequestCommand.getCommand();
        var factura = new Factura(
                command.getFacturaId(),
                command.getValor(),
                command.getSectorId(),
                command.getDomicilio(),
                command.getBeneficioId(),
                command.getBono()
        );

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
