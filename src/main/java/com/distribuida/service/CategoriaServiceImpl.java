package com.distribuida.service;

import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return List.of();
    }

    @Override
    public Categoria findOne(int id) {
        return null;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria update(int id, Categoria categoria) {

        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);

        if (categoriaExistente == null){
            return null;
        }

        categoriaExistente.orElse(null).setCategoria(categoria.getCategoria());
        categoriaExistente.orElse(null).setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(categoriaExistente.orElse(null));

    }

    @Override
    public void delete(int id) {

    }
}
