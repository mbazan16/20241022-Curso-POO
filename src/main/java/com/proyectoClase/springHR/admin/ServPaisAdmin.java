package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Pais;

public interface ServPaisAdmin {



    public Pais getPais(String id);

    public Pais savePais(Pais pais);

    public Pais savePais(String idPais, String nombre,Integer idRegion);


}
