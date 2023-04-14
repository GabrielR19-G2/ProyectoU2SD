package com.itson.edu.mx.Proyectoud2.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private String correo;

    private String RFC;

    private String telefono;

    private String password;

    /***
     * Método que regresa el id
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /***
     * Método usado para establecer el id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /***
     * Método que obtiene el nombre
     * 
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Método que establece el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Método que obtiene el nombre
     * 
     * @return el nombre
     */
    public String getCorreo() {
        return correo;
    }

    /***
     * Método que establece el nombre
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /***
     * Método que obtiene el RFC
     * 
     * @return el RFC
     */
    public String getRFC() {
        return RFC;
    }

    /***
     * Método que establece el id del Producto
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /***
     * Método que obtiene la cantidad.
     * 
     * @return cantidad
     */
    public String getTelefono() {
        return telefono;
    }

    /***
     * Método que obtiene la cantidad.
     * 
     * @return cantidad
     */
    public String getPassword() {
        return password;
    }

    /***
     * Método que establece la cantidad
     * 
     * @return total
     */
    public void setPassword(String contrasenia) {
        this.password = contrasenia;
    }
}
