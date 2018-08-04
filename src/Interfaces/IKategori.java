/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Kategori;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public interface IKategori {
    boolean insertKategori(Kategori kategori);
    boolean updateKategori(Kategori kategori);
    boolean deleteKategori(String id);
    List selectKategori(String id, String nama);
    String generateIDKategori();
}
