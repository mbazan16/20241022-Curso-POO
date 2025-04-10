package com.proyectoClase.springHR.repositories;

import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DireccionRepository extends JpaRepository<Direccion,Integer> {

    List<Direccion> findAllByPais_Id(@Param("id") String idPais);
}
