package com.registro.usuarios.controlador.dto;


import java.util.List;

public class AutorDTO {

    private long id;
    private long nombre;

    private List<String> titulosLibros;

    public AutorDTO(long id, String nombre, List<String> titulosLibros) {
        this.id = id;
        this.nombre = nombre.length();
        this.titulosLibros = titulosLibros;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNombre() {
        return nombre;
    }

    public void setNombre(long nombre) {
        this.nombre = nombre;
    }

    public List<String> getTitulosLibros() {
        return titulosLibros;
    }

    public void setTitulosLibros(List<String> titulosLibros) {
        this.titulosLibros = titulosLibros;
    }
}
