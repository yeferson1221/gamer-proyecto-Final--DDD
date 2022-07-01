package co.com.example.venta.usecase.asesor;

import co.com.example.venta.usecase.cliente.CrearClienteUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.asesor.command.CrearAsesorCommand;
import org.sofka.venta.asesor.events.AsesorCreado;
import org.sofka.venta.asesor.values.AsesorId;
import org.sofka.venta.asesor.values.CuentaAsesorId;
import org.sofka.venta.asesor.values.RolAsesor;
import org.sofka.venta.cliente.command.CrearClienteCommand;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearAsesorUseCaseTest {
    @InjectMocks
    CrearAsesorUseCase useCase;
    @Test
    public void crearAsesor(){
        //arrange
        AsesorId asesorId = AsesorId.of(AsesorId.Type.CC, "32212234");
        RolAsesor rolAsesor = new RolAsesor("Usuario");
        CuentaAsesorId cuentaAsesorId = new CuentaAsesorId("3", CuentaAsesorId.Type.CC);
        var command = new CrearAsesorCommand( asesorId, rolAsesor, cuentaAsesorId);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (AsesorCreado)events.get(0);
        Assertions.assertEquals("Usuario", event.getRolAsesor().value());
        Assertions.assertEquals("Usuario", event.getRolAsesor().value());

    }
}