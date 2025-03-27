package com.registro.usuarios.controlador;

import com.registro.usuarios.controlador.dto.AutorDTO;
import com.registro.usuarios.controlador.dto.LibroDTO;
import com.registro.usuarios.modelo.Autores;
import com.registro.usuarios.servicio.AutoresServiceinter;
import com.registro.usuarios.servicio.LibroServiceinte;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AutoresServiceinter autoresService;

    @Autowired
    private LibroServiceinte libroService;



    @GetMapping("")
    public String Listar(Model modelo) {
        List<AutorDTO>autores=autoresService.obtenerAutores();
        modelo.addAttribute("Autores", autoresService.obtenerAutores());

        List<LibroDTO> libros = libroService.obtenerTodos();
        modelo.addAttribute("Libros", libros);

        return "Admin";
    }

    @GetMapping("/new")
    public String agregar(Model modelo){
        modelo.addAttribute("Autores", new Autores());
        return "form1";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("autor") Autores autor) {
        autoresService.guardarAutor(autor);
        return "redirect:/admin/listar";
    }
}
