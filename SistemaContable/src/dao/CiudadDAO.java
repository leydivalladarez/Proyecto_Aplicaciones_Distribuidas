package dao;

import java.sql.*;
import java.util.*;
import model.Ciudad;

public class CiudadDAO {
    private Connection connection;

    public CiudadDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarCiudad(Ciudad ciudad) throws SQLException {
        String sql = "INSERT INTO ciudad (nombre) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ciudad.getNombre());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ciudad.setCodigo(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Error al crear la ciudad, no se obtuvo el ID.");
                }
            }
        }
    }

    public Ciudad obtenerCiudad(int codigo) throws SQLException {
        String query = "SELECT * FROM ciudad WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCodigo(rs.getInt("codigo"));
                ciudad.setNombre(rs.getString("nombre"));
                return ciudad;
            }
        }
        return null;
    }

    public List<Ciudad> obtenerTodasLasCiudades() throws SQLException {
        List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM ciudad";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCodigo(rs.getInt("codigo"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudades.add(ciudad);
            }
        }
        return ciudades;
    }

    public void actualizarCiudad(Ciudad ciudad) throws SQLException {
        String sql = "UPDATE ciudad SET nombre = ? WHERE codigo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getCodigo());
            ps.executeUpdate();
        }
    }

    public void eliminarCiudad(int codigo) throws SQLException {
        String sql = "DELETE FROM ciudad WHERE codigo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }
}
