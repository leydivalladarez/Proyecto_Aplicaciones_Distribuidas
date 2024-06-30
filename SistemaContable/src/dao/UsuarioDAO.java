package dao;

import model.Usuario;
import model.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection;
    private RolDAO rolDAO;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
        this.rolDAO = new RolDAO(connection);
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (usuario, contrasenia, rol_id) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasenia());
            ps.setInt(3, usuario.getRol().getId());
            ps.executeUpdate();
        }
    }

    public Usuario obtenerUsuario(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setRol(rolDAO.obtenerRol(rs.getInt("rol_id")));
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setRol(rolDAO.obtenerRol(rs.getInt("rol_id")));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET usuario = ?, contrasenia = ?, rol_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasenia());
            ps.setInt(3, usuario.getRol().getId());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
        }
    }

    public void eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Usuario loguearUsuario(String usuario, String contrasenia) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuarioM = obtenerUsuario(rs.getInt("id"));
                return usuarioM;
            }
            //return rs.next(); // Devuelve true si existe una fila con las credenciales proporcionadas
        }
        return null;
    }
}
