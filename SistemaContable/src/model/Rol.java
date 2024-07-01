/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author gamert
 */
public class Rol {
    private int id;
    private String nombre;
    private List<Modulo> modulos;

    public Rol() {
    }

    public Rol(int id, String nombre, List<Modulo> modulos) {
        this.id = id;
        this.nombre = nombre;
        this.modulos = modulos;
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

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }     
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
