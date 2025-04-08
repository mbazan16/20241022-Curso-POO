package com.proyectoClase.springHR.admin;

import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import com.proyectoClase.springHR.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisAdmin implements ServPaisAdmin{

    @Autowired
    PaisRepository repository;

    @Override
    public Pais getPais(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Pais savePais(Pais pais) {
        return repository.save(pais);
    }

    @Override
    public Pais savePais(String idPais, String nombre, Integer idRegion) {
        Pais pais = new Pais();
        pais.setId(idPais);
        pais.setNombre(nombre);
        Region region = new Region();
        region.setId(idRegion);
        pais.setRegion(region);
        return repository.save(pais);
    }
}
