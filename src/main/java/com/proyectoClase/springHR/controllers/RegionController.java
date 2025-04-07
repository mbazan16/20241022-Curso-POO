package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.entities.Region;
import com.proyectoClase.springHR.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionRepository repository;

    @GetMapping
    public String listadoRegiones(Model model){

        List<Region> regiones=repository.findAll();

        model.addAttribute("listado",regiones);

        return "t_regiones";

    }


    @GetMapping("/{id}")
    public String verRegion(@PathVariable(name="id") Integer idRegion, Model model){

        Region region = repository.findById(idRegion).get();


        model.addAttribute("region",region);

        return "t_region";

    }


}
