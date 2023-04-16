package com.itson.edu.mx.Proyectoud2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itson.edu.mx.Proyectoud2.entidades.Inventario;

@Repository
public interface IInventario extends JpaRepository<Inventario, Integer> {

}
