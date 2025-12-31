package com.crowpower.CursoSpringBoot01.Controller;

import com.crowpower.CursoSpringBoot01.Model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class ProductoRestController {

    private List<Producto> productos = new ArrayList<>(
        List.of(
            new Producto(1, "Mouse", 25.0),
            new Producto(2, "Teclado", 22.0),
            new Producto(3, "Monitor", 121.0)
        )
    );

    @GetMapping(value = "productos/{id}")
    public Producto findById(@PathVariable("id") Integer id) {
        return productos.stream()
                .filter(producto -> producto.getCodigo().equals(id))
                .findAny()
                .orElseThrow();
    }

    @GetMapping(value = "/productos")
    public List<Producto> findAll() {
        return productos;
    }

    @PostMapping(value = "/productos")
    public Producto create(
            @RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

    @PutMapping(value = "/productos/{id}")
    public Producto update(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto) {
        Producto productoAModificar =
                productos.stream()
                .filter(p -> p.getCodigo().equals(id))
                .findAny()
                .orElseThrow();

        productoAModificar.setNombre(producto.getNombre());
        productoAModificar.setPrecio(producto.getPrecio());

        return productoAModificar;
    }

    @DeleteMapping(value = "productos/{id}")
    public String delete(
            @PathVariable("id") Integer id) {
        Producto productoAEliminar =
                productos.stream()
                .filter(p -> p.getCodigo().equals(id))
                .findAny()
                .orElseThrow();
        productos.remove(productoAEliminar);
        return "Se ha eliminado el producto con id " +
                productoAEliminar.getNombre();
    }
}
