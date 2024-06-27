/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;

public class DetalleComprobante {
    private int id;
    private ComprobanteContable comprobante;
    private String cuenta;
    private BigDecimal debe;
    private BigDecimal haber;

    public DetalleComprobante(int id, ComprobanteContable comprobante, String cuenta, BigDecimal debe, BigDecimal haber) {
        this.id = id;
        this.comprobante = comprobante;
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
    }
    

    // Getters y Setters

    public DetalleComprobante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ComprobanteContable getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteContable comprobante) {
        this.comprobante = comprobante;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getDebe() {
        return debe;
    }

    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }

    public BigDecimal getHaber() {
        return haber;
    }

    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }
    
    
}
