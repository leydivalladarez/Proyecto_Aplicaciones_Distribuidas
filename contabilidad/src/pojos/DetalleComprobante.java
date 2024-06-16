/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

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
}
