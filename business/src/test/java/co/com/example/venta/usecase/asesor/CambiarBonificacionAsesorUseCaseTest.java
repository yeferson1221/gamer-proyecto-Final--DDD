package co.com.example.venta.usecase.asesor;

import co.com.example.venta.usecase.cliente.CambiarProfesionClienteUseCase;
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
import org.sofka.venta.asesor.Asesor;
import org.sofka.venta.asesor.command.CambiarBonificacionAsesorCommand;
import org.sofka.venta.asesor.events.AsesorBonificacionCambiada;
import org.sofka.venta.asesor.events.AsesorBonificacionCreado;
import org.sofka.venta.asesor.values.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarBonificacionAsesorUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarBonificacionAsesorUseCase usecase;

    @Test
    void cambiarBonificacionAsesor() {
        //arrange
        AsesorId asesorId = AsesorId.of(AsesorId.Type.CC,"44");
        Long valor = 8l;
        Long cantidad = 9L;
        var command = new CambiarBonificacionAsesorCommand(asesorId, valor, cantidad);
        when(repository.getEventsBy(asesorId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AsesorBonificacionCambiada)events.get(0);
        Assertions.assertEquals("44", event.getAsesorId().value());


    }

    private List<DomainEvent> history() {
        RolAsesor rolAsesor = new RolAsesor("Usuario");
        CuentaAsesorId cuentaAsesorId = CuentaAsesorId.of("44");
        BonificacionId bonificacionId = BonificacionId.of("dd");
        TipoBonificacion tipoBonificacion = new TipoBonificacion(6L,7L);
        return List.of(
                new AsesorBonificacionCreado(cuentaAsesorId, rolAsesor, bonificacionId, tipoBonificacion)
        );
    }
}