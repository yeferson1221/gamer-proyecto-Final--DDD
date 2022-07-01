package co.com.example.venta.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.cliente.command.CambiarPreferenciaCommand;
import org.sofka.venta.cliente.command.CambiarProfesionCommand;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.events.PreferenciaCambiadaCliente;
import org.sofka.venta.cliente.events.ProfesionCambiadaCliente;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.Preferencias;
import org.sofka.venta.cliente.values.RolCliente;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarPreferenciaClienteUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarPreferenciaClienteUseCase usecase;

    @Test
    void cambiarPreferencia() {
        //arrange
        ClienteId clienteId = ClienteId.of(ClienteId.Type.CC,"fffff");
        String tipo = "General";
        String actividad = "Gerente Venta";
        var command = new CambiarPreferenciaCommand(clienteId, tipo, actividad);
        when(repository.getEventsBy(clienteId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PreferenciaCambiadaCliente)events.get(0);

    }

    private List<DomainEvent> history() {
        RolCliente rolCliente = new RolCliente("Usuario");
        CuentaClienteId cuentaClienteId = CuentaClienteId.of("fffff");
        String nombre = "General";
        String cargo = "Gerente Venta";
        String tipo = "ddd";
        String actividad = "ddddf";
        return List.of(
                new ClienteCreado(cuentaClienteId,rolCliente,actividad,tipo,cargo,nombre)
        );
    }

}