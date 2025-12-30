package com.crowpower.CursoSpringBoot01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping(value = "saludar/{nombre}/{apellido}")
    public String saludar(
            @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) {
        return "Hola "+nombre+" "+apellido+" con Spring Boot";
    }
}
