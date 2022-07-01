package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.cliente.CuentaCliente;
import org.sofka.venta.cliente.command.CrearClienteCommand;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearClienteUseCaseTest {
    @InjectMocks
    CrearClienteUseCase useCase;
    @Test
    public void crearCliente(){
        //arrange
        ClienteId clienteId = ClienteId.of(ClienteId.Type.CC, "32212234");
        RolCliente rolCliente = new RolCliente("Usuario");
        CuentaClienteId cuentaClienteId = new CuentaClienteId("3", CuentaClienteId.Type.CC);
        String nombre = "General";
        String cargo = "Gerente Venta";
        String tipo = "ddd";
        String actividad = "ddddf";
        var command = new CrearClienteCommand( clienteId, rolCliente, cuentaClienteId,nombre, cargo, tipo, actividad);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (ClienteCreado)events.get(0);
        Assertions.assertEquals("Usuario", event.getRol().value());
        Assertions.assertEquals("Usuario", event.getRol().value());

    }
}