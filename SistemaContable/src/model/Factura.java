/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

public class Factura {
    private int numero;
    private Date fecha;
    private Cliente cliente;
    private List<DetalleFactura> detalles;

    public Factura() {
    }

    public Factura(int numero, Date fecha, Cliente cliente, List<DetalleFactura> detalles) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = detalles;
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    
}
