package com.crowpower.cursospringboot01.controller;

import com.crowpower.cursospringboot01.model.Producto;
import com.crowpower.cursospringboot01.service.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class ProductoRestController {

//    @Autowired
    private final List<ProductoService> productoService ;
    private final int pos=2;

    /*
    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

     */

//    public ProductoRestController(@Qualifier("productoServiceImpl2")
//                                  ProductoService productoService) {
//        this.productoService = productoService;
//    }



    @GetMapping(value = "productos/{id}")
    public Producto findById(@PathVariable("id") Integer id) {
        return this.productoService.get(pos).findById(id);
    }

    @GetMapping(value = "/productos")
    public List<Producto> findAll() {
        return productoService.get(pos).findAll();
    }

    @PostMapping(value = "/productos")
    public Producto create(
            @RequestBody Producto producto) {
        return this.productoService.get(pos).create(producto);
    }

    @PutMapping(value = "/productos/{id}")
    public Producto update(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto) {

        return productoService.get(pos).update(id,producto);
    }

    @DeleteMapping(value = "productos/{id}")
    public String delete(
            @PathVariable("id") Integer id) {
       return this.productoService.get(0).delete(id);
    }
}
