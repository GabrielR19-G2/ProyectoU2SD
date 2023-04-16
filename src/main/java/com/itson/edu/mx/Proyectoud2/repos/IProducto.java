package com.itson.edu.mx.Proyectoud2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itson.edu.mx.Proyectoud2.entidades.Producto;

@Repository
public interface IProducto extends JpaRepository<Producto, Integer>{
    List<Producto> findByCodigoContaingingIgnoreCase(String codigo);
    List<Producto> findByMarcaContaingingIgnoreCase(String marca);
}
