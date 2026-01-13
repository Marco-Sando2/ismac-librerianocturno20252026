package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleSerivce {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public List<FacturaDetalle> findAll() {
        return List.of();
    }

    @Override
    public Optional<FacturaDetalle> findOne(int id) {
        return Optional.ofNullable(facturaDetalleRepository.findById(id).orElse(null));
    }

    @Override
    public FacturaDetalle save(FacturaDetalle facturaDetalle) {
        return null;
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle facturaDetalle) {

        Optional <FacturaDetalle> facturaDetalleExistente = facturaDetalleRepository.findById(id);

        if (facturaDetalleExistente ==null){
            return null;
        }

        facturaDetalleExistente.orElse(null).setCantidad(facturaDetalle.getCantidad());
        facturaDetalleExistente.orElse(null).setSubtotal(facturaDetalle.getSubtotal());
        facturaDetalleExistente.orElse(null).setFactura(facturaDetalle.getFactura());
        facturaDetalleExistente.orElse(null).setLibro(facturaDetalle.getLibro());
        return facturaDetalleRepository.save(facturaDetalleExistente.orElse(null));

    }



    @Override
    public void delete(int id) {

    }
}
