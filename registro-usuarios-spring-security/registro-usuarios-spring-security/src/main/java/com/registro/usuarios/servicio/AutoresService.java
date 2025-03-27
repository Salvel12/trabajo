package com.registro.usuarios.servicio;


import com.registro.usuarios.controlador.dto.AutorDTO;
import com.registro.usuarios.modelo.Autores;
import com.registro.usuarios.modelo.libros;
import com.registro.usuarios.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AutoresService {

    @Autowired
    private AutorRepositorio autorRepositorio;


    public List<AutorDTO> obtenerAutores() {
        List<Autores> autores = autorRepositorio.findAll();

        return autores.stream().map(autor ->
                new AutorDTO(
                        autor.getId(),
                        autor.getNombre(),
                        autor.getLibros().stream()
                                .map(libros::getNombre)
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }

    // Guardar un autor (sin libros)
    public Autores guardarAutor(Autores autor) {
        return autorRepositorio.save(autor);
    }

    // Obtener autor por ID
    public AutorDTO obtenerAutorPorId(Long id) {
        Autores autor = autorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        return new AutorDTO(
                autor.getId(),
                autor.getNombre(),
                autor.getLibros().stream()
                        .map(libros::getNombre)
                        .collect(Collectors.toList())
        );
    }

    // Eliminar un autor
    public void eliminarAutor(Long id) {
        autorRepositorio.deleteById(id);
    }



}
