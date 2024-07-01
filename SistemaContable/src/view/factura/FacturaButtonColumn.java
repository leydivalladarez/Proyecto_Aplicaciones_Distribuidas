package view.factura.clientes;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import services.ClienteService;

public class ClienteButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private final JPanel panel;
    private final JButton btnEdit;
    private final JButton btnDelete;
    private JTable table;
    private int row;
    private ClienteService clienteService;
    private ListaClientesFrame listaCliente;

    public ClienteButtonColumn(JTable table, ClienteService clienteService, ListaClientesFrame listaCliente) {
        this.table = table;
        this.panel = new JPanel();
        this.btnEdit = new JButton("Editar");
        this.btnDelete = new JButton("Eliminar");
        this.clienteService = clienteService;
        this.listaCliente = listaCliente;

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
            editarCliente(row);
        } else if (e.getSource() == btnDelete) {
            eliminarCliente(row);
        }
        fireEditingStopped();
    }

    private void editarCliente(int row) {
        // Implementa la lógica para editar el cliente aquí
        Cliente cliente = ((ClienteTableModel) table.getModel()).getClientes().get(row);
        
        AgregarClienteFrame agregarCliente = new AgregarClienteFrame(cliente, clienteService, listaCliente);
        agregarCliente.setVisible(true);
        // Mostrar ventana de edición, por ejemplo
        //JOptionPane.showMessageDialog(table, "Editar cliente: " + cliente.getNombre());
    }

    private void eliminarCliente(int row) {
        // Implementa la lógica para eliminar el cliente aquí
        Cliente cliente = ((ClienteTableModel) table.getModel()).getClientes().get(row);
        // Confirmar eliminación y eliminar cliente
        int confirm = JOptionPane.showConfirmDialog(table, "¿Está seguro de eliminar el cliente: " + cliente.getNombre() + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                clienteService.eliminarCliente(cliente.getId());
                ((ClienteTableModel) table.getModel()).getClientes().remove(row);
                ((ClienteTableModel) table.getModel()).fireTableRowsDeleted(row, row);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteButtonColumn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

