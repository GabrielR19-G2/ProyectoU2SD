package com.itson.edu.mx.Proyectoud2.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Integer idVenta;

    @OneToMany
    private Integer idProducto;

    private Double cantidad;

    private Double total;

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
     * Método que obtiene el id del producto
     * 
     * @return el id del Producto
     */
    public Integer getIdVenta() {
        return idVenta;
    }

    /***
     * Método que establece el id del Producto
     */
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    /***
     * Método que obtiene el id del producto
     * 
     * @return el id del Producto
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
     * Método que obtiene la cantidad.
     * 
     * @return cantidad
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /***
     * Método que obtiene la cantidad.
     * 
     * @return cantidad
     */
    public Double getTotal() {
        return total;
    }

    /***
     * Método que establece la cantidad
     * 
     * @return total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

}
