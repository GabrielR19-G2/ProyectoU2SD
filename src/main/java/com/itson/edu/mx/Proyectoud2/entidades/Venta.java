package com.itson.edu.mx.Proyectoud2.entidades;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Integer idCliente;

    private Double total;

    private String folio;

    private Date fecha;

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
     * Método que obtiene el total
     * 
     * @return el total
     */
    public Double getTotal() {
        return total;
    }

    /***
     * Método que establece el total
     * 
     * @return total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /***
     * Método que obtiene el folio.
     * 
     * @return folio
     */
    public String getFolio() {
        return folio;
    }

    /***
     * Método que establece el folio
     */
    public void setFolio(String fol) {
        this.folio = fol;
    }

    /***
     * Método que obtiene la fecha.
     * 
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /***
     * Método que establece la fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
