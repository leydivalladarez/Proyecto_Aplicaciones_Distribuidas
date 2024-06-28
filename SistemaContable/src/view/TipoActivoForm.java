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
import model.TipoActivo;

public class TipoActivoForm extends JFrame {
    private JTextField codigoField;
    private JTextField nombreField;
    private JButton saveButton;
    private JButton cancelButton;

    public TipoActivoForm() {
        setTitle("Tipo de Activo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel codigoLabel = new JLabel("Código:");
        codigoField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        saveButton = new JButton("Guardar");
        cancelButton = new JButton("Cancelar");

        add(codigoLabel);
        add(codigoField);
        add(nombreLabel);
        add(nombreField);
        add(saveButton);
        add(cancelButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String nombre = nombreField.getText();
                TipoActivo tipoActivo = new TipoActivo(codigo, nombre);
                JOptionPane.showMessageDialog(null, "Tipo de Activo guardado");
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
                new TipoActivoForm().setVisible(true);
            }
        });
    }
}
