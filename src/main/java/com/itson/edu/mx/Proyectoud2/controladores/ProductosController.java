package com.itson.edu.mx.Proyectoud2.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itson.edu.mx.Proyectoud2.entidades.Producto;

@RestController
@RequestMapping("/producto") // ruta
public class ProductosController {

    private List<Producto> listaProducto;

    public ProductosController() {
        listaProducto = new ArrayList<>();
    }

    // Get
    @GetMapping()
    public List<Producto> getProductos() {
        return listaProducto;
    }

    // Post
    @PostMapping()
    public int post(@RequestBody Producto producto) {
        try {
            listaProducto.add(producto);
            return 200;
        } catch (Exception e) {
            return 500; // ¿Por qué 500?
        }
    }

    // Prueba:
    @GetMapping(value = "saludar/{nombre}")
    public String saludar(@PathVariable(value = "nombre") String nombre) {
        return "hola " + nombre;
    }
}
