/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Produk;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public interface IProduk {
    boolean insertProduk(Produk produk);
    boolean updateProduk(Produk produk);
    boolean deleteProduk(String id);
    List selectProduk(String kode, String nama);
    String generateIDProduk();
}
