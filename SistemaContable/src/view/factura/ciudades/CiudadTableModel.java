package view.factura.ciudades;

import view.factura.ciudades.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Ciudad;

public class CiudadTableModel extends AbstractTableModel {
    private final List<Ciudad> ciudades;
    private final String[] columnNames = {"Código", "Nombre", "Acciones"};

    public CiudadTableModel(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public int getRowCount() {
        return ciudades.size();
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
        Ciudad ciudad = ciudades.get(rowIndex);
        switch (columnIndex) {
            case 0: return ciudad.getCodigo();
            case 1: return ciudad.getNombre();
            case 2: return "Acciones";
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2; // Solo la columna de "Acciones" es editable
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
}
