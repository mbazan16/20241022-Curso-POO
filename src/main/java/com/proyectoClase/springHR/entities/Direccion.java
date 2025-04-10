package com.proyectoClase.springHR.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="LOCATIONS")
public class Direccion {

    @Id
    @Column(name="LOCATION_ID")
    private  int id;
    @Column(name="STREET_ADDRESS")
    private String calle;
    @Column(name="POSTAL_CODE")
    private String codigoPostal;
    @Column(name="CITY",nullable = false)
    private String ciudad;
    @Column(name="STATE_PROVINCE")
    private String provincia;

    @ManyToOne(optional = true)
    @JoinColumn(name="COUNTRY_ID")
    private Pais pais;




}
