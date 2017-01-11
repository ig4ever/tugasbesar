/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.unikom.adsi.perhotelan.tablemodel;

import id.ac.unikom.adsi.perhotelan.entitiy.PemesananDetail;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rizal Y
 */
public class PemesananDetailTM extends AbstractTableModel{

    private ArrayList<PemesananDetail> arrayDetail;

    public void setArrayDetail(ArrayList<PemesananDetail> arrayDetail) {
        this.arrayDetail = arrayDetail;
    }
    
    @Override
    public int getRowCount() {
        return arrayDetail.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayDetail.get(rowIndex).getKdBuku();
            case 1:
                return arrayDetail.get(rowIndex).getJudul();
            case 2:
                return arrayDetail.get(rowIndex).getPengarang();
            case 3:
                return arrayDetail.get(rowIndex).getPenerbit();
            case 4:
                return arrayDetail.get(rowIndex).getTahun();
        }
        return null;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Buku";
            case 1:
                return "Judul";
            case 2:
                return "Pengarang";
            
            case 3:
                return "Penerbit";
            case 4:
                return "Tahun";
        }
        return null;
    }

}
