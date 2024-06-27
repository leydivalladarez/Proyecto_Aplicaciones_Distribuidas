/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

public class ComprobanteContable {
    private int numero;
    private Date fecha;
    private String tipo;
    private List<DetalleComprobante> detalles;

    public ComprobanteContable(int numero, Date fecha, String tipo, List<DetalleComprobante> detalles) {
        this.numero = numero;
        this.fecha = fecha;
        this.tipo = tipo;
        this.detalles = detalles;
    }

    public ComprobanteContable() {
    }
    

    // Getters y Setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<DetalleComprobante> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleComprobante> detalles) {
        this.detalles = detalles;
    }
    
}
