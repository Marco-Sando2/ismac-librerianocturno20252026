package com.distribuida.controler;

import com.distribuida.model.Cliente;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.ClienteService;
import com.distribuida.service.FacturaDetalleSerivce;
import com.distribuida.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturadetalles")
public class FacturaDetalleController {

    @Autowired
    private FacturaDetalleSerivce facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll() {
        List<FacturaDetalle> facturaDetalle = facturaDetalleService.findAll();
        return ResponseEntity.ok(facturaDetalle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> findOne(@PathVariable int id){
        FacturaDetalle facturaDetalle = facturaDetalleService.findOne(id);
        if (facturaDetalle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDetalle);
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> save(@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle facturaDetalleNuevo=facturaDetalleService.save(facturaDetalle);
        return ResponseEntity.ok(facturaDetalleNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity <FacturaDetalle> update(@PathVariable int id, @RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle  facturaDetalleActulizado = facturaDetalleService.update(id, facturaDetalle);
        if (facturaDetalleActulizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDetalleActulizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
