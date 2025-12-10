package com.distribuida.service;

import com.distribuida.dao.FacturaRepository;
import com.distribuida.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FacturaServiceImpl implements FacturaService {


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
        return null;
    }

    @Override
    public Factura update(Factura factura) {
        return null;
    }

    @Override
    public void delet(int id) {

    }
}
