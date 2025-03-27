package com.registro.usuarios.servicio;


import com.registro.usuarios.controlador.dto.LibroDTO;
import com.registro.usuarios.modelo.libros;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface LibroServiceinte {

    List<LibroDTO> obtenerTodos();
    LibroDTO guardarLibro(LibroDTO libroDTO);
    LibroDTO obtenerPorId(Long id);
    LibroDTO editarLibro(Long id, LibroDTO libroDTO);
    void eliminarLibro(Long id);

}

