package com.proyectoClase.springHR.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REGIONS")
public class Region {

    @Id
    @Column(name="REGION_ID")
    private int id;
    @Column(name="REGION_NAME")
    private String nombre;
}
