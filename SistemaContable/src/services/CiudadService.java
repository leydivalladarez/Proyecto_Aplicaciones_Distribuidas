package services;

import dao.CiudadDAO;
import model.Ciudad;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CiudadService {
    private CiudadDAO ciudadDAO;

    public CiudadService(Connection connection) {
        this.ciudadDAO = new CiudadDAO(connection);
    }

    public void agregarCiudad(Ciudad ciudad) throws SQLException {
        ciudadDAO.agregarCiudad(ciudad);
    }

    public Ciudad obtenerCiudad(int codigo) throws SQLException {
        return ciudadDAO.obtenerCiudad(codigo);
    }

    public List<Ciudad> obtenerTodasLasCiudades() throws SQLException {
        return ciudadDAO.obtenerTodasLasCiudades();
    }

    public void actualizarCiudad(Ciudad ciudad) throws SQLException {
        ciudadDAO.actualizarCiudad(ciudad);
    }

    public void eliminarCiudad(int codigo) throws SQLException {
        ciudadDAO.eliminarCiudad(codigo);
    }
}
