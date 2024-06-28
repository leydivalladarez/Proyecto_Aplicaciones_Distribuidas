/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo_activos;

/**
 *
 * @author Gabo
 */
import java.util.Date;
import java.util.List;

public class CabeceraDepreciacion {
    private int numeroDepreciacion;
    private Date fechaDepreciacion;
    private String observaciones;
    private String responsable;
    private List<DetalleDepreciacion> detalles;

    public CabeceraDepreciacion(int numeroDepreciacion, Date fechaDepreciacion, String observaciones, String responsable, List<DetalleDepreciacion> detalles) {
        this.numeroDepreciacion = numeroDepreciacion;
        this.fechaDepreciacion = fechaDepreciacion;
        this.observaciones = observaciones;
        this.responsable = responsable;
        this.detalles = detalles;
    }

    public int getNumeroDepreciacion() {
        return numeroDepreciacion;
    }

    public void setNumeroDepreciacion(int numeroDepreciacion) {
        this.numeroDepreciacion = numeroDepreciacion;
    }

    public Date getFechaDepreciacion() {
        return fechaDepreciacion;
    }

    public void setFechaDepreciacion(Date fechaDepreciacion) {
        this.fechaDepreciacion = fechaDepreciacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<DetalleDepreciacion> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleDepreciacion> detalles) {
        this.detalles = detalles;
    }
}