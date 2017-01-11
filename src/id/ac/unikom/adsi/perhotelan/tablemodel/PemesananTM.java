/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.tablemodel;


import id.ac.unikom.adsi.perhotelan.entitiy.Pemesanan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
public class PemesananTM extends AbstractTableModel {

    private ArrayList<Pemesanan> arrayPeminjaman;

    public void setArrayPeminjaman(ArrayList<Pemesanan> arrayPeminjaman) {
        this.arrayPeminjaman = arrayPeminjaman;
    }

    @Override
    public int getRowCount() {
        return arrayPeminjaman.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        switch (columnIndex) {
            case 0:
                return arrayPeminjaman.get(rowIndex).getKdPemesanan();
            case 1:
                return arrayPeminjaman.get(rowIndex).getNip();
            case 2:
                return arrayPeminjaman.get(rowIndex).getNamaPegawai();
            case 3:
                return arrayPeminjaman.get(rowIndex).getCompany();
            case 4:
                return arrayPeminjaman.get(rowIndex).getTipeRuangan();
            case 5:
                return arrayPeminjaman.get(rowIndex).getKapasitas();
            case 6:
                String tglPinjam = formatter.format(arrayPeminjaman.get(rowIndex).getBeginning_time());
                return tglPinjam;
            case 7:
                Date dateKembali = arrayPeminjaman.get(rowIndex).getEnding_time();
                String tglKembali = null;
                if (dateKembali != null) {
                    tglKembali = formatter.format(arrayPeminjaman.get(rowIndex).getEnding_time());
                }
                return tglKembali;
           
            case 8:
                return "Rp. " + String.valueOf(arrayPeminjaman.get(rowIndex).getHarga());
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Pesanan";
            case 1:
                return "NIP";
            case 2:
                return "Nama Pegawai";
            case 3:
                return "Company";
            case 4:
                return "Tipe Kamar";
            case 5:
                return "Kapasitas";
            case 6:
                return "Beginning Time";
            case 7:
                return "Ending Time";
            case 8:
                return "Total Harga";
        }
        return null;
    }
}
