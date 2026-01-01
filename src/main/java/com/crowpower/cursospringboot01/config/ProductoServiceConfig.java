package com.crowpower.cursospringboot01.config;

import com.crowpower.cursospringboot01.service.ProductoService;
import com.crowpower.cursospringboot01.service.ProductoServiceImpl1;
import com.crowpower.cursospringboot01.service.ProductoServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoServiceConfig {

//    @Bean
//    public ProductoService productoService(){
////        Logica que permite decidir el bean a inyectar
//        double aleatorio = Math.random();
//        if(aleatorio < 0.5){
//            System.out.println("Se inyecta ProductoServiceImpl1");
//            return new ProductoServiceImpl1();
//        }else{
//            System.out.println("Se inyecta ProductoServiceImpl2");
//            return new ProductoServiceImpl2();
//
//        }
//    }
}
