package com.proyectoClase.springHR.admin.exceptions;

public enum TipoExcepcionAdmin {GENERAL("01-000","Excepcion general"),
                                ELEMENTO_YA_EXISTE("01-001","Elemento ya existe"),
                                ELEMENTO_NO_EXISTE("01-002","Elemento no existe");
    String codigo;
    String mensaje;

    private TipoExcepcionAdmin(String codigo,String mensaje){
        this.codigo=codigo;
        this.mensaje=mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
