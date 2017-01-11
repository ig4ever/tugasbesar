/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.entitiy;

import java.util.Date;

/**
 *
 * @author Robi Tanzil
 */
public class Pemesanan {

    private int kdPemesanan;
    private int nip;
    private String company;
    private String alamat;
    private String namaPegawai;
    private Date beginning_time;
    private Date ending_time;
    private String tipeRuangan;
    private float harga;
    private int noTelp;
    private int kapasitas;

    public int getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(int noTelp) {
        this.noTelp = noTelp;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }
    
    public int getKdPemesanan() {
        return kdPemesanan;
    }

    public void setKdPemesanan(int kdPemesanan) {
        this.kdPemesanan = kdPemesanan;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBeginning_time() {
        return beginning_time;
    }

    public void setBeginning_time(Date beginning_time) {
        this.beginning_time = beginning_time;
    }

    public Date getEnding_time() {
        return ending_time;
    }

    public void setEnding_time(Date ending_time) {
        this.ending_time = ending_time;
    }

    public String getTipeRuangan() {
        return tipeRuangan;
    }

    public void setTipeRuangan(String tipeRuangan) {
        this.tipeRuangan = tipeRuangan;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }
}
