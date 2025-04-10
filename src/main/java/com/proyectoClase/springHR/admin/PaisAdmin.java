package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import com.proyectoClase.springHR.repositories.PaisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisAdmin implements ServPaisAdmin{
    public static Logger log = LoggerFactory.getLogger(PaisAdmin.class);


    PaisRepository repository;


//    public PaisAdmin(PaisRepository repository){
//        this.repository=repository;
//    }

    @Override
    public Pais getPais(String id) {
        log.info("[getPais]");
        log.debug("[id:"+id+"]");
        return repository.findById(id).get();
    }

    @Override
    public Pais savePais(Pais pais) {
        log.info("[savePais]");
        log.debug("[pais:{}]",pais);
        return repository.save(pais);
    }

    @Override
    public Pais savePais(String idPais, String nombre, Integer idRegion) {
        log.info("[savePais]");
        log.debug("[idPais:{},nombre:{},idRegion:{}]",idPais,nombre,idRegion);
        Pais pais = new Pais();
        pais.setId(idPais);
        pais.setNombre(nombre);
        Region region = new Region();
        region.setId(idRegion);
        pais.setRegion(region);
        return repository.save(pais);
    }

    @Autowired
    public void setRepository(PaisRepository repository) {
        this.repository = repository;
    }
}
