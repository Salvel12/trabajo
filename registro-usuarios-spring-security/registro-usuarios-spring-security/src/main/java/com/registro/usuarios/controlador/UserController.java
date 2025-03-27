package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/home")
    public String userHome() {
        return "User"; // Nombre del HTML en templates
    }
}
