package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TrabajadorTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Nombre", "Apellido", "Rut", "Isapre", "AFP"};
    private final ArrayList<Trabajador> trabajadores = new ArrayList<>();

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores.clear();
        this.trabajadores.addAll(trabajadores);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return trabajadores.size();
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
        Trabajador trabajador = trabajadores.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> trabajador.getId();
            case 1 -> trabajador.getNombre();
            case 2 -> trabajador.getApellido();
            case 3 -> trabajador.getRut();
            case 4 -> trabajador.getIsapre();
            case 5 -> trabajador.getAfp();
            default -> null;
        };
    }
}
