package com.proyectoClase.springHR.controllers;

import com.proyectoClase.springHR.admin.ServComunAdmin;
import com.proyectoClase.springHR.admin.ServPaisAdmin;
import com.proyectoClase.springHR.admin.exceptions.AdminException;
import com.proyectoClase.springHR.common.validations.ValidarModificar;
import com.proyectoClase.springHR.entities.Pais;
import com.proyectoClase.springHR.entities.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pais")
public class PaisController {

    public static Logger log = LoggerFactory.getLogger(PaisController.class);

    @Autowired
    ServPaisAdmin servicio;

    @Autowired
    ServComunAdmin servicioComun;


    @GetMapping
    public String listadoPaises(Model model) throws AdminException {
        log.info("[listadoPaises]");

        List<Pais> paises=servicioComun.listPaises();

        model.addAttribute("listado",paises);

        return "t_paises";

    }


    @GetMapping("/{id}")
    public String verPais(@PathVariable(name="id") String id, Model model) throws AdminException {
        log.info("[verPais]");
        log.debug("[id:"+id+"]");

        Pais pais = servicio.getPais(id);
        log.debug("[pais:"+pais.toString()+"]");

        model.addAttribute("pais",pais);

        return "t_pais";

    }


    @GetMapping("/nuevo")
    public String irFormularioNuevoPais(Model model) throws AdminException {
        log.info("[irFormularioNuevoPais]");
        listaRegiones(model);
        return "t_nuevo_pais";

    }

    @PostMapping
    public String crearPais(@RequestParam(name = "idPais") String id,
                            @RequestParam String nombrePais,
                            @RequestParam Integer idRegion,Model model) throws AdminException {
        log.info("[crearPais]");

       Pais pais= servicio.savePais(id,nombrePais,idRegion);
       model.addAttribute("pais",pais);

       return "t_pais";

    }

    @RequestMapping("/modificar/{id}")
    public String irFormularioModificarPais(@PathVariable String id, Model model) throws AdminException {
        log.info("[irFormularioModificarPais]");
        Pais pais = servicio.getPais(id);

        model.addAttribute("pais",pais);

        listaRegiones(model);
        return "t_modificar_pais";

    }



    @PostMapping("/modificar")
    public String modificarPais(@Validated(ValidarModificar.class) @ModelAttribute Pais pais, BindingResult result, Model model) {
        log.info("[modificarPais]");
        
        try {
            if(result.hasErrors()){
                log.debug("Errors: pais no valido");
                listaRegiones(model);
                return "t_modificar_pais";
            }

            Pais paisAux = servicio.savePais(pais);
            model.addAttribute("pais", paisAux);
            
        }catch(AdminException ae){
            log.error(ae.getMessage(),ae);
            gestioraAdminException(model, ae);
            return "forward:/pais/modificar/"+ pais.getId();
        }

        return "t_pais";

    }

    private void gestioraAdminException(Model model, AdminException ae) {
        String mensaje=null;
        switch(ae.getTipo()) {
            case GENERAL:
                mensaje = "error.general";break;
            case ELEMENTO_NO_EXISTE:
                mensaje = "error.elemento.noExiste";break;
            case ELEMENTO_YA_EXISTE:
                mensaje = "error.elemento.existe";break;
        }
        model.addAttribute("mensaje",mensaje);
    }


    private void listaRegiones(Model model) throws AdminException {
        List<Region> regiones = servicioComun.listaRegiones();
        model.addAttribute("regiones",regiones);
    }

}
