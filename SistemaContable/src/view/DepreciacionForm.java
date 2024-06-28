/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Gabo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.CabeceraDepreciacion;
import model.DetalleDepreciacion;

public class DepreciacionForm extends JFrame {
    private JTextField numeroField;
    private JTextField fechaField;
    private JTextField observacionesField;
    private JTextField responsableField;
    private JTable detallesTable;
    private JButton addButton;
    private JButton saveButton;
    private JButton cancelButton;
    private List<DetalleDepreciacion> detalles;

    public DepreciacionForm() {
        setTitle("Cabecera de Depreciación");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        detalles = new ArrayList<>();

        JPanel cabeceraPanel = new JPanel(new GridLayout(5, 2));
        JLabel numeroLabel = new JLabel("Número de Depreciación:");
        numeroField = new JTextField();
        JLabel fechaLabel = new JLabel("Fecha de Depreciación:");
        fechaField = new JTextField();
        JLabel observacionesLabel = new JLabel("Observaciones:");
        observacionesField = new JTextField();
        JLabel responsableLabel = new JLabel("Responsable:");
        responsableField = new JTextField();

        cabeceraPanel.add(numeroLabel);
        cabeceraPanel.add(numeroField);
        cabeceraPanel.add(fechaLabel);
        cabeceraPanel.add(fechaField);
        cabeceraPanel.add(observacionesLabel);
        cabeceraPanel.add(observacionesField);
        cabeceraPanel.add(responsableLabel);
        cabeceraPanel.add(responsableField);

        String[] columnNames = {"Activo", "Periodo", "Valor"};
        Object[][] data = {};
        detallesTable = new JTable(data, columnNames);

        addButton = new JButton("Agregar Detalle");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(numeroField.getText());
                Date fecha = new Date(fechaField.getText());
                String observaciones = observacionesField.getText();
                String responsable = responsableField.getText();
                CabeceraDepreciacion cabecera = new CabeceraDepreciacion(numero, fecha, observaciones, responsable, detalles);
                JOptionPane.showMessageDialog(null, "Depreciación guardada");
            }
        });

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(addButton);
        botonesPanel.add(saveButton);
        botonesPanel.add(cancelButton);

        add(cabeceraPanel, BorderLayout.NORTH);
        add(new JScrollPane(detallesTable), BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DepreciacionForm().setVisible(true);
            }
        });
    }
}
