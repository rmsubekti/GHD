/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Transaksi;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public interface ITransaksi {
    boolean insertTransaksi(Transaksi transaksi);
    List selectTransaksi(String kode, String tanggal);
    String generateIDTransaksi();
}
