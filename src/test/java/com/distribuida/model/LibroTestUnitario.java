package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTestUnitario {

    private Libro libro;
    private Autor autor;
    private Categoria categoria;

    @BeforeEach
    public  void setUp(){
        autor = new Autor(1,"Carlos","Perez","Chile","Av,Infito y alla","0987456321","perezC@correo.com");

        categoria = new Categoria(1,"Aventura","Una Aventura sin fin");

        libro = new Libro();
        libro.setIdLibro(1);
        libro.setTitulo("libro dde aventuras magicas");
        libro.setEditorial("Don Marcus");
        libro.setNumPaginas(250);
        libro.setEdicion("Noccio");
        libro.setIdioma("Español");
        libro.setFechaPublicacion(new Date());
        libro.setDescripcion("AventuraMundo1");
        libro.setTipoPasta("Dura");
        libro.setiSBN("N1NNN52H51H544HH");
        libro.setNumEjemplares(250);
        libro.setPortada("InicioM");
        libro.setPresentacion("InicioSinFin");
        libro.setPrecio(24.99);

        libro.setAutor(autor);
        libro.setCategoria(categoria);

    }

    @Test
    public void libroTestConstructor(){
        assertAll("Validar constructor - Libro",
                ()->assertEquals(1, libro.getIdLibro()),
                ()->assertEquals("libro dde aventuras magicas", libro.getTitulo()),
                ()->assertEquals("Don Marcus", libro.getEditorial()),
                ()->assertEquals(250, libro.getNumPaginas()),
                ()->assertEquals("Noccio", libro.getEdicion()),
                ()->assertEquals("Español", libro.getIdioma()),
                ()->assertEquals("AventuraMundo1", libro.getDescripcion()),
                ()->assertEquals("Dura", libro.getTipoPasta()),
                ()->assertEquals("N1NNN52H51H544HH", libro.getiSBN()),
                ()->assertEquals(250, libro.getNumEjemplares()),
                ()->assertEquals("InicioM", libro.getPortada()),
                ()->assertEquals("InicioSinFin", libro.getPresentacion()),
                ()->assertEquals(24.99, libro.getPrecio()),
                ()->assertEquals("Carlos", libro.getAutor().getNombre())
                );
    }

    @Test
    public void libroTestInyextor(){
        assertAll("Validar metodo inyector - Libro",
                ()-> assertNotNull(libro.getCategoria()),
                ()-> assertEquals("Aventura", libro.getCategoria().getCategoria())
                );
    }


    @Test
    public void libroTestValoresNegativos(){
        libro.setPrecio(-24.99);
        assertAll("Validar datos negativos - Libro",
                ()-> assertEquals(-24.99, libro.getPrecio())

        );
    }


}
