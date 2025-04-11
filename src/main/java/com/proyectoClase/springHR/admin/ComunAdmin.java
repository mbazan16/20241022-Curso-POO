package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.admin.exceptions.AdminException;
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
    public List<Region> listaRegiones() throws AdminException {
        log.info("[listaRegiones]");

        try {
            return repoRegion.findAll();
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw new AdminException();
        }
    }

    @Override
    public List<Direccion> listaDirecciones() throws AdminException{
        log.info("[listaDirecciones]");

        try {
            return repoDireccion.findAll();
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw new AdminException();
        }
    }
}
