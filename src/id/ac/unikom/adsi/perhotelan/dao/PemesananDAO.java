
package id.ac.unikom.adsi.perhotelan.dao;


import id.ac.unikom.adsi.perhotelan.entitiy.Pemesanan;
import java.util.ArrayList;
import java.util.Calendar;


public interface PemesananDAO {
  
    ArrayList<Pemesanan> getPemesanan();
    ArrayList<Pemesanan> getPemesanan(String company);
    boolean pesanan(String nama, String alamat , int noTelp, Calendar beginningTime, Calendar endingTime);
    
    boolean end(int idPinjam, Calendar endingTime);
    int getIdPemesanan();
}
