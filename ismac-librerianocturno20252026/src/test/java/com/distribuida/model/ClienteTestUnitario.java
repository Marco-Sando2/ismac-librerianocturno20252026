package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitario {


    private Cliente cliente;


    @BeforeEach
    public void setUp(){
        cliente = new Cliente(1,"178932654","Marco","Quispe","Direccion1","0987456321","m@correp.com");}

   @Test
        public void testClienteCosntructor(){
            assertAll("Valida Datos cliente - Constructor",
                    () -> assertEquals(1, cliente.getIdCliente()),
                    () -> assertEquals("178932654", cliente.getCedula()),
                    () -> assertEquals("Marco", cliente.getNombre()),
                    () -> assertEquals("Quispe", cliente.getApellido()),
                    () -> assertEquals("Direccion1", cliente.getDireccion()),
                    () -> assertEquals("0987456321", cliente.getTelefono()),
                    () -> assertEquals("m@correp.com", cliente.getCorreo())
            );
       }


       @Test
    public void testClienteSetters(){
        cliente.setIdCliente(2);
        cliente.setCedula("1728934569");
        cliente.setNombre("Jp");
        cliente.setApellido("Jacome");
        cliente.setDireccion("Direccion2");
        cliente.setTelefono("2918475963");
        cliente.setCorreo("Core@correo.com");

           assertAll("Valida Datos cliente - Constructor",
                   () -> assertEquals(2, cliente.getIdCliente()),
                   () -> assertEquals("1728934569", cliente.getCedula()),
                   () -> assertEquals("Jp", cliente.getNombre()),
                   () -> assertEquals("Jacome", cliente.getApellido()),
                   () -> assertEquals("Direccion2", cliente.getDireccion()),
                   () -> assertEquals("2918475963", cliente.getTelefono()),
                   () -> assertEquals("Core@correo.com", cliente.getCorreo())
           );


       }

@Test
    public void clienteTestString(){
        String str= cliente.toString();
        assertAll("validadr datos ciente - to String",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("178932654")),
                () -> assertTrue(str.contains("Marco")),
                () -> assertTrue(str.contains("Quispe")),
                () -> assertTrue(str.contains("Direccion1")),
                () -> assertTrue(str.contains("0987456321")),
                () -> assertTrue(str.contains("m@correp.com"))

        );



}





}
