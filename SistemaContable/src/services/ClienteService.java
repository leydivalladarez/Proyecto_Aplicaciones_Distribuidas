package services;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService(Connection connection) {
        this.clienteDAO = new ClienteDAO(connection);
    }

    public void agregarCliente(Cliente cliente) throws SQLException {
        clienteDAO.agregarCliente(cliente);
    }

    public Cliente obtenerCliente(int id) throws SQLException {
        return clienteDAO.obtenerClientePorId(id);
    }

    public List<Cliente> obtenerTodosLosClientes() throws SQLException {
        return clienteDAO.obtenerTodosLosClientes();
    }

    public void actualizarCliente(Cliente cliente) throws SQLException {
        clienteDAO.actualizarCliente(cliente);
    }

    public void eliminarCliente(int id) throws SQLException {
        clienteDAO.eliminarCliente(id);
    }
}
