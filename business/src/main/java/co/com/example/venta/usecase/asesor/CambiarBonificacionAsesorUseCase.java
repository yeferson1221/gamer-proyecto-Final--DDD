package co.com.example.venta.usecase.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.asesor.Asesor;
import org.sofka.venta.asesor.command.CambiarBonificacionAsesorCommand;



public class CambiarBonificacionAsesorUseCase extends UseCase<RequestCommand<CambiarBonificacionAsesorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarBonificacionAsesorCommand> cambiarBonificacionAsesorCommandRequestCommand) {
        var command = cambiarBonificacionAsesorCommandRequestCommand.getCommand();
        var asesor =  Asesor.from(
                command.getAsesorId(), repository().getEventsBy(command.getAsesorId().value())
        );

        asesor.cambiarTipoBonificacion(command.getValor(),command.getCantidad());

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));

    }
}
