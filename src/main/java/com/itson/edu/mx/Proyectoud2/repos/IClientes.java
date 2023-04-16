package com.itson.edu.mx.Proyectoud2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itson.edu.mx.Proyectoud2.entidades.Cliente;

@Repository
public interface IClientes extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByRFCContaingingIgnoreCase(String codigo);
}
