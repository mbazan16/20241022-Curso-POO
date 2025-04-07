package com.proyectoClase.springHR.data;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Casa {
    private int id;
    private String nombre;


}
