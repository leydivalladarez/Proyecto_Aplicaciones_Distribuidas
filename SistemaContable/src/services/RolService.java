package services;

import model.Rol;
import dao.RolDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RolService {
    private RolDAO rolDAO;

    public RolService(Connection connection) {
        this.rolDAO = new RolDAO(connection);
    }

    public void agregarRol(Rol rol) throws SQLException {
        rolDAO.agregarRol(rol);
    }

    public Rol obtenerRol(int id) throws SQLException {
        return rolDAO.obtenerRol(id);
    }

    public List<Rol> obtenerTodosLosRoles() throws SQLException {
        return rolDAO.obtenerTodosLosRoles();
    }

    public void actualizarRol(Rol rol) throws SQLException {
        rolDAO.actualizarRol(rol);
    }

    public void eliminarRol(int id) throws SQLException {
        rolDAO.eliminarRol(id);
    }
}
