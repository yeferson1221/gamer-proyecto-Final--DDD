package co.com.example.venta.usecase.factura;

import co.com.example.venta.usecase.cliente.CrearClienteUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.cliente.command.CrearClienteCommand;
import org.sofka.venta.cliente.events.ClienteCreado;
import org.sofka.venta.cliente.values.ClienteId;
import org.sofka.venta.cliente.values.CuentaClienteId;
import org.sofka.venta.cliente.values.RolCliente;
import org.sofka.venta.factura.Factura;
import org.sofka.venta.factura.command.CrearFacturaCommand;
import org.sofka.venta.factura.events.FacturaCreado;
import org.sofka.venta.factura.values.Domicilio;
import org.sofka.venta.factura.values.FacturaId;
import org.sofka.venta.factura.values.SectorId;
import org.sofka.venta.factura.values.Valor;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearFacturaUseCaseTest {
    @InjectMocks
    CrearFacturaUseCase useCase;
    @Test
    public void crearFactura(){
        //arrange
        FacturaId facturaId = FacturaId.of(FacturaId.Type.CC, "32212234");
        Valor valor = new Valor(2,8L);
        SectorId sectorId = SectorId.of("C");
        Domicilio domicilio = new Domicilio("Factura");
        var command = new CrearFacturaCommand( facturaId, valor, sectorId, domicilio);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (FacturaCreado)events.get(0);

    }
}