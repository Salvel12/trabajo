package com.registro.usuarios.controlador.dto;


import java.util.List;

public class AutorDTO {

    private long id;
    private String nombre;

    private List<String> titulosLibros;

    public AutorDTO(long id, String nombre, List<String> titulosLibros) {
        this.id = id;
        this.nombre = nombre;
        this.titulosLibros = titulosLibros;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getTitulosLibros() {
        return titulosLibros;
    }

    public void setTitulosLibros(List<String> titulosLibros) {
        this.titulosLibros = titulosLibros;
    }
}
