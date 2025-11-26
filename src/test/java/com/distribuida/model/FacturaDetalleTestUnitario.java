package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

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


        facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacturaDetalle(1);
        facturaDetalle.setCantidad(15);
        facturaDetalle.setSubtotal(100.00);

        facturaDetalle.setFactura(factura);
        facturaDetalle.setLibro(libro);

    }


}
