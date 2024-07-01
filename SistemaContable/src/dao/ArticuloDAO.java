package dao;

import model.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {
    private Connection connection;

    public ArticuloDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarArticulo(Articulo articulo) throws SQLException {
        String sql = "INSERT INTO articulo (codigo, nombre, precio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, articulo.getCodigo());
            ps.setString(2, articulo.getNombre());
            ps.setFloat(3, articulo.getPrecio());
            ps.executeUpdate();
        }
    }

    public Articulo obtenerArticuloPorCodigo(int codigo) throws SQLException {
        String query = "SELECT * FROM articulo WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setCodigo(rs.getInt("codigo"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setPrecio(rs.getFloat("precio"));
                return articulo;
            }
        }
        return null;
    }

    public List<Articulo> obtenerTodosLosArticulos() throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM articulo";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setCodigo(rs.getInt("codigo"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setPrecio(rs.getFloat("precio"));
                articulos.add(articulo);
            }
        }
        return articulos;
    }

    public void actualizarArticulo(Articulo articulo) throws SQLException {
        String sql = "UPDATE articulo SET nombre = ?, precio = ? WHERE codigo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, articulo.getNombre());
            ps.setFloat(2, articulo.getPrecio());
            ps.setInt(3, articulo.getCodigo());
            ps.executeUpdate();
        }
    }

    public void eliminarArticulo(int codigo) throws SQLException {
        String sql = "DELETE FROM articulo WHERE codigo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }
}
