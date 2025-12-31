package com.crowpower.cursospringboot01.controller;

import com.crowpower.cursospringboot01.model.Producto;
import com.crowpower.cursospringboot01.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class ProductoRestController {

    private ProductoService productoService = new ProductoService();


    @GetMapping(value = "productos/{id}")
    public Producto findById(@PathVariable("id") Integer id) {
        return this.productoService.findById(id);
    }

    @GetMapping(value = "/productos")
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @PostMapping(value = "/productos")
    public Producto create(
            @RequestBody Producto producto) {
        return this.productoService.create(producto);
    }

    @PutMapping(value = "/productos/{id}")
    public Producto update(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto) {

        return productoService.update(id,producto);
    }

    @DeleteMapping(value = "productos/{id}")
    public String delete(
            @PathVariable("id") Integer id) {
       return this.productoService.delete(id);
    }
}
