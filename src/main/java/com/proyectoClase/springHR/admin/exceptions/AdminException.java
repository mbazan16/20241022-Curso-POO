package com.proyectoClase.springHR.admin.exceptions;

public class AdminException extends Exception{

    TipoExcepcionAdmin tipo;

    public AdminException(TipoExcepcionAdmin tipo){
        super(tipo.getMensaje());
        this.tipo=tipo;
    }
    public AdminException(){
        super();
        this.tipo=TipoExcepcionAdmin.GENERAL;
    }

    public TipoExcepcionAdmin getTipo(){
        return tipo;
    }

}
