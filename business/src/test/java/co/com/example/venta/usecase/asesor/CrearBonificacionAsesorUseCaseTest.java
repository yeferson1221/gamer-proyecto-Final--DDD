package co.com.example.venta.usecase.asesor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.sofka.venta.asesor.command.CrearBonificacionAsesorCommand;
import org.sofka.venta.asesor.events.AsesorBonificacionCreado;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.asesor.values.*;

@ExtendWith(MockitoExtension.class)
class CrearBonificacionAsesorUseCaseTest {
    @InjectMocks
    CrearBonificacionAsesorUseCase useCase;

    @Test
    public void crearBonificacionAsesor(){
        //arrange
        AsesorId asesorId = AsesorId.of(AsesorId.Type.CC, "32212234");
        CuentaAsesorId cuentaAsesorId = CuentaAsesorId.of(CuentaAsesorId.Type.CC, "32212234");
        RolAsesor rolAsesor = new RolAsesor("Usuario");
        BonificacionId bonificacionId = BonificacionId.of(BonificacionId.Type.CC, "32212234");
        TipoBonificacion tipoBonificacion = new TipoBonificacion(34L,567L);
        var command = new CrearBonificacionAsesorCommand( asesorId, cuentaAsesorId, rolAsesor,bonificacionId, tipoBonificacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (AsesorBonificacionCreado)events.get(0);
        Assertions.assertEquals("Usuario", event.getRolAsesor().value());
        Assertions.assertEquals("Usuario", event.getRolAsesor().value());
    }



}