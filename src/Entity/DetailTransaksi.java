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
public class DetailTransaksi {
    private String id_detail, id_transaksi, id_barang;
    private int jumlah, total_harga;

    public DetailTransaksi(String id_detail, String id_transaksi, String id_barang, int jumlah, int total_harga) {
        this.id_detail = id_detail;
        this.id_transaksi = id_transaksi;
        this.id_barang = id_barang;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
    }

    public DetailTransaksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId_detail() {
        return id_detail;
    }

    public void setId_detail(String id_detail) {
        this.id_detail = id_detail;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }
    
}
