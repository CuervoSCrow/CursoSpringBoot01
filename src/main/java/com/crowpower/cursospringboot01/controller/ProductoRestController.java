package com.crowpower.cursospringboot01.controller;

import com.crowpower.cursospringboot01.model.Producto;
import com.crowpower.cursospringboot01.service.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class ProductoRestController {

//    @Autowired
    private final ProductoService productoService ;

    /*
    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

     */
/*
    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

 */

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
