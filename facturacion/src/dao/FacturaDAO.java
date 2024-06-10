package dao;

import java.sql.*;
import java.util.*;
import pojo.*;

public class FacturaDAO {
    private Connection connection;

    public FacturaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarFactura(Factura factura) throws SQLException {
        String queryFactura = "INSERT INTO factura (numero, fecha, cliente_id) VALUES (?, ?, ?)";
        String queryDetalle = "INSERT INTO detalle_factura (factura_numero, articulo_codigo, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmtFactura = connection.prepareStatement(queryFactura);
             PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
             
            connection.setAutoCommit(false);
            
            stmtFactura.setInt(1, factura.getNumero());
            stmtFactura.setDate(2, new java.sql.Date(factura.getFecha().getTime()));
            stmtFactura.setInt(3, factura.getCliente().getId());
            stmtFactura.executeUpdate();

            for (DetalleFactura detalle : factura.getDetalles()) {
                stmtDetalle.setInt(1, factura.getNumero());
                stmtDetalle.setInt(2, detalle.getArticulo().getCodigo());
                stmtDetalle.setInt(3, detalle.getCantidad());
                stmtDetalle.setFloat(4, detalle.getPrecioUnitario());
                stmtDetalle.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Otros métodos CRUD
}
