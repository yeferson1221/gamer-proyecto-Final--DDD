package co.com.example.venta.usecase.factura;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.venta.factura.command.CrearFacturaBeneficioCommand;

import org.sofka.venta.factura.values.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearFacturaBonoCaseUseTest {
    @InjectMocks
    CrearFacturaBonoCaseUse useCase;

    @Test
    public void crearFacturaBeneficio(){
        //arrange
        FacturaId facturaId = FacturaId.of(FacturaId.Type.CC, "32212234");
        Valor valor = new Valor(2,8L);
        SectorId sectorId = SectorId.of("C");
        Domicilio domicilio = new Domicilio("Factura");
        BeneficioId beneficioId = BeneficioId.of("D");
        Bono bono = new Bono("descuento",4);
        var command = new CrearFacturaBeneficioCommand( facturaId, valor, sectorId, domicilio, beneficioId, bono);

    }
}