package com.crowpower.cursospringboot01.controller;

import com.crowpower.cursospringboot01.model.Producto;
import com.crowpower.cursospringboot01.service.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class ProductoRestController {

    private final ProductoService productoService ;



    @GetMapping(value = "productos/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Producto> productoOpt = this.productoService.findById(id);
        if(productoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No se encontro el producto con id " + id);
        }
        return ResponseEntity.ok(productoOpt.get());
    }

    @GetMapping(value = "/productos")
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @PostMapping(value = "/productos")
    public ResponseEntity<Producto> create(
            @RequestBody Producto producto) {
        Producto nuevoProducto = this.productoService.create(producto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Codigo-Producto",Integer.toString(nuevoProducto.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(nuevoProducto);
    }

    @PutMapping(value = "/productos/{id}")
    public ResponseEntity<Producto> update(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto) {
        Optional<Producto> productoActualizado = this.productoService.update(id,producto);
        if(productoActualizado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoActualizado.get());
    }

    @DeleteMapping(value = "productos/{id}")
    public ResponseEntity<String> delete(
            @PathVariable("id") Integer id) {
        if(this.productoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("No se encontro el producto con id " + id);
    }
}
