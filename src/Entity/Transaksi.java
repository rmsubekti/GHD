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
public class Transaksi {
    private String id_transaksi, id_orang, tanggal;
    private int total_bayar;

    public Transaksi(String id_transaksi, String id_orang, String tanggal, int total_bayar) {
        this.id_transaksi = id_transaksi;
        this.id_orang = id_orang;
        this.tanggal = tanggal;
        this.total_bayar = total_bayar;
    }

    public Transaksi() {
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_orang() {
        return id_orang;
    }

    public void setId_orang(String id_orang) {
        this.id_orang = id_orang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }
    
}
