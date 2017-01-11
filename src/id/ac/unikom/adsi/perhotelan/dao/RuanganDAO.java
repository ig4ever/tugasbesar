/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.unikom.adsi.perhotelan.dao;

import id.ac.unikom.adsi.perhotelan.entitiy.Pegawai;
import id.ac.unikom.adsi.perhotelan.entitiy.Ruangan;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface RuanganDAO {
    ArrayList<Ruangan> getRuangan();
    
    ArrayList<Ruangan> getRuangan(String tipeRuangan);
}
