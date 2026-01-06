package com.distribuida.service;

import com.distribuida.dao.FacturaRepository;
import com.distribuida.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> findALL() {
        return List.of();
    }

    @Override
    public Optional<Factura> findOne(int id) {
        return Optional.empty();
    }

    @Override
    public Factura save(Factura factura) {
        return null;
    }

    @Override
    public Factura update(int id, Factura factura) {
        Optional<Factura> facturaExistente = facturaRepository.findById(id);

        if (facturaExistente == null){

        return null;
        }

        facturaExistente.orElse(null).setNumFactura(factura.getNumFactura());
        facturaExistente.orElse(null).setFecha(factura.getFecha());
        facturaExistente.orElse(null).setTotal(factura.getTotal());
        facturaExistente.orElse(null).setIva(factura.getIva());
        facturaExistente.orElse(null).setTotalNeto(factura.getTotalNeto());
        facturaExistente.orElse(null).setCliente(factura.getCliente());

        return facturaRepository.save(facturaExistente.orElse(null));
    }

    @Override
    public void delete(int id) {

    }
}
