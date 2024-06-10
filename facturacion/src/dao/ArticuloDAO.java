/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import pojo.Articulo;

public class ArticuloDAO {
    private Connection connection;

    public ArticuloDAO(Connection connection) {
        this.connection = connection;
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

    // Otros métodos CRUD
}
