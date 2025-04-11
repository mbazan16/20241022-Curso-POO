package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.admin.exceptions.AdminException;
import com.proyectoClase.springHR.entities.Direccion;

import java.util.List;

public interface ServDireccionAdmin {

    List<Direccion> listaDirecciones(String idPais) throws AdminException;
}
