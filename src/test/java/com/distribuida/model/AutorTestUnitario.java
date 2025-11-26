package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTestUnitario {

    private Autor autor;

    @BeforeEach
    public void setUp(){

        autor = new Autor(1,"Carlos","Perez","Chile","Av,Infito y alla","0987456321","perezC@correo.com");

    }


    @Test
    public void autorTestConstructor(){
        assertAll("Validar Datos Autor - Constructor",
                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Carlos", autor.getNombre()),
                () -> assertEquals("Perez", autor.getApellido()),
                () -> assertEquals("Chile", autor.getPais()),
                () -> assertEquals("Av,Infito y alla", autor.getDireccion()),
                () -> assertEquals("0987456321", autor.getTelefono()),
                () -> assertEquals("perezC@correo.com", autor.getCorreo())
        );
    }

    @Test
    public void autorTestStters(){
        autor.setIdAutor(2);
        autor.setNombre("Juan");
        autor.setApellido("Torrez");
        autor.setPais("España");
        autor.setDireccion("AvAveniou");
        autor.setTelefono("0963852741");
        autor.setCorreo("juan@correo.com");


        assertAll("Validar Datos Autor - Constructor",
                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Juan", autor.getNombre()),
                () -> assertEquals("Torrez", autor.getApellido()),
                () -> assertEquals("España", autor.getPais()),
                () -> assertEquals("AvAveniou", autor.getDireccion()),
                () -> assertEquals("0963852741", autor.getTelefono()),
                () -> assertEquals("juan@correo.com", autor.getCorreo())
        );
    }

@Test
    public void autorTestString(){
        String str = autor.toString();
        assertAll("calidar datos Autor - to String",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Carlos")),
                () -> assertTrue(str.contains("Perez")),
                () -> assertTrue(str.contains("Chile")),
                () -> assertTrue(str.contains("Av,Infito y alla")),
                () -> assertTrue(str.contains("0987456321")),
                () -> assertTrue(str.contains("perezC@correo.com"))
        );

}


}
