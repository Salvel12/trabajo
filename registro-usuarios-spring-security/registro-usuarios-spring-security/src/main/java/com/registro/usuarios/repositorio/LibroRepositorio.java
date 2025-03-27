package com.registro.usuarios.repositorio;

import com.registro.usuarios.modelo.Autores;
import com.registro.usuarios.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.registro.usuarios.modelo.libros;

import java.util.Optional;

@Repository
public interface LibroRepositorio extends JpaRepository<libros, Long> {

    Optional<Usuario> findByNombre(String Nombre);
}
