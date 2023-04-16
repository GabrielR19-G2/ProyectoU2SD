package com.itson.edu.mx.Proyectoud2.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Integer unidadMedida;

    private String nombre;

    private String marca;

    private Double precio;

    private String codigo;

    /**
     * Constructor de la clase producto.java
     * 
     * @param nombre
     * @param marca
     * @param precio
     * @param codigo
     * @param unidadMedida
     */
    public Producto(String nombre, String marca, Double precio, String codigo, Integer unidadMedida) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
    }

    /***
     * Método que regresa el id de la venta
     * 
     * @return
     */
    public Integer getId() {
        return id;
    }

    /***
     * Método usado para establecer el id de la venta
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /***
     * Método que regresa el nombre del producto
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Método usado para establecer el nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Método que obtiene la marca
     * 
     * @return la marca
     */
    public String getMarca() {
        return marca;
    }
    /***
     * Método que establece la unidad Medida
     * 
     * @return unidadMedida
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /***
     * Método que obtiene la marca
     * 
     * @return la marca
     */
    public Integer getUnidadMedida() {
        return unidadMedida;
    }

    /***
     * Método que establece la unidad Medida
     * 
     * @return unidadMedida
     */
    public void setUnidadMedida(Integer uM) {
        this.unidadMedida = uM;
    }

    /***
     * Método que obtiene el precio.
     * 
     * @return precio
     */
    public Double getPrecio() {
        return precio;
    }

    /***
     * Método que establece el precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /***
     * Método que obtiene el código.
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /***
     * Método que establece el código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
