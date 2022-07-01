package co.com.example.venta.usecase.tecnico;

import co.com.example.venta.usecase.cliente.CambirRolClienteUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.Tecnico.Command.CambiarRolTecnicoCommand;
import org.sofka.venta.Tecnico.events.RolCuentaCambiadaTecnico;
import org.sofka.venta.Tecnico.events.TecnicoCreado;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.Tecnico.values.TecnicoId;
import org.sofka.venta.cliente.command.CambiarRolClienteCommand;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.RolCuentaCambiadaCliente;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarRolTecnicoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarRolTecnicoUseCase usecase;

    @Test
    void cambiarRolTecnico() {
        //arrange
        TecnicoId tecnicoId = TecnicoId.of(TecnicoId.Type.CC,"ff");
        CuentaTecnicoId cuentaTecnicoId = CuentaTecnicoId.of("fffff");
        String rolTecnico = "General";
        var command = new CambiarRolTecnicoCommand(tecnicoId, cuentaTecnicoId, new RolTecnico(rolTecnico));
        when(repository.getEventsBy(tecnicoId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RolCuentaCambiadaTecnico)events.get(0);
        Assertions.assertEquals("General", event.getRolTecnico().value());

    }

    private List<DomainEvent> history() {
        RolTecnico rolTecnico = new RolTecnico("Usuario");
        CuentaTecnicoId cuentaTecnicoId = CuentaTecnicoId.of("fffff");
        return List.of(
                new TecnicoCreado(cuentaTecnicoId,rolTecnico)
        );
    }

}