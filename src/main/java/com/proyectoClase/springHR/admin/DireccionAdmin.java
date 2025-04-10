package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.repositories.DireccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionAdmin implements ServDireccionAdmin{
    public static Logger log = LoggerFactory.getLogger(DireccionAdmin.class);


    DireccionRepository repositorio;

    @Autowired
    public DireccionAdmin(DireccionRepository repositorio){
        this.repositorio=repositorio;
    }

    @Override
    public List<Direccion> listaDirecciones(String idPais) {
        log.info("[listaDirecciones]");
        log.debug("[idPais:"+idPais+"]");
        return repositorio.findAllByPais_Id(idPais);
    }
}
