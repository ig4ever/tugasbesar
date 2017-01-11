/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.unikom.adsi.perhotelan.tablemodel;

import id.ac.unikom.adsi.perhotelan.entitiy.Ruangan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class RuanganTM extends AbstractTableModel{
    ArrayList<Ruangan> arrayRuangan;

    public void setArrayPegawai(ArrayList<Ruangan> arrayRuangan) {
        this.arrayRuangan = arrayRuangan;
    }

    @Override
    public int getRowCount() {
        return arrayRuangan.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayRuangan.get(rowIndex).getIdRuangan();
            case 1:
                return arrayRuangan.get(rowIndex).getTipeRuangan();
            case 2:
                return arrayRuangan.get(rowIndex).getKapasitas();
            case 3:
                return arrayRuangan.get(rowIndex).getHarga();
            case 4:
                return arrayRuangan.get(rowIndex).getKeterangan();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID RUANGAN";
            case 1:
                return "TIPE RUANGAN";
            case 2:
                return "KAPASITAS";
            case 3:
                return "HARGA";
            case 4:
                return "KETERANGAN";
        }
        return null;
    }
}
