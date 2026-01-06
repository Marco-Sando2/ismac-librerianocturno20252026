package com.distribuida.service;

import com.distribuida.dao.LibroRepository;
import com.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return List.of();
    }

    @Override
    public Libro findOne(int id) {
        return null;
    }

    @Override
    public Libro save(Libro libro) {
        return null;
    }

    @Override
    public Libro update(int id, Libro libro) {

        Optional <Libro> libroExistente = libroRepository.findById(id);

        if (libroExistente == null){
            return null;
        }

        libroExistente.orElse(null).setTitulo(libro.getTitulo());
        libroExistente.orElse(null).setEditorial(libro.getEditorial());
        libroExistente.orElse(null).setNumPaginas(libro.getNumPaginas());
        libroExistente.orElse(null).setEdicion(libro.getEdicion());
        libroExistente.orElse(null).setIdioma(libro.getIdioma());
        libroExistente.orElse(null).setFechaPublicacion(libro.getFechaPublicacion());
        libroExistente.orElse(null).setDescripcion(libro.getDescripcion());
        libroExistente.orElse(null).setTipoPasta(libro.getTipoPasta());
        libroExistente.orElse(null).setiSBN(libro.getiSBN());
        libroExistente.orElse(null).setNumEjemplares(libro.getNumEjemplares());

        return libroRepository.save(libroExistente.orElse(null));
    }


    @Override
    public void delete(int id) {

    }
}
