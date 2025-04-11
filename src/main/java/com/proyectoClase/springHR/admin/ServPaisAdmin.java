package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.admin.exceptions.AdminException;
import com.proyectoClase.springHR.entities.Pais;

public interface ServPaisAdmin {



    public Pais getPais(String id) throws AdminException;

    public Pais savePais(Pais pais) throws AdminException;

    public Pais savePais(String idPais, String nombre,Integer idRegion) throws AdminException;


}
