package com.itson.edu.mx.Proyectoud2.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class unidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private String codigo;


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
    public String getNombre() {
        return nombre;
    }

    /***
     * Método que establece el total
     * 
     * @return total
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Método que obtiene el folio.
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /***
     * Método que establece el total
     * 
     * @return codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
