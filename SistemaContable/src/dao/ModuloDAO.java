package dao;

import model.Modulo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class ModuloDAO {
    private Connection connection;

    public ModuloDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarModulo(Modulo modulo) throws SQLException {
        String sql = "INSERT INTO modulos (nombre) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, modulo.getNombre());
            ps.executeUpdate();
        }
    }

    public Modulo obtenerModulo(int id) throws SQLException {
        String sql = "SELECT * FROM modulos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Modulo modulo = new Modulo();
                modulo.setId(rs.getInt("id"));
                modulo.setNombre(rs.getString("nombre"));
                return modulo;
            }
        }
        return null;
    }

    public List<Modulo> obtenerTodosLosModulos() throws SQLException {
        List<Modulo> modulos = new ArrayList<>();
        String sql = "SELECT * FROM modulos";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Modulo modulo = new Modulo();
                modulo.setId(rs.getInt("id"));
                modulo.setNombre(rs.getString("nombre"));
                modulos.add(modulo);
            }
        }
        return modulos;
    }

    public void actualizarModulo(Modulo modulo) throws SQLException {
        String sql = "UPDATE modulos SET nombre = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, modulo.getNombre());
            ps.setInt(2, modulo.getId());
            ps.executeUpdate();
        }
    }

    public void eliminarModulo(int id) throws SQLException {
        String sql = "DELETE FROM modulos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
