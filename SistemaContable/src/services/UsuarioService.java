/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ModuloDAO;
import model.Usuario;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Modulo;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;
    private ModuloDAO moduloDAO;

    public UsuarioService(Connection connection) {
        this.usuarioDAO = new UsuarioDAO(connection);
        this.moduloDAO = new ModuloDAO(connection);
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.agregarUsuario(usuario);
    }

    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        return usuarioDAO.obtenerUsuario(id);
    }

    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        return usuarioDAO.obtenerTodosLosUsuarios();
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) throws SQLException {
        usuarioDAO.eliminarUsuario(id);
    }

    public Usuario loguearUsuario(String usuario, String contrasenia) throws SQLException {
        Usuario usuarioM = usuarioDAO.loguearUsuario(usuario, contrasenia);
        if(usuarioM != null && usuarioM.getRol().getId() == 1){
            usuarioM.getRol().setModulos(moduloDAO.obtenerTodosLosModulos());            
        }        
        return usuarioM;
    }
    
    public List<Modulo> obtenerTodosLosModulos() throws SQLException{
        return moduloDAO.obtenerTodosLosModulos();
    }

    public boolean existeUsuario(String usuario) throws SQLException{
        return usuarioDAO.existeUsuario(usuario);
    }
}
