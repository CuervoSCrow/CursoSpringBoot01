package com.crowpower.cursospringboot01.service;


import com.crowpower.cursospringboot01.model.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//@Primary
//@Profile("prod")
@Service("productoServiceImpl1")
@Order(1)
//@ConditionalOnProperty(
//        name="implementacion.producto.service",
//        havingValue = "implementacion_01",
//        matchIfMissing = true
//)
public class ProductoServiceImpl1
        implements ProductoService  {


    private List<Producto> productos = new ArrayList<>(
            List.of(
                    new Producto(1, "Mouse", 25.0),
                    new Producto(2, "Teclado", 22.0),
                    new Producto(3, "Monitor", 121.0)
            )
    );

    @Override
    public Producto findById(Integer id) {
        return productos.stream()
                .filter(producto -> producto.getCodigo().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public Producto create(Producto producto) {
        productos.add(producto);
        return producto;
    }

    @Override
    public Producto update(
            Integer id,
            Producto producto) {
        Producto productoAModificar = this.findById(id);
        productoAModificar.setNombre(producto.getNombre());
        productoAModificar.setPrecio(producto.getPrecio());

        return productoAModificar;
    }

    @Override
    public String delete(Integer id) {
        Producto productoAEliminar = this.findById(id);
        productos.remove(productoAEliminar);
        return "Impl_1 : Se ha eliminado el producto con id " +
                productoAEliminar.getNombre();
    }
}
