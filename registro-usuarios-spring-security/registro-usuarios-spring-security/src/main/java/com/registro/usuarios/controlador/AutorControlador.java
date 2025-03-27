package com.registro.usuarios.controlador;

import com.registro.usuarios.controlador.dto.AutorDTO;
import com.registro.usuarios.modelo.Autores;
import com.registro.usuarios.servicio.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorControlador {

    @Autowired
    private AutoresService autoresService;


    @GetMapping
    public ResponseEntity<List<AutorDTO>> obtenerTodos() {
        List<AutorDTO> autores = autoresService.obtenerAutores();
        return ResponseEntity.ok(autores);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obtenerPorId(@PathVariable Long id) {
        AutorDTO autor = autoresService.obtenerAutorPorId(id);
        return ResponseEntity.ok(autor);
    }


    @PostMapping
    public ResponseEntity<Autores> crearAutor(@RequestBody Autores autor) {
        Autores nuevoAutor = autoresService.guardarAutor(autor);
        return ResponseEntity.ok(nuevoAutor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Autores> actualizarAutor(@PathVariable Long id, @RequestBody Autores autorActualizado) {
        Autores autor = autoresService.obtenerAutorPorIdEntidad(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }

        autor.setNombre(autorActualizado.getNombre());
        Autores autorGuardado = autoresService.guardarAutor(autor);
        return ResponseEntity.ok(autorGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        autoresService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }
}
