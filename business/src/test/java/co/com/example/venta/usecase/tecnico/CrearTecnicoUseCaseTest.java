package co.com.example.venta.usecase.tecnico;

import co.com.example.venta.usecase.cliente.CrearClienteUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.Tecnico.Command.CrearTecnicoCommand;
import org.sofka.venta.Tecnico.events.TecnicoCreado;
import org.sofka.venta.Tecnico.values.CuentaTecnicoId;
import org.sofka.venta.Tecnico.values.RolTecnico;
import org.sofka.venta.Tecnico.values.TecnicoId;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearTecnicoUseCaseTest {
    @InjectMocks
    CrearTecnicoUseCase useCase;
    @Test
    public void crearTecnico(){
        //arrange
        TecnicoId tecnicoId = TecnicoId.of(TecnicoId.Type.CC, "32212234");
        RolTecnico rolTecnico = new RolTecnico("Usuario");
        CuentaTecnicoId cuentaTecnicoId = new CuentaTecnicoId("3", CuentaTecnicoId.Type.CC);
        var command = new CrearTecnicoCommand( tecnicoId, rolTecnico, cuentaTecnicoId);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (TecnicoCreado)events.get(0);
        Assertions.assertEquals("Usuario", event.getRolTecnico().value());
        Assertions.assertEquals("Usuario", event.getRolTecnico().value());

    }

}