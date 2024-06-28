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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivoForm extends JFrame {
    private JTextField idField;
    private JTextField nombreField;
    private JTextField totalPeriodosField;
    private JTextField valorCompraField;
    private JComboBox<TipoActivo> tipoActivoComboBox;
    private JButton saveButton;
    private JButton cancelButton;

    public ActivoForm() {
        setTitle("Activo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel totalPeriodosLabel = new JLabel("Total de Periodos de Depreciación:");
        totalPeriodosField = new JTextField();
        JLabel valorCompraLabel = new JLabel("Valor de Compra:");
        valorCompraField = new JTextField();
        JLabel tipoActivoLabel = new JLabel("Tipo de Activo:");
        String opciones[] = {"Mueble", "Vehiculo"};
        tipoActivoComboBox = new JComboBox(opciones);

        saveButton = new JButton("Guardar");
        cancelButton = new JButton("Cancelar");

        add(idLabel);
        add(idField);
        add(nombreLabel);
        add(nombreField);
        add(totalPeriodosLabel);
        add(totalPeriodosField);
        add(valorCompraLabel);
        add(valorCompraField);
        add(tipoActivoLabel);
        add(tipoActivoComboBox);
        add(saveButton);
        add(cancelButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                int totalPeriodos = Integer.parseInt(totalPeriodosField.getText());
                double valorCompra = Double.parseDouble(valorCompraField.getText());
                TipoActivo tipoActivo = (TipoActivo) tipoActivoComboBox.getSelectedItem();
                Activo activo = new Activo(id, nombre, totalPeriodos, valorCompra, tipoActivo);
                JOptionPane.showMessageDialog(null, "Activo guardado");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActivoForm().setVisible(true);
            }
        });
    }
}
