/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.tablemodel;

import id.ac.unikom.adsi.perhotelan.entitiy.Pegawai;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ig4ever
 */
public class PegawaiTM extends AbstractTableModel {

    ArrayList<Pegawai> arrayPegawai;

    public void setArrayPegawai(ArrayList<Pegawai> arrayPegawai) {
        this.arrayPegawai = arrayPegawai;
    }

    @Override
    public int getRowCount() {
        return arrayPegawai.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPegawai.get(rowIndex).getNip();
            case 1:
                return arrayPegawai.get(rowIndex).getNamaPegawai();
            case 2:
                return arrayPegawai.get(rowIndex).getJabatan();
            case 3:
                return arrayPegawai.get(rowIndex).getNoTelp();
            case 4:
                return arrayPegawai.get(rowIndex).getUserName();
            case 5:
                return arrayPegawai.get(rowIndex).getPassword();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIP";
            case 1:
                return "NAMA";
            case 2:
                return "JABATAN";
            case 3:
                return "NO TELP";
            case 4:
                return "USERNAME";
            case 5:
                return "PASSWORD";
        }
        return null;
    }
}
