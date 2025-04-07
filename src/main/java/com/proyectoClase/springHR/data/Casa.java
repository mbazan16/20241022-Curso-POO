package com.proyectoClase.springHR.data;

import org.springframework.stereotype.Component;

@Component
public class Casa {
    private int id;
    private String nombre;

    public Casa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
