package com.itson.edu.mx.Proyectoud2.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Integer idProducto;

    private Double cantidad;

    /***
     * Método que regresa el id de la venta
     * 
     * @return id unidadMedida
     */
    public Integer getId() {
        return id;
    }

    /***
     * Método usado para establecer el id unidadMedida
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /***
     * Método que obtiene el total
     * 
     * @return el total
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /***
     * Método que establece el id del Producto
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /***
     * Método que obtiene la cantidad.
     * 
     * @return cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /***
     * Método que establece la cantidad
     * 
     * @return cantidad
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
