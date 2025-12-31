package com.crowpower.CursoSpringBoot01.Controller;

import com.crowpower.CursoSpringBoot01.Model.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaludoController {

    @GetMapping(value = "saludar/{nombre}/{apellido}")
    public String saludar(
            @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) {
        return "Hola "+nombre+" "+apellido+" con Spring Boot";
    }
}
