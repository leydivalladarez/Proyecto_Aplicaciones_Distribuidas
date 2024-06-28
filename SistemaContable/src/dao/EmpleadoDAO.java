package dao;

import model.Empleado;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void agregarEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO empleado (cedula, nombre, fecha_ingreso, sueldo) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setDate(3, new java.sql.Date(empleado.getFechaIngreso().getTime()));
            ps.setDouble(4, empleado.getSueldo());
            ps.executeUpdate();
        }
    }

    public Empleado obtenerEmpleado(String cedula) throws SQLException {
        String sql = "SELECT * FROM empleado WHERE cedula = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCedula(rs.getString("cedula"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
                empleado.setSueldo(rs.getDouble("sueldo"));
                return empleado;
            }
        }
        return null;
    }

    public List<Empleado> obtenerTodosLosEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCedula(rs.getString("cedula"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
                empleado.setSueldo(rs.getDouble("sueldo"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        String sql = "UPDATE empleado SET nombre = ?, fecha_ingreso = ?, sueldo = ? WHERE cedula = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombre());
            ps.setDate(2, new java.sql.Date(empleado.getFechaIngreso().getTime()));
            ps.setDouble(3, empleado.getSueldo());
            ps.setString(4, empleado.getCedula());
            ps.executeUpdate();
        }
    }

    public void eliminarEmpleado(String cedula) throws SQLException {
        String sql = "DELETE FROM empleado WHERE cedula = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        }
    }
}
