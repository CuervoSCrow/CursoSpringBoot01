package com.crowpower.cursospringboot01.repository;

import com.crowpower.cursospringboot01.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository
        extends JpaRepository<Producto,Integer> {

}
