package co.com.example.venta.usecase.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.asesor.Asesor;
import org.sofka.venta.asesor.command.CambiarRolAsesorCommand;


public class CambiarRolAsesorUseCase extends UseCase<RequestCommand<CambiarRolAsesorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarRolAsesorCommand> cambiarRolAsesorCommandRequestCommand) {
        var command = cambiarRolAsesorCommandRequestCommand.getCommand();
        var asesor = Asesor.from(
                command.getAsesorId(), repository().getEventsBy(command.getAsesorId().value())
        );

        asesor.cambiarRolAsesor(command.getCuentaAsesorId(), command.getRolAsesor());

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));

    }
}
