/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import model.ComprobanteContable;
import model.DetalleComprobante;

public class ComprobanteContableDAO {
    private Connection connection;

    public ComprobanteContableDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarComprobante(ComprobanteContable comprobante) throws SQLException {
        String queryComprobante = "INSERT INTO comprobante_contable (numero, fecha, tipo) VALUES (?, ?, ?)";
        String queryDetalle = "INSERT INTO detalle_comprobante (comprobante_numero, cuenta, debe, haber) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmtComprobante = connection.prepareStatement(queryComprobante);
             PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
             
            connection.setAutoCommit(false);
            
            stmtComprobante.setInt(1, comprobante.getNumero());
            stmtComprobante.setDate(2, new java.sql.Date(comprobante.getFecha().getTime()));
            stmtComprobante.setString(3, comprobante.getTipo());
            stmtComprobante.executeUpdate();

            for (DetalleComprobante detalle : comprobante.getDetalles()) {
                stmtDetalle.setInt(1, comprobante.getNumero());
                stmtDetalle.setString(2, detalle.getCuenta());
                stmtDetalle.setBigDecimal(3, detalle.getDebe());
                stmtDetalle.setBigDecimal(4, detalle.getHaber());
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
