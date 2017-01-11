
package id.ac.unikom.adsi.perhotelan.dao;

import id.ac.unikom.adsi.perhotelan.entitiy.Pelanggan;
import java.util.ArrayList;

public interface PelangganDAO {
    
    ArrayList<Pelanggan> getPelanggan();
    ArrayList<Pelanggan> getPelanggan(String nama);
    
}
