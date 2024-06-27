/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.math.BigDecimal;
import java.util.ArrayList;
import model.ComprobanteContable;
import model.DetalleComprobante;
import services.ComprobanteContableService;

public class ComprobanteContableUI {
    private ComprobanteContableService comprobanteService;
    private JFrame frame;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JTextField txtTipo;
    private JTextField txtCuenta;
    private JTextField txtDebe;
    private JTextField txtHaber;

    public ComprobanteContableUI(Connection connection) {
        comprobanteService = new ComprobanteContableService(connection);
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Contabilidad");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(10, 10, 100, 25);
        frame.getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(120, 10, 200, 25);
        frame.getContentPane().add(txtNumero);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 50, 100, 25);
        frame.getContentPane().add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(120, 50, 200, 25);
        frame.getContentPane().add(txtFecha);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(10, 90, 100, 25);
        frame.getContentPane().add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(120, 90, 200, 25);
        frame.getContentPane().add(txtTipo);

        JLabel lblCuenta = new JLabel("Cuenta:");
        lblCuenta.setBounds(10, 130, 100, 25);
        frame.getContentPane().add(lblCuenta);

        txtCuenta = new JTextField();
        txtCuenta.setBounds(120, 130, 200, 25);
        frame.getContentPane().add(txtCuenta);

        JLabel lblDebe = new JLabel("Debe:");
        lblDebe.setBounds(10, 170, 100, 25);
        frame.getContentPane().add(lblDebe);

        txtDebe = new JTextField();
        txtDebe.setBounds(120, 170, 200, 25);
        frame.getContentPane().add(txtDebe);

        JLabel lblHaber = new JLabel("Haber:");
        lblHaber.setBounds(10, 210, 100, 25);
        frame.getContentPane().add(lblHaber);

        txtHaber = new JTextField();
        txtHaber.setBounds(120, 210, 200, 25);
        frame.getContentPane().add(txtHaber);

        JButton btnCrearComprobante = new JButton("Crear Comprobante");
        btnCrearComprobante.setBounds(120, 250, 200, 25);
        frame.getContentPane().add(btnCrearComprobante);

        btnCrearComprobante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    Date fecha = new Date(); // Aquí debería convertir txtFecha a Date
                    String tipo = txtTipo.getText();
                    String cuenta = txtCuenta.getText();
                    BigDecimal debe = new BigDecimal(txtDebe.getText());
                    BigDecimal haber = new BigDecimal(txtHaber.getText());

                    DetalleComprobante detalle = new DetalleComprobante(0, null, cuenta, debe, haber);

                    ComprobanteContable comprobante = new ComprobanteContable(numero, fecha, tipo, new ArrayList<>());
                    comprobante.getDetalles().add(detalle);

                    comprobanteService.crearComprobante(comprobante);

                    JOptionPane.showMessageDialog(frame, "Comprobante creado con éxito!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcial_1", "root", "");
            new ComprobanteContableUI(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
