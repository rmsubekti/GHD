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
public class Produk {
    private String id_produk, nama, id_kategori, keterangan;
    private int harga,stok;

    public Produk(String id_produk, String nama, String id_kategori, String keterangan, int harga, int stok) {
        this.id_produk = id_produk;
        this.nama = nama;
        this.id_kategori = id_kategori;
        this.keterangan = keterangan;
        this.harga = harga;
        this.stok = stok;
    }

    public Produk() {
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }


    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
}
