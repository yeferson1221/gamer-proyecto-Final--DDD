package co.com.example.venta.usecase.tecnico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.Tecnico.Command.CambiarRolTecnicoCommand;
import org.sofka.venta.Tecnico.Tecnico;

public class CambiarRolTecnicoUseCase extends UseCase<RequestCommand<CambiarRolTecnicoCommand>, ResponseEvents> {
@Override
public void executeUseCase(RequestCommand<CambiarRolTecnicoCommand> cambiarRolTecnicoCommandRequestCommand) {
        var command = cambiarRolTecnicoCommandRequestCommand.getCommand();
        var tecnico = Tecnico.from(
        command.getTecnicoId(), repository().getEventsBy(command.getTecnicoId().value())
        );

        tecnico.cambiarRolTecnico(command.getCuentaTecnicoId(), command.getRolTecnico());

        emit().onResponse(new ResponseEvents(tecnico.getUncommittedChanges()));

        }
}
