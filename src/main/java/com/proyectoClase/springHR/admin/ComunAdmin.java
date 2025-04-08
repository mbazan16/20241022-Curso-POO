package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import com.proyectoClase.springHR.repositories.PaisRepository;
import com.proyectoClase.springHR.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunAdmin implements ServComunAdmin{
    @Autowired
    PaisRepository repoPais;

    @Autowired
    RegionRepository repoRegion;

    @Override
    public List<Pais> listPaises() {
        return repoPais.findAll();
    }

    @Override
    public List<Region> listaRegiones() {
        return  repoRegion.findAll();
    }
}
