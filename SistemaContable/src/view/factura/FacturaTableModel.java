package view.factura;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Factura;

public class FacturaTableModel extends AbstractTableModel {
    private final List<Factura> facturas;
    private final String[] columnNames = {"ID", "Nro", "Fecha", "Ciudad", "Cliente", "Acciones"};

    public FacturaTableModel(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public int getRowCount() {
        return facturas.size();
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
        Factura factura = facturas.get(rowIndex);
        switch (columnIndex) {
            case 0: return factura.getId();
            case 1: return factura.getNumero();
            case 2: return factura.getFecha();
            case 3: return factura.getCiudad();
            case 4: return factura.getCliente();
            case 5: return "Acciones";
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 5; // Solo la columna de "Acciones" es editable
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}
