package id.ac.unikom.adsi.perhotelan.dao;

import id.ac.unikom.adsi.perhotelan.entitiy.PemesananDetail;
import java.util.ArrayList;

public interface PemesananDetailDao {

    ArrayList<PemesananDetail> getDetail(int kdPesanan);

    boolean insertDetail(int kdPesanan, int idRuangan);

}
