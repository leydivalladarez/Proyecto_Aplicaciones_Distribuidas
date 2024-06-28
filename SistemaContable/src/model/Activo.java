/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabo
 */
public class Activo {
    
    private int id;
    private String nombre;
    private int totalPeriodosDepreciacion;
    private double valorCompra;
    private TipoActivo tipoActivo;

    public Activo(int id, String nombre, int totalPeriodosDepreciacion, double valorCompra, TipoActivo tipoActivo) {
        this.id = id;
        this.nombre = nombre;
        this.totalPeriodosDepreciacion = totalPeriodosDepreciacion;
        this.valorCompra = valorCompra;
        this.tipoActivo = tipoActivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalPeriodosDepreciacion() {
        return totalPeriodosDepreciacion;
    }

    public void setTotalPeriodosDepreciacion(int totalPeriodosDepreciacion) {
        this.totalPeriodosDepreciacion = totalPeriodosDepreciacion;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public TipoActivo getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(TipoActivo tipoActivo) {
        this.tipoActivo = tipoActivo;
    }
}
