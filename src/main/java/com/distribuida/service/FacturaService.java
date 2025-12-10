package com.distribuida.service;

import com.distribuida.model.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    List<Factura> findALL();

    Optional<Factura> findOne(int id);

    Factura save(Factura factura);

    Factura update(int id, Factura factura);

    Factura update( Factura factura);

    void delet(int id);

}
