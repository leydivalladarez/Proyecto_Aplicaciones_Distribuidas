package services;

import dao.ArticuloDAO;
import model.Articulo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ArticuloService {
    private ArticuloDAO articuloDAO;

    public ArticuloService(Connection connection) {
        this.articuloDAO = new ArticuloDAO(connection);
    }

    public void agregarArticulo(Articulo articulo) throws SQLException {
        articuloDAO.agregarArticulo(articulo);
    }

    public Articulo obtenerArticuloPorCodigo(int codigo) throws SQLException {
        return articuloDAO.obtenerArticuloPorCodigo(codigo);
    }

    public List<Articulo> obtenerTodosLosArticulos() throws SQLException {
        return articuloDAO.obtenerTodosLosArticulos();
    }

    public void actualizarArticulo(Articulo articulo) throws SQLException {
        articuloDAO.actualizarArticulo(articulo);
    }

    public void eliminarArticulo(int codigo) throws SQLException {
        articuloDAO.eliminarArticulo(codigo);
    }
}
