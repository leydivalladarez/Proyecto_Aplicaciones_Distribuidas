/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

public class Factura {
    private int id;
    private int numero;
    private Date fecha;
    private Cliente cliente;
    private Ciudad ciudad;
    private List<DetalleFactura> detalles;

    public Factura() {
    }

    public Factura(int id,int numero, Date fecha, Cliente cliente, Ciudad ciudad, List<DetalleFactura> detalles) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.ciudad = ciudad;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
