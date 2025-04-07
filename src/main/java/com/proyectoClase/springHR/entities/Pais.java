package com.proyectoClase.springHR.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COUNTRIES")
public class Pais {

    @Id
    @Column(name="COUNTRY_ID")
    private String id;
    @Column(name="COUNTRY_NAME")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;
}
