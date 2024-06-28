/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Cliente;
import model.DetalleFactura;
import model.Factura;
import model.Articulo;
import services.FacturaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;

public class FacturaUI extends javax.swing.JPanel {

    private FacturaService facturaService;

    /**
     * Creates new form NewJPanel
     */
    public FacturaUI(Connection connection) {
        facturaService = new FacturaService(connection);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClienteId = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JTextField();
        lblArticuloCodigo = new javax.swing.JLabel();
        txtArticuloCodigo = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnCrearFactura = new javax.swing.JButton();

        lblClienteId.setText("Cliente ID:");

        lblArticuloCodigo.setText("Artículo Código:");

        lblCantidad.setText("Cantidad:");

        btnCrearFactura.setText("Crear Factura");
        btnCrearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClienteId)
                    .addComponent(lblArticuloCodigo)
                    .addComponent(lblCantidad))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearFactura)
                    .addComponent(txtClienteId, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(txtArticuloCodigo)
                    .addComponent(txtCantidad))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClienteId))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArticuloCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArticuloCodigo))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addGap(29, 29, 29)
                .addComponent(btnCrearFactura)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify                     
    // End of variables declaration                   
    private void btnCrearFacturaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCrearFacturaActionPerformed
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

            JOptionPane.showMessageDialog(this, "Factura creada con éxito!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCrearFacturaActionPerformed

    public static void main(String args[]) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcial_1", "root", "");
            JFrame frame = new JFrame("Sistema de Facturación");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            frame.setContentPane(new FacturaUI(connection));
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearFactura;
    private javax.swing.JLabel lblArticuloCodigo;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JTextField txtArticuloCodigo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClienteId;
    // End of variables declaration//GEN-END:variables
}
