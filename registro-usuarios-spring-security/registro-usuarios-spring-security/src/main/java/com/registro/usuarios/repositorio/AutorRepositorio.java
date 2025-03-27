package com.registro.usuarios.repositorio;

import com.registro.usuarios.modelo.Usuario;
import java.util.Optional;
import com.registro.usuarios.modelo.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autores, Long> {
}
