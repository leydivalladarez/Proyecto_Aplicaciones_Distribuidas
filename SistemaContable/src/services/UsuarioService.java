/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.Usuario;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService(Connection connection) {
        this.usuarioDAO = new UsuarioDAO(connection);
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

    public boolean loguearUsuario(String usuario, String contrasenia) throws SQLException {
        return usuarioDAO.loguearUsuario(usuario, contrasenia);
    }

    // Otros métodos de negocio relacionados con Usuario
}
