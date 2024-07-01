package dao;

import model.Ciudad;
import model.DetalleFactura;
import model.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    private Connection connection;

    public FacturaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarFactura(Factura factura) throws SQLException {
        String queryFactura = "INSERT INTO factura (nro, fecha, cliente_id, ciudad_codigo) VALUES (?, ?, ?, ?)";
        String queryDetalle = "INSERT INTO detalle_factura (cabecera_factura_id, articulo_codigo, cantidad, precio) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmtFactura = connection.prepareStatement(queryFactura, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
             
            connection.setAutoCommit(false);
            
            stmtFactura.setInt(1, factura.getNumero());
            stmtFactura.setDate(2, new java.sql.Date(factura.getFecha().getTime()));
            stmtFactura.setInt(3, factura.getCliente().getId());
            stmtFactura.setInt(4, factura.getCiudad().getCodigo());
            stmtFactura.executeUpdate();

            ResultSet generatedKeys = stmtFactura.getGeneratedKeys();
            if (generatedKeys.next()) {
                factura.setNumero(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Error al insertar la factura, no se generó el ID.");
            }

            for (DetalleFactura detalle : factura.getDetalles()) {
                stmtDetalle.setInt(1, factura.getId());
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
    
    public Factura obtenerFacturaPorId(int id) throws SQLException {
        String queryFactura = "SELECT * FROM factura WHERE id = ?";
        String queryDetalle = "SELECT * FROM detalle_factura WHERE cabecera_factura_id = ?";
        Factura factura = null;

        try (PreparedStatement stmtFactura = connection.prepareStatement(queryFactura);
             PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
             
            stmtFactura.setInt(1, id);
            ResultSet rsFactura = stmtFactura.executeQuery();

            if (rsFactura.next()) {
                factura = new Factura();
                factura.setNumero(rsFactura.getInt("nro"));
                factura.setFecha(rsFactura.getDate("fecha"));
                factura.setCliente(new ClienteDAO(connection).obtenerClientePorId(rsFactura.getInt("cliente_id")));
                factura.setCiudad(new CiudadDAO(connection).obtenerCiudad(rsFactura.getInt("ciudad_codigo")));

                List<DetalleFactura> detalles = new ArrayList<>();
                stmtDetalle.setInt(1, id);
                ResultSet rsDetalle = stmtDetalle.executeQuery();
                while (rsDetalle.next()) {
                    DetalleFactura detalle = new DetalleFactura();
                    detalle.setId(rsDetalle.getInt("id"));
                    detalle.setFactura(factura);
                    detalle.setArticulo(new ArticuloDAO(connection).obtenerArticuloPorCodigo(rsDetalle.getInt("articulo_codigo")));
                    detalle.setCantidad(rsDetalle.getInt("cantidad"));
                    detalle.setPrecioUnitario(rsDetalle.getFloat("precio"));
                    detalles.add(detalle);
                }
                factura.setDetalles(detalles);
            }
        }
        return factura;
    }

    public Factura obtenerFacturaPorNumero(int numero) throws SQLException {
        String queryFactura = "SELECT * FROM factura WHERE nro = ?";
        String queryDetalle = "SELECT * FROM detalle_factura WHERE cabecera_factura_id = ?";
        Factura factura = null;

        try (PreparedStatement stmtFactura = connection.prepareStatement(queryFactura);
             PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
             
            stmtFactura.setInt(1, numero);
            ResultSet rsFactura = stmtFactura.executeQuery();

            if (rsFactura.next()) {
                factura = new Factura();
                factura.setNumero(rsFactura.getInt("nro"));
                factura.setFecha(rsFactura.getDate("fecha"));
                factura.setCliente(new ClienteDAO(connection).obtenerClientePorId(rsFactura.getInt("cliente_id")));
                factura.setCiudad(new CiudadDAO(connection).obtenerCiudad(rsFactura.getInt("ciudad_codigo")));

                List<DetalleFactura> detalles = new ArrayList<>();
                stmtDetalle.setInt(1, numero);
                ResultSet rsDetalle = stmtDetalle.executeQuery();
                while (rsDetalle.next()) {
                    DetalleFactura detalle = new DetalleFactura();
                    detalle.setId(rsDetalle.getInt("id"));
                    detalle.setFactura(factura);
                    detalle.setArticulo(new ArticuloDAO(connection).obtenerArticuloPorCodigo(rsDetalle.getInt("articulo_codigo")));
                    detalle.setCantidad(rsDetalle.getInt("cantidad"));
                    detalle.setPrecioUnitario(rsDetalle.getFloat("precio"));
                    detalles.add(detalle);
                }
                factura.setDetalles(detalles);
            }
        }
        return factura;
    }

    public List<Factura> obtenerTodasLasFacturas() throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String queryFactura = "SELECT * FROM factura";
        try (PreparedStatement stmtFactura = connection.prepareStatement(queryFactura)) {
            ResultSet rsFactura = stmtFactura.executeQuery();
            while (rsFactura.next()) {
                Factura factura = new Factura();
                factura.setNumero(rsFactura.getInt("nro"));
                factura.setFecha(rsFactura.getDate("fecha"));
                factura.setCliente(new ClienteDAO(connection).obtenerClientePorId(rsFactura.getInt("cliente_id")));
                factura.setCiudad(new CiudadDAO(connection).obtenerCiudad(rsFactura.getInt("ciudad_codigo")));

                List<DetalleFactura> detalles = new ArrayList<>();
                String queryDetalle = "SELECT * FROM detalle_factura WHERE cabecera_factura_id = ?";
                try (PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
                    stmtDetalle.setInt(1, factura.getNumero());
                    ResultSet rsDetalle = stmtDetalle.executeQuery();
                    while (rsDetalle.next()) {
                        DetalleFactura detalle = new DetalleFactura();
                        detalle.setId(rsDetalle.getInt("id"));
                        detalle.setFactura(factura);
                        detalle.setArticulo(new ArticuloDAO(connection).obtenerArticuloPorCodigo(rsDetalle.getInt("articulo_codigo")));
                        detalle.setCantidad(rsDetalle.getInt("cantidad"));
                        detalle.setPrecioUnitario(rsDetalle.getFloat("precio"));
                        detalles.add(detalle);
                    }
                }
                factura.setDetalles(detalles);
                facturas.add(factura);
            }
        }
        return facturas;
    }

    public void actualizarFactura(Factura factura) throws SQLException {
        String queryFactura = "UPDATE factura SET fecha = ?, cliente_id = ?, ciudad_codigo = ? WHERE nro = ?";
        String queryDetalle = "UPDATE detalle_factura SET articulo_codigo = ?, cantidad = ?, precio = ? WHERE id = ?";

        try (PreparedStatement stmtFactura = connection.prepareStatement(queryFactura)) {
            connection.setAutoCommit(false);

            stmtFactura.setDate(1, new java.sql.Date(factura.getFecha().getTime()));
            stmtFactura.setInt(2, factura.getCliente().getId());
            stmtFactura.setInt(3, factura.getCiudad().getCodigo());
            stmtFactura.setInt(4, factura.getNumero());
            stmtFactura.executeUpdate();

            for (DetalleFactura detalle : factura.getDetalles()) {
                try (PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle)) {
                    stmtDetalle.setInt(1, detalle.getArticulo().getCodigo());
                    stmtDetalle.setInt(2, detalle.getCantidad());
                    stmtDetalle.setFloat(3, detalle.getPrecioUnitario());
                    stmtDetalle.setInt(4, detalle.getId());
                    stmtDetalle.executeUpdate();
                }
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public void eliminarFactura(int numero) throws SQLException {
        String queryDetalle = "DELETE FROM detalle_factura WHERE cabecera_factura_id = ?";
        String queryFactura = "DELETE FROM factura WHERE nro = ?";

        try (PreparedStatement stmtDetalle = connection.prepareStatement(queryDetalle);
             PreparedStatement stmtFactura = connection.prepareStatement(queryFactura)) {
             
            connection.setAutoCommit(false);

            stmtDetalle.setInt(1, numero);
            stmtDetalle.executeUpdate();

            stmtFactura.setInt(1, numero);
            stmtFactura.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
