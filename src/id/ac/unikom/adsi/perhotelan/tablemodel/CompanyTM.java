package id.ac.unikom.adsi.perhotelan.tablemodel;

import id.ac.unikom.adsi.perhotelan.entitiy.Pelanggan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CompanyTM extends AbstractTableModel {

    private ArrayList<Pelanggan> arrayCompany;

    public void setArrayCompany(ArrayList<Pelanggan> arrayPesanan) {
        this.arrayCompany = arrayPesanan;
    }

    @Override
    public int getRowCount() {
        return arrayCompany.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayCompany.get(rowIndex).getIdPelanggan();
            case 1:
                return arrayCompany.get(rowIndex).getnamaPelanggan();
            case 2:
                return arrayCompany.get(rowIndex).getAlamat();
            case 3:
                return arrayCompany.get(rowIndex).getNoTelp();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Pelanggan";
            case 1:
                return "Company";
            case 2:
                return "Alamat";
            case 3:
                return "No Telp";
        }
        return null;
    }
}
