package com.registro.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Autores")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "autor_libros",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private Set<libros> libros;


    public Autores(Long id, String nombre, Set<libros> libros) {
        this.id = id;
        this.nombre = nombre;
    }

    public Autores() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
