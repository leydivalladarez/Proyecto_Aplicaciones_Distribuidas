/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.Cliente;
import model.DetalleFactura;
import model.Factura;
import model.Articulo;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.math.BigDecimal;
import java.util.ArrayList;
import services.FacturaService;

public class FacturaUI2 {
    private FacturaService facturaService;
    private JFrame frame;
    private JTextField txtClienteId;
    private JTextField txtArticuloCodigo;
    private JTextField txtCantidad;

    public FacturaUI2(Connection connection) {
        facturaService = new FacturaService(connection);
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Facturación");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblClienteId = new JLabel("Cliente ID:");
        lblClienteId.setBounds(10, 10, 100, 25);
        frame.getContentPane().add(lblClienteId);

        txtClienteId = new JTextField();
        txtClienteId.setBounds(120, 10, 200, 25);
        frame.getContentPane().add(txtClienteId);

        JLabel lblArticuloCodigo = new JLabel("Artículo Código:");
        lblArticuloCodigo.setBounds(10, 50, 100, 25);
        frame.getContentPane().add(lblArticuloCodigo);

        txtArticuloCodigo = new JTextField();
        txtArticuloCodigo.setBounds(120, 50, 200, 25);
        frame.getContentPane().add(txtArticuloCodigo);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 90, 100, 25);
        frame.getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 90, 200, 25);
        frame.getContentPane().add(txtCantidad);

        JButton btnCrearFactura = new JButton("Crear Factura");
        btnCrearFactura.setBounds(120, 130, 150, 25);
        frame.getContentPane().add(btnCrearFactura);

        btnCrearFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int clienteId = Integer.parseInt(txtClienteId.getText());
                    int articuloCodigo = Integer.parseInt(txtArticuloCodigo.getText());
                    int cantidad = Integer.parseInt(txtCantidad.getText());

                    Cliente cliente = facturaService.obtenerClientePorId(clienteId);
                    Articulo articulo = facturaService.obtenerArticuloPorCodigo(articuloCodigo);
                    float precioUnitario = articulo.getPrecio();

                    DetalleFactura detalle = new DetalleFactura();
                    detalle.setArticulo(articulo);
                    detalle.setCantidad(cantidad);
                    detalle.setPrecioUnitario(precioUnitario);

                    Factura factura = new Factura();
                    factura.setNumero(1); // Aquí debería ir la lógica para generar el número de factura
                    factura.setFecha(new Date());
                    factura.setCliente(cliente);
                    factura.setDetalles(new ArrayList<>());
                    factura.getDetalles().add(detalle);

                    facturaService.crearFactura(factura);

                    JOptionPane.showMessageDialog(frame, "Factura creada con éxito!");
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
            new FacturaUI2(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

