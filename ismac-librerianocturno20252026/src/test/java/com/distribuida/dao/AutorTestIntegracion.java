package com.distribuida.dao;

import com.distribuida.model.Autor;
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

public class AutorTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void testAutorSave() {
        Autor autor = new Autor();

        autor.setNombre("Diego");
        autor.setApellido("Hendrickson");
        autor.setPais("Ecuador");
        autor.setDireccion("Aveniada Aveniu");
        autor.setTelefono("0982546731");
        autor.setCorreo("DiegoGD@correo.com");

        autorRepository.save(autor);
    }

    @Test
    public void testAutorActualizar() {
        Optional<Autor> autor = autorRepository.findById(1);

            autor.orElse(null).setDireccion("Dirección actualizada");
            autor.orElse(null).setTelefono("1010101010");
            autor.orElse(null).setCorreo("newcorreo@correo.com");

            autorRepository.save(autor.orElse(null));


    }


    @Test
    public void testAutorFindAll() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void testAutorFindOne() {
        Autor autor = autorRepository.findById(1).orElse(null);
        System.out.println(autor);
    }

    @Test
    public void testAutorBorrar() {
        autorRepository.deleteById(1);
    }

}
