package com.itson.edu.mx.Proyectoud2.controladores;

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

import com.itson.edu.mx.Proyectoud2.entidades.Inventario;
import com.itson.edu.mx.Proyectoud2.repos.IInventario;

@Controller
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private IInventario iInventario;

    // consultará en base al id del inventario.
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerInventarioPorID(@PathVariable("id") Integer id) {
        Optional<Inventario> inventario = iInventario.findById(id);

        if (inventario.isPresent()) {
            return ResponseEntity.ok(inventario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Método que actualiza el inventario
     * @param id
     * @param clienteActualizar
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable("id") Integer id,
            @RequestBody Inventario inventarioActualizar) {
        Optional<Inventario> inventarioExiste = iInventario.findById(id);

        if (inventarioExiste.isPresent()) {
            Inventario inventario = inventarioExiste.get();
            inventario.setCantidad(inventarioActualizar.getCantidad());
            iInventario.save(inventario);
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable("id") Integer id) {
        Optional<Inventario> productoExiste = iInventario.findById(id);

        if (productoExiste.isPresent()) {
            iInventario.delete(productoExiste.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
