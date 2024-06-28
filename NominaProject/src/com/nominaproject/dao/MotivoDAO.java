package com.nominaproject.dao;

import com.nominaproject.model.Motivo;
import com.nominaproject.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotivoDAO {

    public void agregarMotivo(Motivo motivo) throws SQLException {
        String sql = "INSERT INTO motivo (codigo, nombre) VALUES (?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, motivo.getCodigo());
            ps.setString(2, motivo.getNombre());
            ps.executeUpdate();
        }
    }

    public Motivo obtenerMotivo(int codigo) throws SQLException {
        String sql = "SELECT * FROM motivo WHERE codigo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Motivo motivo = new Motivo();
                motivo.setCodigo(rs.getInt("codigo"));
                motivo.setNombre(rs.getString("nombre"));
                return motivo;
            }
        }
        return null;
    }

    public List<Motivo> obtenerTodosLosMotivos() throws SQLException {
        List<Motivo> motivos = new ArrayList<>();
        String sql = "SELECT * FROM motivo";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Motivo motivo = new Motivo();
                motivo.setCodigo(rs.getInt("codigo"));
                motivo.setNombre(rs.getString("nombre"));
                motivos.add(motivo);
            }
        }
        return motivos;
    }

    public void actualizarMotivo(Motivo motivo) throws SQLException {
        String sql = "UPDATE motivo SET nombre = ? WHERE codigo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, motivo.getNombre());
            ps.setInt(2, motivo.getCodigo());
            ps.executeUpdate();
        }
    }

    public void eliminarMotivo(int codigo) throws SQLException {
        String sql = "DELETE FROM motivo WHERE codigo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }
}
