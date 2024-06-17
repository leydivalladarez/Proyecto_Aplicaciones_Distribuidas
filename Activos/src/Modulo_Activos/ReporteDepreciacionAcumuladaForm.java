/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo_activos;

/**
 *
 * @author Gabo
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ReporteDepreciacionAcumuladaForm extends JFrame {
    private JTable reporteTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;

    public ReporteDepreciacionAcumuladaForm(List<Activo> activos, List<DetalleDepreciacion> detallesDepreciacion) {
        setTitle("Reporte de Depreciación Acumulada");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Nombre del Activo", "Depreciación Acumulada"};
        tableModel = new DefaultTableModel(columnNames, 0);
        reporteTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reporteTable);

        refreshButton = new JButton("Actualizar");
        refreshButton.addActionListener(e -> actualizarReporte(activos, detallesDepreciacion));

        add(scrollPane, BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);

        actualizarReporte(activos, detallesDepreciacion);
    }

    private void actualizarReporte(List<Activo> activos, List<DetalleDepreciacion> detallesDepreciacion) {
        tableModel.setRowCount(0);
        for (Activo activo : activos) {
            double depreciacionAcumulada = 0;
            for (DetalleDepreciacion detalle : detallesDepreciacion) {
                if (detalle.getActivo().equals(activo)) {
                    depreciacionAcumulada += detalle.getValorDepreciacion();
                }
            }
            tableModel.addRow(new Object[]{activo.getNombre(), depreciacionAcumulada});
        }
    }

    public static void main(String[] args) {
        // Datos de ejemplo
        TipoActivo tipo1 = new TipoActivo(1, "Mueble");
        TipoActivo tipo2 = new TipoActivo(2, "Vehículo");

        Activo activo1 = new Activo(1, "Escritorio", 10, 1000.0, tipo1);
        Activo activo2 = new Activo(2, "Silla", 5, 200.0, tipo1);
        Activo activo3 = new Activo(3, "Coche", 15, 5000.0, tipo2);

        List<Activo> activos = Arrays.asList(activo1, activo2, activo3);

        DetalleDepreciacion detalle1 = new DetalleDepreciacion(activo1, 1, 100.0);
        DetalleDepreciacion detalle2 = new DetalleDepreciacion(activo1, 2, 100.0);
        DetalleDepreciacion detalle3 = new DetalleDepreciacion(activo2, 1, 20.0);
        DetalleDepreciacion detalle4 = new DetalleDepreciacion(activo3, 1, 500.0);

        List<DetalleDepreciacion> detallesDepreciacion = Arrays.asList(detalle1, detalle2, detalle3, detalle4);

        SwingUtilities.invokeLater(() -> {
            new ReporteDepreciacionAcumuladaForm(activos, detallesDepreciacion).setVisible(true);
        });
    }
}