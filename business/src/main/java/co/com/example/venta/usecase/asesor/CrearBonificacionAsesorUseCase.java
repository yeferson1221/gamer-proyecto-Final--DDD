package co.com.example.venta.usecase.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.asesor.Asesor;
import org.sofka.venta.asesor.command.CrearBonificacionAsesorCommand;

public class CrearBonificacionAsesorUseCase extends UseCase<RequestCommand<CrearBonificacionAsesorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearBonificacionAsesorCommand> crearBonificacionAsesorCommandRequestCommand) {
        var command = crearBonificacionAsesorCommandRequestCommand.getCommand();
        var asesor = new Asesor(
                command.getEntityId(),
                command.getCuentaAsesorId(),
                command.getRolAsesor(),
                command.getBonificacionid(),
                command.getTipoBonificacion()
        );

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}
