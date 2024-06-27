/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.SQLException;
import dao.ComprobanteContableDAO;
import model.ComprobanteContable;

public class ComprobanteContableService {
    private ComprobanteContableDAO comprobanteContableDAO;

    public ComprobanteContableService(Connection connection) {
        this.comprobanteContableDAO = new ComprobanteContableDAO(connection);
    }

    public void crearComprobante(ComprobanteContable comprobante) throws SQLException {
        comprobanteContableDAO.insertarComprobante(comprobante);
    }

    // Otros métodos de negocio
}

