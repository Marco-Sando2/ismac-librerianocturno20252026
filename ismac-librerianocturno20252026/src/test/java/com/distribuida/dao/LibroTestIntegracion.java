package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class LibroTestIntegracion {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Test
    public void testLibroSave() {
        Optional<Autor> autor = autorRepository.findById(1);
        Optional<Categoria> categoria = categoriaRepository.findById(1);

        Libro libro = new Libro();
        libro.setTitulo("Cosmico");
        libro.setNumPaginas(350);
        libro.setEdicion("Primera edición");
        libro.setIdioma("Español");
        libro.setFechaPublicacion(new Date());
        libro.setDescripcion("Las grandes aventuras de cosmico");
        libro.setTipoPasta("Pasta dura");
        libro.setiSBN("123G456N789");
        libro.setNumEjemplares(5);
        libro.setPortada("cosmicomagico");
        libro.setPresentacion("Edición SantaAna");
        libro.setPrecio(25.50);
        libro.setAutor(autor.orElse(null));
        libro.setCategoria(categoria.orElse(null));

        libroRepository.save(libro);
    }

    @Test
    public void testLibroUpdate() {
        Optional<Autor> autor = autorRepository.findById(3);
        Optional<Categoria> categoria = categoriaRepository.findById(16);
        Optional<Libro> libros = libroRepository.findById(25);

        libros.orElse(null).setNumPaginas(255);
        libros.orElse(null).setEdicion("new Date");
        libros.orElse(null).setPortada("NuevaAventura");
        libros.orElse(null).setPresentacion("2020-00");
        libros.orElse(null).setPrecio(200.00);
        libros.orElse(null).setAutor(autor.orElse(null));
        libros.orElse(null).setAutor(autor.orElse(null));

            libroRepository.save(libros.orElse(null));

    }

    @Test
    public void testLibroFindAll() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    @Test
    public void testLibroFindOne() {
        Libro libro = libroRepository.findById(1).orElse(null);
        System.out.println(libro);
    }

    @Test
    public void testLibroBorrar() {
        libroRepository.deleteById(1);
    }
}



