package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.repositories.DireccionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DireccionAdminTest {
    @Mock
    DireccionRepository repository;

    @InjectMocks
    DireccionAdmin servicio;

    @Test
    void listaDirecciones() {
        List<Direccion> direcciones = new ArrayList<Direccion>();
        Direccion direccion = new Direccion();
        direcciones.add(direccion);

        Mockito.when(repository.findAllByPais_Id("IT")).thenReturn(direcciones);

        assertEquals(direcciones, servicio.listaDirecciones("IT"));
        assertThat(servicio.listaDirecciones("IT")).isNotNull();
        assertEquals(direcciones.get(0).getId(), servicio.listaDirecciones("IT").get(0).getId());
    }
}