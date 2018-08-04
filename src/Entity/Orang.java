/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Rahmat Subekti
 */
public class Orang {
    private String id_orang, nama, alamat, email,no_telpon;

    public Orang(String id_orang, String nama, String alamat, String email, String no_telpon) {
        this.id_orang = id_orang;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.no_telpon = no_telpon;
    }

    public Orang() {
    }

    public String getId_orang() {
        return id_orang;
    }

    public void setId_orang(String id_orang) {
        this.id_orang = id_orang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }
    
}
