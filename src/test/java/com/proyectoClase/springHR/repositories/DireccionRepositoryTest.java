package com.proyectoClase.springHR.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DireccionRepositoryTest {
    DireccionRepository repositorio;

    @Autowired
    public DireccionRepositoryTest(DireccionRepository repositorio){
        this.repositorio=repositorio;

    }
    @Test
    @DisplayName("Listado de direccion por Pais Ok")
    void findAllByPais_Id_1() {
        //Comprobamos que nos devuelve direcciones de Italia
        assertNotNull(repositorio.findAllByPais_Id("IT"));
        assertNotEquals(null, repositorio.findAllByPais_Id("IT"));

        assertThat(repositorio.findAllByPais_Id("IT")).isNotNull();
        assertThat(repositorio.findAllByPais_Id("IT")).hasSize(2);

    }

    @Test
    @DisplayName("Listado de direccion por Pais KO")
    void findAllByPais_Id_2() {
        //Comprobamos que nos devuelve lista VACIA direcciones de Italia
        assertThat(repositorio.findAllByPais_Id(null)).isNotNull();

        assertThat(repositorio.findAllByPais_Id(null)).isEmpty();

    }
}