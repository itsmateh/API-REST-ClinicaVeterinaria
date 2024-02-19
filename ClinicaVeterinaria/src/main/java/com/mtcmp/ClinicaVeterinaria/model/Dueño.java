package com.mtcmp.ClinicaVeterinaria.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Dueño {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private int celular;

    public Dueño() {
    }

    public Dueño(Long id, String dni, String nombre, String apellido, int celular) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }
}
