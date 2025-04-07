package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.admin.ServPaisAdmin;
import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import com.proyectoClase.springHR.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    ServPaisAdmin servicio;

    @GetMapping
    public String listadoPaises(Model model){

        List<Pais> paises=servicio.listPaises();

        model.addAttribute("listado",paises);

        return "t_paises";

    }


    @GetMapping("/{id}")
    public String verPais(@PathVariable(name="id") String id, Model model){

        Pais pais = servicio.getPais(id);


        model.addAttribute("pais",pais);

        return "t_pais";

    }


    @GetMapping("/nuevo")
    public String irFormularioNuevoPais(Model model){


        return "t_nuevo_pais";

    }

    @PostMapping
    public String crearPais(@RequestParam(name = "idPais") String id,
                            @RequestParam String nombrePais,
                            @RequestParam Integer idRegion,Model model){

       Pais pais= servicio.savePais(id,nombrePais,idRegion);

       model.addAttribute("pais",pais);

       return "t_pais";

    }

}
