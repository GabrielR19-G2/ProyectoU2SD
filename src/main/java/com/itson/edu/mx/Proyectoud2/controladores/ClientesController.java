package com.itson.edu.mx.Proyectoud2.controladores;

import java.util.List;
//Este es! por eso me tiraba error
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

import com.itson.edu.mx.Proyectoud2.entidades.Cliente;
import com.itson.edu.mx.Proyectoud2.repos.IClientes;

@Controller
@RequestMapping("/cliente")
public class ClientesController {
    // deberán poderse obtener por id o por RFC.
    @Autowired
    private IClientes ic;

    @GetMapping("/RFC")
    public ResponseEntity<List<Cliente>> obternerClientePorRFC(
            @RequestParam(value = "RFC", required = false) String RFC) {
        List<Cliente> clientes;
        if (RFC == null) {
            clientes = ic.findAll();
        } else {
            clientes = ic.findByRFCContaingingIgnoreCase(RFC);
        }

        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorID(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente = ic.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @param id
     * @param clienteActualizar
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarClientes(@PathVariable("id") Integer id,
            @RequestBody Cliente clienteActualizar) {
        Optional<Cliente> clienteExiste = ic.findById(id);

        if (clienteExiste.isPresent()) {
            Cliente cliente = clienteExiste.get();
            cliente.setNombre(clienteActualizar.getNombre());
            cliente.setCorreo(clienteActualizar.getCorreo());
            cliente.setTelefono(clienteActualizar.getTelefono());
            cliente.setPassword(clienteActualizar.getNombre());
            ic.save(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Integer id) {
        Optional<Cliente> productoExiste = ic.findById(id);

        if (productoExiste.isPresent()) {
            ic.delete(productoExiste.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
