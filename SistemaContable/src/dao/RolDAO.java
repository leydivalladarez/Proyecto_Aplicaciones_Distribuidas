package dao;

import model.Rol;
import model.Modulo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolDAO {
    private Connection connection;

    public RolDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarRol(Rol rol) throws SQLException {
        String sql = "INSERT INTO roles (nombre) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, rol.getNombre());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int rolId = rs.getInt(1);
                agregarModulosARol(rolId, rol.getModulos());
            }
        }
    }

    public Rol obtenerRol(int id) throws SQLException {
        String sql = "SELECT * FROM roles WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombre(rs.getString("nombre"));
                rol.setModulos(obtenerModulosDeRol(id));
                return rol;
            }
        }
        return null;
    }

    public List<Rol> obtenerTodosLosRoles() throws SQLException {
        List<Rol> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombre(rs.getString("nombre"));
                rol.setModulos(obtenerModulosDeRol(rol.getId()));
                roles.add(rol);
            }
        }
        return roles;
    }

    public void actualizarRol(Rol rol) throws SQLException {
        String sql = "UPDATE roles SET nombre = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getId());
            ps.executeUpdate();
            
            eliminarModulosDeRol(rol.getId());
            agregarModulosARol(rol.getId(), rol.getModulos());
        }
    }

    public void eliminarRol(int id) throws SQLException {
        String sql = "DELETE FROM roles WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            
            eliminarModulosDeRol(id);
        }
    }

    private void agregarModulosARol(int rolId, List<Modulo> modulos) throws SQLException {
        String sql = "INSERT INTO modulo_rol (modulo_id, rol_id) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Modulo modulo : modulos) {
                ps.setInt(1, modulo.getId());
                ps.setInt(2, rolId);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private List<Modulo> obtenerModulosDeRol(int rolId) throws SQLException {
        List<Modulo> modulos = new ArrayList<>();
        String sql = "SELECT m.* FROM modulos m JOIN modulo_rol mr ON m.id = mr.modulo_id WHERE mr.rol_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, rolId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Modulo modulo = new Modulo();
                modulo.setId(rs.getInt("id"));
                modulo.setNombre(rs.getString("nombre"));
                modulos.add(modulo);
            }
        }
        return modulos;
    }

    private void eliminarModulosDeRol(int rolId) throws SQLException {
        String sql = "DELETE FROM modulo_rol WHERE rol_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, rolId);
            ps.executeUpdate();
        }
    }
}
