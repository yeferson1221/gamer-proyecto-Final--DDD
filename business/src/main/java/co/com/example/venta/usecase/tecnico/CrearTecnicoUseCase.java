package co.com.example.venta.usecase.tecnico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.venta.Tecnico.Command.CrearTecnicoCommand;
import org.sofka.venta.Tecnico.Tecnico;

public class CrearTecnicoUseCase extends UseCase<RequestCommand<CrearTecnicoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTecnicoCommand> crearTecnicoCommandRequestCommand) {
        var command = crearTecnicoCommandRequestCommand.getCommand();
        var tecnico = new Tecnico(
                command.getTecnicoId(),
                command.getCuentaTecnicoId(),
                command.getRolTecnico()
        );

        emit().onResponse(new ResponseEvents(tecnico.getUncommittedChanges()));
    }
}
