package co.com.example.venta.usecase.asesor;

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

import org.sofka.venta.asesor.events.RolCuentaCambiadaAsesor;
import org.sofka.venta.asesor.command.CambiarRolAsesorCommand;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.asesor.values.AsesorId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;


import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarRolAsesorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarRolAsesorUseCase usecase;

    @Test
    void cambiarRolAsesor() {
        //arrange
        AsesorId asesorId = AsesorId.of(AsesorId.Type.CC,"ff");
        CuentaAsesorId cuentaAsesorId = CuentaAsesorId.of("fffff");
        String rolAsesor = "General";
        var command = new CambiarRolAsesorCommand(asesorId, cuentaAsesorId, new RolAsesor(rolAsesor));
        when(repository.getEventsBy(asesorId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RolCuentaCambiadaAsesor)events.get(0);
        Assertions.assertEquals("General", event.getRolAsesor().value());

    }

    private List<DomainEvent> history() {
        RolAsesor rolAsesor = new RolAsesor("Usuario");
        CuentaAsesorId cuentaAsesorId = CuentaAsesorId.of("fffff");
        return List.of(
                new AsesorCreado(cuentaAsesorId,rolAsesor)
        );
    }

}