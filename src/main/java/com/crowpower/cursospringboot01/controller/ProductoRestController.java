package com.crowpower.cursospringboot01.controller;

import com.crowpower.cursospringboot01.model.Producto;
import com.crowpower.cursospringboot01.service.ProductoService;

import com.crowpower.cursospringboot01.util.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        List<Producto> productos = this.productoService.findAll();
        if(productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping(value = "/productos")
    public ResponseEntity<?> create(
            @RequestBody Producto producto) {
        try {
            Producto nuevoProducto = this.productoService.create(producto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(nuevoProducto.getCodigo())
                            .toUri();
            return ResponseEntity.created(location).body(nuevoProducto);
        } catch (InvalidDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error inesperado");
        }
    }

    @PutMapping(value = "/productos/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto) {
        try {
            Optional<Producto> productoActualizado = this.productoService.update(id, producto);
            if (productoActualizado.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productoActualizado.get());
        }catch (InvalidDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error inesperado");
        }
    }

    @DeleteMapping(value = "productos/{id}")
    public ResponseEntity<String> delete(
            @PathVariable("id") Integer id) {
        try {
            if (this.productoService.delete(id)) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro el producto con id " + id);
        }catch(Exception e) {
            return ResponseEntity.internalServerError().body("Error inesperado");
        }
    }
}
