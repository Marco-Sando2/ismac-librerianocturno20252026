package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaDetalleTestUnitario {

    private FacturaDetalle facturaDetalle;
    private Factura factura;
    private Libro libro;

    @BeforeEach
    public void setUp(){

        factura = new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);

        libro = new Libro();
        libro.setIdLibro(1);
        libro.setTitulo("libro dde aventuras magicas");
        libro.setEditorial("Don Marcus");
        libro.setNumPaginas(250);
        libro.setEdicion("Noccio");
        libro.setIdioma("Español");
        libro.setFechaPublicacion(new Date());
        libro.setDescripcion("AventuraMundo1");
        libro.setTipoPasta("Dura");
        libro.setiSBN("N1NNN52H51H544HH");
        libro.setNumEjemplares(250);
        libro.setPortada("InicioM");
        libro.setPresentacion("InicioSinFin");
        libro.setPrecio(24.99);

        facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacturaDetalle(1);
        facturaDetalle.setCantidad(15);
        facturaDetalle.setSubtotal(100.00);
        facturaDetalle.setFactura(factura);
        facturaDetalle.setLibro(libro);

    }

    @Test
    public void facturaDetalleTestConstructor(){
        assertAll("Validar Constructor - FacturaDetalle",
                ()->assertEquals(1, facturaDetalle.getIdFacturaDetalle()),
                ()->assertEquals(15, facturaDetalle.getCantidad()),
                ()->assertEquals(100.00, facturaDetalle.getSubtotal())
        );
    }



    @Test
    public void facturaDetalleTestToString(){
        String str = facturaDetalle.toString();
        assertAll("Validar to string - FacturaDetalle",
                ()-> assertTrue(str.contains("1")),
                ()-> assertTrue(str.contains("15")),
                ()-> assertTrue(str.contains("100.0"))
        );

    }

    @Test
    public void facturaDetalleTestInyector(){
        assertAll("Vañodar metodo inyector - FacturaDetalle",
                ()->assertNotNull(facturaDetalle.getFactura()),
                ()->assertEquals("FAC-0001", facturaDetalle.getFactura().getNumFactura())
        );
    }


}
