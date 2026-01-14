package com.distribuida.service;

import com.distribuida.model.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleSerivce {
    List<FacturaDetalle> findAll();

    FacturaDetalle findOne(int id);

    FacturaDetalle save(FacturaDetalle facturaDetalle);

    FacturaDetalle update(int id, FacturaDetalle facturaDetalle);

    void delete(int id);
}
