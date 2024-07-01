package view.factura;

import view.factura.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Factura;
import services.FacturaService;

public class FacturaButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private final JPanel panel;
    private final JButton btnEdit;
    private final JButton btnDelete;
    private JTable table;
    private int row;
    private FacturaService facturaService;
    private ListaFacturasFrame listaFactura;
    private Connection connection;

    public FacturaButtonColumn(JTable table, Connection connection, ListaFacturasFrame listaFactura) {
        this.table = table;
        this.panel = new JPanel();
        this.btnEdit = new JButton("Editar");
        this.btnDelete = new JButton("Eliminar");
        this.facturaService = new FacturaService(connection);
        this.listaFactura = listaFactura;
        this.connection = connection;

        panel.setLayout(new FlowLayout());
        panel.add(btnEdit);
        panel.add(btnDelete);

        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEdit) {
            editarFactura(row);
        } else if (e.getSource() == btnDelete) {
            eliminarFactura(row);
        }
        fireEditingStopped();
    }

    private void editarFactura(int row) {
        // Implementa la lógica para editar el factura aquí
        Factura factura = ((FacturaTableModel) table.getModel()).getFacturas().get(row);
        
        AgregarFacturaFrame agregarFactura = new AgregarFacturaFrame(factura, connection, listaFactura);
        agregarFactura.setVisible(true);
        // Mostrar ventana de edición, por ejemplo
        //JOptionPane.showMessageDialog(table, "Editar factura: " + factura.getNombre());
    }

    private void eliminarFactura(int row) {
        // Implementa la lógica para eliminar el factura aquí
        Factura factura = ((FacturaTableModel) table.getModel()).getFacturas().get(row);
        // Confirmar eliminación y eliminar factura
        int confirm = JOptionPane.showConfirmDialog(table, "¿Está seguro de eliminar el factura: " + factura.getNumero()+ "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                facturaService.eliminarFactura(factura.getId());
                ((FacturaTableModel) table.getModel()).getFacturas().remove(row);
                ((FacturaTableModel) table.getModel()).fireTableRowsDeleted(row, row);
            } catch (SQLException ex) {
                Logger.getLogger(FacturaButtonColumn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

