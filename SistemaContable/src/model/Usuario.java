/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gamert
 */
public class Usuario {
    private int id;
    private String usuario;
    private String contrasenia;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Usuario(int id, String usuario, String contrasenia, Rol rol) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
