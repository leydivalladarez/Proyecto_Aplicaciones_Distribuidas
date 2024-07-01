/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import model.Usuario;
import view.factura.ListaFacturasFrame;
import view.factura.ciudades.ListaCiudadesFrame;
import view.factura.clientes.ListaClientesFrame;
import view.usuario.Login;
import view.usuario.UsuarioShow;

/**
 *
 * @author gamert
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private Login login;
    private Usuario usuario;
    UsuarioShow usuarioShow = new UsuarioShow();
    private Connection connection;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(Connection connection) {
        this.connection = connection;
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

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuNomina = new javax.swing.JMenu();
        menuActivos = new javax.swing.JMenu();
        menuContabilidad = new javax.swing.JMenu();
        menuFacturacion = new javax.swing.JMenu();
        opListaClientes = new javax.swing.JMenuItem();
        opListaCiudades = new javax.swing.JMenuItem();
        opListaFacturas = new javax.swing.JMenuItem();
        menuPerfil = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1048, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menuNomina.setText("Nómina");
        jMenuBar1.add(menuNomina);

        menuActivos.setText("Activos");
        jMenuBar1.add(menuActivos);

        menuContabilidad.setText("Contabilidad");
        jMenuBar1.add(menuContabilidad);

        menuFacturacion.setText("Facturación");

        opListaClientes.setText("Clientes");
        opListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaClientesActionPerformed(evt);
            }
        });
        menuFacturacion.add(opListaClientes);

        opListaCiudades.setText("Ciudades");
        opListaCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaCiudadesActionPerformed(evt);
            }
        });
        menuFacturacion.add(opListaCiudades);

        opListaFacturas.setText("Facturas");
        opListaFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaFacturasActionPerformed(evt);
            }
        });
        menuFacturacion.add(opListaFacturas);

        jMenuBar1.add(menuFacturacion);

        menuPerfil.setText("Perfil");

        menuUsuario.setText("Usuario");
        menuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuUsuarioMousePressed(evt);
            }
        });
        menuPerfil.add(menuUsuario);

        menuLogout.setText("Cerrar Sesión");
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuLogoutMousePressed(evt);
            }
        });
        menuPerfil.add(menuLogout);

        jMenuBar1.add(menuPerfil);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void menuLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMousePressed
        login.setVisible(true);
        this.setUsuario(null);
        this.setVisible(false);
    }//GEN-LAST:event_menuLogoutMousePressed

    private void menuUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsuarioMousePressed
        usuarioShow.setUsuario(usuario);
        usuarioShow.setVisible(true);
    }//GEN-LAST:event_menuUsuarioMousePressed

    private void opListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaClientesActionPerformed
        ListaClientesFrame listaClientes = new ListaClientesFrame(this.connection);        
        escritorio.add(listaClientes);
        listaClientes.show();
    }//GEN-LAST:event_opListaClientesActionPerformed

    private void opListaCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaCiudadesActionPerformed
        ListaCiudadesFrame listaCiudades = new ListaCiudadesFrame(connection);
        escritorio.add(listaCiudades);
        listaCiudades.show();
    }//GEN-LAST:event_opListaCiudadesActionPerformed

    private void opListaFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaFacturasActionPerformed
        ListaFacturasFrame listaFacturas = new ListaFacturasFrame(escritorio, connection);
        escritorio.add(listaFacturas);
        listaFacturas.show();
    }//GEN-LAST:event_opListaFacturasActionPerformed

    public void setLogin(Login login){
        this.login = login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        try {
            this.usuario = usuario;
            menuUsuario.setText(usuario.getUsuario());
        } catch (Exception e) {
        }        
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuActivos;
    private javax.swing.JMenu menuContabilidad;
    private javax.swing.JMenu menuFacturacion;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuNomina;
    private javax.swing.JMenu menuPerfil;
    private javax.swing.JMenuItem menuUsuario;
    private javax.swing.JMenuItem opListaCiudades;
    private javax.swing.JMenuItem opListaClientes;
    private javax.swing.JMenuItem opListaFacturas;
    // End of variables declaration//GEN-END:variables
}
