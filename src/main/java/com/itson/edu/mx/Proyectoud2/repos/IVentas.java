package com.itson.edu.mx.Proyectoud2.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itson.edu.mx.Proyectoud2.entidades.Venta;

@Repository
public interface IVentas extends JpaRepository<Venta,Integer>{
    List<Venta> findByFechaContaingingIgnoreCase(Date fechaVenta);
    List<Venta> findByFolioContaingingIgnoreCase(String folio);
    List<Venta> findByIdClienteContaingingIgnoreCase(Integer idCliente);
}
