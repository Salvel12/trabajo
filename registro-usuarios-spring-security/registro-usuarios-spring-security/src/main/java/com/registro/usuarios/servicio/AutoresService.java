package com.registro.usuarios.servicio;


import com.registro.usuarios.controlador.dto.AutorDTO;
import com.registro.usuarios.modelo.Autores;
import com.registro.usuarios.modelo.libros;
import com.registro.usuarios.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AutoresService implements AutoresServiceinter{

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


    public Autores guardarAutor(Autores a) {
        return autorRepositorio.save(a);
    }

    public Autores obtenerAutorPorIdEntidad(Long id) {
        return autorRepositorio.findById(id).orElse(null);
    }

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


    public void eliminarAutor(Long id) {
        autorRepositorio.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
