package com.registro.usuarios.servicio;

import java.util.List;
import com.registro.usuarios.controlador.dto.AutorDTO;
import com.registro.usuarios.modelo.Autores;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutoresServiceinter extends UserDetailsService {


    List<AutorDTO> obtenerAutores();
    public Autores guardarAutor(Autores a);

    Autores obtenerAutorPorIdEntidad(Long id);
    AutorDTO obtenerAutorPorId(Long id);
    void eliminarAutor(Long id);


}
