package com.distribuida.dao;


import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Libro;
import com.sun.source.util.SourcePositions;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class FacturaDetalleTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void testFacturaDelet(){
        facturaRepository.deleteById(206);
    }

    @Test
    public void testFacturaDetalleFindAll(){
        List<FacturaDetalle> detalles =facturaDetalleRepository.findAll();
        detalles.forEach(System.out::println);
    }

    @Test
    public void testFacturaDetalleFindOne() {
        FacturaDetalle detalle = facturaDetalleRepository.findById(1).orElse(null);
        System.out.println(detalle);
    }

    @Test
    public void TestFacturaDetalleSave(){
        Optional<Factura> factura = facturaRepository.findById(2);
        Optional<Libro> libro = libroRepository.findById(2);

        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacturaDetalle(0);
        facturaDetalle.setCantidad(2);
        facturaDetalle.setSubtotal(51.00);
        facturaDetalle.setFactura(factura.orElse(null));
        facturaDetalle.setLibro(libro.orElse(null));

        facturaDetalleRepository.save(facturaDetalle);
    }





}
