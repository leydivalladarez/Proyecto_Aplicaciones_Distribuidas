package view.factura.ciudades;

import view.factura.ciudades.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ciudad;
import services.CiudadService;

public class CiudadButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private final JPanel panel;
    private final JButton btnEdit;
    private final JButton btnDelete;
    private JTable table;
    private int row;
    private CiudadService ciudadService;
    private ListaCiudadesFrame listaCiudad;

    public CiudadButtonColumn(JTable table, CiudadService ciudadService, ListaCiudadesFrame listaCiudad) {
        this.table = table;
        this.panel = new JPanel();
        this.btnEdit = new JButton("Editar");
        this.btnDelete = new JButton("Eliminar");
        this.ciudadService = ciudadService;
        this.listaCiudad = listaCiudad;

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
            editarCiudad(row);
        } else if (e.getSource() == btnDelete) {
            eliminarCiudad(row);
        }
        fireEditingStopped();
    }

    private void editarCiudad(int row) {
        // Implementa la lógica para editar el ciudad aquí
        Ciudad ciudad = ((CiudadTableModel) table.getModel()).getCiudades().get(row);
        
        AgregarCiudadFrame agregarCiudad = new AgregarCiudadFrame(ciudad, ciudadService, listaCiudad);
        agregarCiudad.setVisible(true);
        // Mostrar ventana de edición, por ejemplo
        //JOptionPane.showMessageDialog(table, "Editar ciudad: " + ciudad.getNombre());
    }

    private void eliminarCiudad(int row) {
        // Implementa la lógica para eliminar el ciudad aquí
        Ciudad ciudad = ((CiudadTableModel) table.getModel()).getCiudades().get(row);
        // Confirmar eliminación y eliminar ciudad
        int confirm = JOptionPane.showConfirmDialog(table, "¿Está seguro de eliminar el ciudad: " + ciudad.getNombre() + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                ciudadService.eliminarCiudad(ciudad.getCodigo());
                ((CiudadTableModel) table.getModel()).getCiudades().remove(row);
                ((CiudadTableModel) table.getModel()).fireTableRowsDeleted(row, row);
            } catch (SQLException ex) {
                Logger.getLogger(CiudadButtonColumn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

