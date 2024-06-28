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
public class DetalleDepreciacion {
    private Activo activo;
    private int numeroPeriodo;
    private double valorDepreciacion;

    public DetalleDepreciacion(Activo activo, int numeroPeriodo, double valorDepreciacion) {
        this.activo = activo;
        this.numeroPeriodo = numeroPeriodo;
        this.valorDepreciacion = valorDepreciacion;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public int getNumeroPeriodo() {
        return numeroPeriodo;
    }

    public void setNumeroPeriodo(int numeroPeriodo) {
        this.numeroPeriodo = numeroPeriodo;
    }

    public double getValorDepreciacion() {
        return valorDepreciacion;
    }

    public void setValorDepreciacion(double valorDepreciacion) {
        this.valorDepreciacion = valorDepreciacion;
    }
}
