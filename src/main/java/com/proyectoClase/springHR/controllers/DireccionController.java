package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.admin.ServComunAdmin;
import com.proyectoClase.springHR.admin.ServDireccionAdmin;
import com.proyectoClase.springHR.admin.exceptions.AdminException;
import com.proyectoClase.springHR.entities.Direccion;
import com.proyectoClase.springHR.entities.Pais;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value={"/","/direccion"})
public class DireccionController {

    public static Logger log= LoggerFactory.getLogger(DireccionController.class);

    @Autowired
    ServDireccionAdmin servicio;

    @Autowired
    ServComunAdmin servicioComun;

    @GetMapping
    public String buscadorDirecciones(@RequestParam(name="idPais",required = false) String idPais, Model model) throws AdminException {
        log.info("[buscadorDirecciones]");
        log.debug("[idPais:/"+idPais+"/]");

        List<Direccion> direcciones = new ArrayList<Direccion>();
        if(idPais!=null && !"".equals(idPais.trim())){
            direcciones=servicio.listaDirecciones(idPais);
        }else{
            direcciones=servicioComun.listaDirecciones();
        }
        List<Pais> paises = servicioComun.listPaises();
        model.addAttribute("paises",paises);
        model.addAttribute("listado",direcciones);

        return "t_buscador_direcciones";
    }
}
