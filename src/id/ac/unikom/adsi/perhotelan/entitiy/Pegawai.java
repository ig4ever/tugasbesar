/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.entitiy;

/**
 *
 * @author faisal
 */
public class Pegawai {
    private Integer nip;
    private String namaPegawai;
    private String jabatan;
    private String noTelp;
    private String userName;
    private String password;

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

}
