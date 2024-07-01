package view.factura;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Cliente;

public class ClienteTableModel extends AbstractTableModel {
    private final List<Cliente> clientes;
    private final String[] columnNames = {"ID", "RUC", "Nombre", "Dirección", "Acciones"};

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getId();
            case 1: return cliente.getRuc();
            case 2: return cliente.getNombre();
            case 3: return cliente.getDireccion();
            case 4: return "Acciones";
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4; // Solo la columna de "Acciones" es editable
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
