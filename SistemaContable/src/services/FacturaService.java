package services;

import dao.FacturaDAO;
import dao.ClienteDAO;
import dao.CiudadDAO;
import dao.ArticuloDAO;
import model.Factura;
import model.Cliente;
import model.Ciudad;
import model.Articulo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FacturaService {
    private FacturaDAO facturaDAO;
    private ClienteDAO clienteDAO;
    private CiudadDAO ciudadDAO;
    private ArticuloDAO articuloDAO;

    public FacturaService(Connection connection) {
        this.facturaDAO = new FacturaDAO(connection);
        this.clienteDAO = new ClienteDAO(connection);
        this.ciudadDAO = new CiudadDAO(connection);
        this.articuloDAO = new ArticuloDAO(connection);
    }

    public void crearFactura(Factura factura) throws SQLException {
        facturaDAO.insertarFactura(factura);
    }

    public Factura obtenerFacturaPorId(int id) throws SQLException {
        return facturaDAO.obtenerFacturaPorId(id);
    }
    
    public Factura obtenerFacturaPorNumero(int numero) throws SQLException {
        return facturaDAO.obtenerFacturaPorNumero(numero);
    }

    public List<Factura> obtenerTodasLasFacturas() throws SQLException {
        return facturaDAO.obtenerTodasLasFacturas();
    }

    public void actualizarFactura(Factura factura) throws SQLException {
        facturaDAO.actualizarFactura(factura);
    }

    public void eliminarFactura(int numero) throws SQLException {
        facturaDAO.eliminarFactura(numero);
    }

    public Cliente obtenerClientePorId(int id) throws SQLException {
        return clienteDAO.obtenerClientePorId(id);
    }

    public Ciudad obtenerCiudadPorCodigo(int codigo) throws SQLException {
        return ciudadDAO.obtenerCiudad(codigo);
    }

    public Articulo obtenerArticuloPorCodigo(int codigo) throws SQLException {
        return articuloDAO.obtenerArticuloPorCodigo(codigo);
    }
}
