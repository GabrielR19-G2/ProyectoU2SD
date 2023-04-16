package com.itson.edu.mx.Proyectoud2.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itson.edu.mx.Proyectoud2.entidades.Producto;
import com.itson.edu.mx.Proyectoud2.repos.IProducto;

@RestController
@RequestMapping("/producto") // ruta
public class ProductosController {
    @Autowired
    private IProducto iprod;
    List<Producto> prods;


    // Get
    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerProductosId(@PathVariable("id") Integer id) {
        Optional listaProducto = iprod.findById(id);

        if (listaProducto.isPresent()) {
            return ResponseEntity.ok(listaProducto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Integer id) {
        Optional<Producto> productoExiste = iprod.findById(id);

        if (productoExiste.isPresent()) {
            iprod.delete(productoExiste.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Integer id, @RequestBody Producto productoActualizar) {
        Optional<Producto> productoExiste = iprod.findById(id);

        if (productoExiste.isPresent()) {
            Producto prod = productoExiste.get();
                prod.setNombre(productoActualizar.getNombre());
                prod.setCodigo(productoActualizar.getCodigo());
                prod.setPrecio(productoActualizar.getPrecio());
                prod.setMarca(productoActualizar.getMarca());      
                prod.setUnidadMedida(productoActualizar.getUnidadMedida());
            iprod.save(prod);
            return ResponseEntity.ok(prod);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/marca")
    public ResponseEntity<List<Producto>> obtenerVentaPorMarca(@RequestParam(value = "marca", required = false) String marca) {
        if (marca == null) {
            prods = iprod.findAll();
        } else {
            prods = iprod.findByMarcaContaingingIgnoreCase(marca);
        }

        if (prods.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(prods);
    }

    @GetMapping("/codigo")
    public ResponseEntity<List<Producto>> obtenerProductoPorCodigo(@RequestParam(value = "codigo", required = false) String codigo) {
        if (codigo == null) {
            prods = iprod.findAll();
        } else {
            prods = iprod.findByCodigoContaingingIgnoreCase(codigo);
        }

        if (prods.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(prods);
    }

    // Prueba:
    @GetMapping(value = "saludar/{nombre}")
    public String saludar(@PathVariable(value = "nombre") String nombre) {
        return "hola " + nombre;
    }
}
