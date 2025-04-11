package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.admin.exceptions.AdminException;
import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;

import java.util.List;

public interface ServComunAdmin {
    List<Pais> listPaises() throws AdminException;

    List<Region> listaRegiones() throws AdminException;

    List<Direccion> listaDirecciones() throws AdminException;
}
