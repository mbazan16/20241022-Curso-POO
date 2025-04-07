package com.proyectoClase.springHR.repositories;

import com.proyectoClase.springHR.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RegionRepository extends JpaRepository<Region,Integer> {
}
