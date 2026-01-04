package com.crowpower.cursospringboot01.service;

import com.crowpower.cursospringboot01.model.Producto;
import com.crowpower.cursospringboot01.repository.ProductoRepository;
import com.crowpower.cursospringboot01.util.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;  

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl
    implements ProductoService {

    private final ProductoRepository productoRepository;


    @Override
    public Optional<Producto> findById(Integer id) {
        return this.productoRepository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto create(Producto producto) {
        if(producto.getPrecio()>3000){
            throw new InvalidDataException("El precio no puede ser mayor a 3000");
        }
        return this.productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> update(
            Integer id,
            Producto producto) {
        if(producto.getPrecio()>3000){
            throw new InvalidDataException("El precio no puede ser mayor a 3000");
        }
        Optional<Producto> productoAModificar = this.findById(id);
        if(productoAModificar.isEmpty()) {
            return Optional.empty();
        }
        productoAModificar.get().setNombre(producto.getNombre());
        productoAModificar.get().setPrecio(producto.getPrecio());

        return Optional.of(this.productoRepository.save(productoAModificar.get()));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Producto> productoAEliminar = this.findById(id);
        if(productoAEliminar.isEmpty()) {
            return false;
        }
        this.productoRepository.deleteById(id);
        return true;
    }
}
