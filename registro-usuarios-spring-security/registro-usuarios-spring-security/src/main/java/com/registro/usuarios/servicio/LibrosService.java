package com.registro.usuarios.servicio;

import com.registro.usuarios.controlador.dto.LibroDTO;
import com.registro.usuarios.modelo.Autores;
import com.registro.usuarios.modelo.libros;
import com.registro.usuarios.repositorio.AutorRepositorio;
import com.registro.usuarios.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LibrosService implements LibroServiceinte{

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;


    public List<LibroDTO> obtenerTodos() {
        List<libros> libros = libroRepositorio.findAll();
        return libros.stream().map(this::convertirADTO).collect(Collectors.toList());
    }




    public LibroDTO guardarLibro(LibroDTO libroDTO) {
        Optional<Autores> autorOpt = autorRepositorio.findById(libroDTO.getAutorId());
        if (!autorOpt.isPresent()) {
            throw new RuntimeException("Autor no encontrado");
        }

        libros libro = new libros();
        libro.setNombre(libroDTO.getNombre());
        libro.setGenero(libroDTO.getGenero());
        libro.setFechaLanzamiento(libroDTO.getFechaLanzamiento());
        libro.setAutor(autorOpt.get());

        libro = libroRepositorio.save(libro);
        return convertirADTO(libro);
    }


    public LibroDTO obtenerPorId(Long id) {
        libros libro = libroRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return convertirADTO(libro);
    }


    public LibroDTO editarLibro(Long id, LibroDTO libroDTO) {
        libros libro = libroRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        Optional<Autores> autorOpt = autorRepositorio.findById(libroDTO.getAutorId());
        if (!autorOpt.isPresent()) {
            throw new RuntimeException("Autor no encontrado");
        }

        libro.setNombre(libroDTO.getNombre());
        libro.setGenero(libroDTO.getGenero());
        libro.setFechaLanzamiento(libroDTO.getFechaLanzamiento());
        libro.setAutor(autorOpt.get());

        libro = libroRepositorio.save(libro);
        return convertirADTO(libro);
    }


    public void eliminarLibro(Long id) {
        libroRepositorio.deleteById(id);
    }


    private LibroDTO convertirADTO(libros libro) {
        Autores autor = libro.getAutor();
        return new LibroDTO(libro.getId(), libro.getNombre(), libro.getGenero(),
                libro.getFechaLanzamiento(), autor.getId());
    }


}
