package com.proyectoClase.springHR.controllers.common;

import com.proyectoClase.springHR.admin.exceptions.AdminException;
import com.proyectoClase.springHR.admin.exceptions.TipoExcepcionAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    public static Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(AdminException.class)
    public String gestionAdminException(AdminException ae, Model model){
        log.error("Se recoge la excepcion AdminException");
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
        return "common/t_error";

    }
}
