package com.proyectoClase.springHR.repositories;

import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaisRepository extends JpaRepository<Pais,String> {
}
