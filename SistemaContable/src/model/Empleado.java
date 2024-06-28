package model;

import java.util.Date;

public class Empleado {
    private String cedula;
    private String nombre;
    private Date fechaIngreso;
    private double sueldo;

    // Getters y setters
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Date getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
}
