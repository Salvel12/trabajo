package com.registro.usuarios.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "libros")
public class libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false) // Clave foránea en la tabla libros
    private Autores autor;

    @Column(nullable = false)
    private LocalDate fechaLanzamiento;

    @Column(nullable = false)
    private String genero;


    public libros(Long id, String nombre, Set<Autores> autores, LocalDate fechaLanzamiento, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
    }


    public libros(String id, String nombre, Autores autor, LocalDate fechaLanzamiento, String genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
    }

    public libros() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
