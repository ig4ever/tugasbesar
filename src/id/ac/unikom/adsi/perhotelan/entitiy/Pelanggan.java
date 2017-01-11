/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.entitiy;

/**
 *
 * @author Robi Tanzil
 */
public class Pelanggan {

    private int idPelanggan;
    private String namaPelanggan;
    private String alamat;
    private Integer noTelp;

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getnamaPelanggan() {
        return namaPelanggan;
    }

    public void setnamaPelanggan(String company) {
        this.namaPelanggan = company;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(Integer noTelp) {
        this.noTelp = noTelp;
    }

    
}
