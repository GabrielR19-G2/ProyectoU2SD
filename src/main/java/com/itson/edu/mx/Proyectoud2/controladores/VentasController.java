package com.itson.edu.mx.Proyectoud2.controladores;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itson.edu.mx.Proyectoud2.entidades.Venta;
import com.itson.edu.mx.Proyectoud2.repos.IVentas;

@Controller
@RequestMapping("/venta")
public class VentasController {
    @Autowired
    private IVentas iVenta;
    List<Venta> venta;

    /**
     * consultar por id, folio, fecha y idCliente
     * 
     * el resultado de consultar las ventas, deberá regresar la información de la
     * venta, asi como una lista de los productos, los cuales estarán guardados en
     * la tabla de detalle.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorID(@PathVariable("id") Integer id) {
        Optional<Venta> venta = iVenta.findById(id);

        if (venta.isPresent()) {
            return ResponseEntity.ok(venta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/folio")
    public ResponseEntity<List<Venta>> obtenerVentaPorID(
            @RequestParam(value = "folio", required = false) String folio) {
        if (folio == null) {
            venta = iVenta.findAll();
        } else {
            venta = iVenta.findByFolioContaingingIgnoreCase(folio);
        }

        if (venta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(venta);
    }

    /**
     * Método que obtiene la venta por la fecha
     */
    @PutMapping("/fecha")
    public ResponseEntity<List<Venta>> obtenerVentaPorFecha(
            @RequestParam(value = "fecha", required = false) Date fechaVenta) {
        List<Venta> ventas;
        if (fechaVenta == null) {
            ventas = iVenta.findAll();
        } else {
            ventas = iVenta.findByFechaContaingingIgnoreCase(fechaVenta);
        }

        if (ventas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/idCliente")
    public ResponseEntity<List<Venta>> obtenerVentaPorIdCliente(
            @RequestParam(value = "idCliente", required = false) Integer idCliente) {
        if (idCliente == null) {
            venta = iVenta.findAll();
        } else {
            venta = iVenta.findByIdClienteContaingingIgnoreCase(idCliente);
        }

        if (venta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(venta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable("id") Integer id) {
        Optional<Venta> productoExiste = iVenta.findById(id);

        if (productoExiste.isPresent()) {
            iVenta.delete(productoExiste.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
