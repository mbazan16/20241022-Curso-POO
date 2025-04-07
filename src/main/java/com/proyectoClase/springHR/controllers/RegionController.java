package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.entities.Region;
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

    @GetMapping
    public String listadoRegiones(Model model){

        List<Region> regiones=conseguirListado();

        model.addAttribute("listado",regiones);

        return "t_regiones";

    }


    @GetMapping("/{id}")
    public String verRegion(@PathVariable(name="id") Integer idRegion, Model model){

        Region region = new Region(idRegion,"MiRegion");


        model.addAttribute("region",region);

        return "t_region";

    }

    private List<Region> conseguirListado() {
        List<Region> regiones = new ArrayList<Region>();

        Region region = new Region(1,"America");
        regiones.add(region);

        region = new Region(2,"Europa");
        regiones.add(region);

        region = new Region(3,"Asia");
        regiones.add(region);

        region = new Region(4,"Africa");
        regiones.add(region);

        return regiones;

    }
}
