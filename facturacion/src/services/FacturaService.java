/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.SQLException;
import dao.*;
import pojo.*;

public class FacturaService {
    private FacturaDAO facturaDAO;
    private ClienteDAO clienteDAO;
    private ArticuloDAO articuloDAO;

    public FacturaService(Connection connection) {
        this.facturaDAO = new FacturaDAO(connection);
        this.clienteDAO = new ClienteDAO(connection);
        this.articuloDAO = new ArticuloDAO(connection);
    }

    public void crearFactura(Factura factura) throws SQLException {
        facturaDAO.insertarFactura(factura);
    }

    public Cliente obtenerClientePorId(int id) throws SQLException {
        return clienteDAO.obtenerClientePorId(id);
    }

    public Articulo obtenerArticuloPorCodigo(int codigo) throws SQLException {
        return articuloDAO.obtenerArticuloPorCodigo(codigo);
    }

    // Otros métodos de negocio
}
