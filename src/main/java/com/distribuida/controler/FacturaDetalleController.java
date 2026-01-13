package com.distribuida.controler;


import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.FacturaDetalleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturadetalles")
public class FacturaDetalleDetalleController {

    @Autowired
    private FacturaDetalleSerivce facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll() {
        List<FacturaDetalle> FacturaDetalles = facturaDetalleService.findAll();
        return ResponseEntity.ok(FacturaDetalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> findOne(@PathVariable int id){
        FacturaDetalle FacturaDetalle = facturaDetalleService.findOne(id);
        if (FacturaDetalle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(FacturaDetalle);
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> save(@RequestBody FacturaDetalle FacturaDetalle){
        FacturaDetalle FacturaDetalleNuevo=facturaDetalleService.save(FacturaDetalle);
        return ResponseEntity.ok(FacturaDetalleNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity <FacturaDetalle> update(@PathVariable int id, @RequestBody FacturaDetalle FacturaDetalle){
        FacturaDetalle  FacturaDetalleActulizado = facturaDetalleService.update(id, FacturaDetalle);
        if (FacturaDetalleActulizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(FacturaDetalleActulizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
