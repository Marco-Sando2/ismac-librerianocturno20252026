package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTestUnitario {

    private Categoria categoria;

    @BeforeEach
    public void setUp(){

        categoria = new Categoria(1,"Aventura","Una Aventura sin fin");}

    @Test
    public void testCategoriaConstructor(){
        assertAll("Valida Datos Categoria - Constructor",
                ()-> assertEquals(1, categoria.getIdCategoria()),
                ()-> assertEquals("Aventura", categoria.getCategoria()),
                ()-> assertEquals("Una Aventura sin fin", categoria.getDescripcion())
        );
    }


    @Test
    public void testCategoriaSetters(){
        categoria.setIdCategoria(2);
        categoria.setCategoria("Terror");
        categoria.setDescripcion("Corre que te cojo");

            assertAll("Vañida Datos categoria - Constructo",
                    ()-> assertEquals(2, categoria.getIdCategoria()),
                    ()-> assertEquals("Terror", categoria.getCategoria()),
                    ()-> assertEquals("Corre que te cojo", categoria.getDescripcion())
                    );
    }


    @Test
    public void categoriaTestString(){
        String str= categoria.toString();
        assertAll("validar datos categoria - to String",
                ()->assertTrue(str.contains("1")),
                ()->assertTrue(str.contains("Aventura")),
                ()->assertTrue(str.contains("Una Aventura sin fin"))
        );
    }


}
