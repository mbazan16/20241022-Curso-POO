package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.admin.ServComunAdmin;
import com.proyectoClase.springHR.admin.ServDireccionAdmin;
import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DireccionController.class)
@Import(DireccionControllerTest.MockServiceConfig.class)
class DireccionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ServComunAdmin servicioComun;

    @Autowired
    ServDireccionAdmin servicio;




    @Test
    @DisplayName("Mostramos todas las direcciones")
    void buscadorDirecciones_1() throws Exception {
        List<Direccion> direcciones = new ArrayList<Direccion>();
        Region region = new Region();
        Pais pais = new Pais();
        Direccion direccion = new Direccion();
        pais.setRegion(region);
        direccion.setPais(pais);
        direcciones.add(direccion);

        List<Pais> paises = new ArrayList<Pais>();


        Mockito.when(servicioComun.listaDirecciones()).thenReturn(direcciones);
        Mockito.when(servicioComun.listPaises()).thenReturn(paises);
        //Mockito.when(servicio.listaDirecciones("IT")).thenReturn(direcciones);


        this.mockMvc.perform(get("/direccion"))
                .andExpect(status().isOk())
                .andExpect(view().name("t_buscador_direcciones"))
                .andExpect(model().attributeExists("listado"))
                .andExpect(model().attributeExists("paises"))
                .andExpect(model().attribute("paises",new ArrayList<Pais>()))
                .andDo(print());

        Mockito.verify(servicioComun, times(1)).listaDirecciones();
        Mockito.verify(servicioComun, times(1)).listPaises();


    }

    @Test
    @DisplayName("Mostramos direcciones de Italia")
    void buscadorDirecciones_2() throws Exception {
        List<Direccion> direcciones = new ArrayList<Direccion>();
        Region region = new Region();
        Pais pais = new Pais();
        Direccion direccion = new Direccion();
        pais.setRegion(region);
        direccion.setPais(pais);
        direcciones.add(direccion);

        List<Pais> paises = new ArrayList<Pais>();


        //Mockito.when(servicioComun.listaDirecciones()).thenReturn(direcciones);
        Mockito.when(servicioComun.listPaises()).thenReturn(paises);
        Mockito.when(servicio.listaDirecciones("IT")).thenReturn(direcciones);


        this.mockMvc.perform(get("/direccion").param("idPais","IT"))
                .andExpect(status().isOk())
                .andExpect(view().name("t_buscador_direcciones"))
                .andExpect(model().attributeExists("listado"))
                .andExpect(model().attributeExists("paises"))
                .andExpect(model().attribute("paises",new ArrayList<Pais>()))
                .andDo(print());

        Mockito.verify(servicio, times(1)).listaDirecciones("IT");
        //Mockito.verify(servicioComun, times(1)).listPaises();


    }

    // ✅ Configuración personalizada para inyectar los mocks
    @TestConfiguration
    static class MockServiceConfig {
        @Bean
        public ServComunAdmin servicioComun() {
            return Mockito.mock(ServComunAdmin.class);
        }

        @Bean
        public ServDireccionAdmin servicioDireccion() {
            return Mockito.mock(ServDireccionAdmin.class);
        }
    }
}