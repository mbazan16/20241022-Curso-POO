package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import com.proyectoClase.springHR.repositories.DireccionRepository;
import com.proyectoClase.springHR.repositories.PaisRepository;
import com.proyectoClase.springHR.repositories.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunAdmin implements ServComunAdmin{

    public static Logger log = LoggerFactory.getLogger(ComunAdmin.class);

    @Autowired
    PaisRepository repoPais;

    @Autowired
    RegionRepository repoRegion;

    @Autowired
    DireccionRepository repoDireccion;

    @Override
    public List<Pais> listPaises() {
        log.info("[listPaises]");
        return repoPais.findAll();
    }

    @Override
    public List<Region> listaRegiones() {
        log.info("[listaRegiones]");
        return  repoRegion.findAll();
    }

    @Override
    public List<Direccion> listaDirecciones() {
        log.info("[listaDirecciones]");
        return repoDireccion.findAll();
    }
}
