package com.distribuida.dao;

import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testCategoriaSave() {
        Categoria categoria = new Categoria();
        categoria.setCategoria("Horror");
        categoria.setDescripcion("Libros de hay que miedo");

        categoriaRepository.save(categoria);
    }

    @Test
    public void testCategoriaActualizar() {
        Optional<Categoria> categoria = categoriaRepository.findById(1);

            categoria.orElse(null).setCategoria("Ciencia ficción");
            categoria.orElse(null).setDescripcion("Libros de ciencia");

            categoriaRepository.save(categoria.orElse(null));
        }

    @Test
    public void testCategoriaFindAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        categorias.forEach(System.out::println);
    }

    @Test
    public void testCategoriaFindOne() {
        Categoria categoria = categoriaRepository.findById(1).orElse(null);
        System.out.println(categoria);
    }

    @Test
    public void testCategoriaDelet() {
        categoriaRepository.deleteById(1);
    }

}
