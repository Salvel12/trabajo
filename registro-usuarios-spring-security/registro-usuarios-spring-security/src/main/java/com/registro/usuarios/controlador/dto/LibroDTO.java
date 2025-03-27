package com.registro.usuarios.controlador.dto;

import java.time.LocalDate;

public class LibroDTO {
    private Long id;
    private String nombre;
    private String genero;
    private LocalDate fechaLanzamiento;
    private Long autorId; // Solo el ID del autor para evitar cargar toda la entidad

    // Constructor vacío
    public LibroDTO() {}

    // Constructor con parámetros
    public LibroDTO(Long id, String nombre, String genero, LocalDate fechaLanzamiento, Long autorId) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.autorId = autorId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
    public void setFechaLanzamiento(LocalDate fechaLanzamiento) { this.fechaLanzamiento = fechaLanzamiento; }

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
}
