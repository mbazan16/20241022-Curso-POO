package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.data.Casa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/primer")
public class PrimerController {

    @GetMapping
    public String  xx(Model model){
        List<Casa> casas= new ArrayList<Casa>();

        Casa casa = new Casa();
        casa.setId(1);
        casa.setNombre("Mi casa");

        casas.add(casa);

        casa = new Casa();
        casa.setId(2);
        casa.setNombre("Otra casa");

        casas.add(casa);

        model.addAttribute("listado",casas);

        return "plantilla";
    }
}
