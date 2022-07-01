package co.com.example.venta.usecase.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.asesor.Asesor;
import org.sofka.venta.asesor.command.CrearAsesorCommand;


public class CrearAsesorUseCase extends UseCase<RequestCommand<CrearAsesorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAsesorCommand> crearAsesorCommandRequestCommand) {
        var command = crearAsesorCommandRequestCommand.getCommand();
        var asesor = new Asesor(
                command.getAsesorId(),
                command.getCuentaAsesorId(),
                command.getRolAsesor()
        );

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}
