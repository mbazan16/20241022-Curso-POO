package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;

import java.util.List;

public interface ServComunAdmin {
    List<Pais> listPaises();

    List<Region> listaRegiones();
}
