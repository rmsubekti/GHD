/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.DBSetting;
import Entity.Produk;
import Factory.Factory;
import Interfaces.IDBSetting;
import Interfaces.IProduk;
import Koneksi.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public class ImProduk implements IProduk {
    private String query;
    private DB koneksi;
    private ResultSet rsProduk, rsGenID;
    private List<Produk> listProduk;
    private DBSetting setting;
    private final IDBSetting settingDAO;

    public ImProduk() {
        settingDAO = Factory.getSettingDAO();
        setting = settingDAO.getSetting();
        koneksi = new DB();
        koneksi.getKoneksi(setting);
    }
    
    
    @Override
    public boolean insertProduk(Produk produk) {
        query = "insert into produk values('" +
                produk.getId_produk()+ "','" +
                produk.getNama() + "','" +
                produk.getId_kategori() + "','" +
                produk.getKeterangan() + "','" +
                produk.getHarga() + "','" +
                produk.getStok()+ "')";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean updateProduk(Produk produk) {
        query = "update produk set nama='" + produk.getNama()+
                "', id_kategori='" + produk.getId_kategori() +
                "', keterangan='" + produk.getKeterangan() +
                "', harga='" + produk.getHarga() +
                "', stok='" + produk.getStok() +
                "' where id_produk='" + 
                produk.getId_produk() + "';";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean deleteProduk(String id) {
        query= "delete from produk where id_produk='" +
                id + "'";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public List selectProduk(String kode, String nama) {
        query="select * from produk where id_produk like '%" +
                kode + "%' or nama like '%" + nama + "' order by id_produk ASC";
        if (koneksi.eksekusiQuery(query, true)) {
            rsProduk = koneksi.getRs();
            listProduk = new ArrayList<>();
            try{
                while(rsProduk.next()){
                    Produk produk = new Produk(
                            rsProduk.getString("id_produk"),
                            rsProduk.getString("nama"),
                            rsProduk.getString("id_kategori"),
                            rsProduk.getString("keterangan"),
                            rsProduk.getInt("harga"),
                            rsProduk.getInt("stok")
                    );
                    listProduk.add(produk);
                }
                rsProduk.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Obat) :" + ex);
                return null;
            }
            return listProduk;
        }
        return null;
    }

    @Override
    public String generateIDProduk() {
        String id="";
        int angka = 0;
        query = "select max(right(id_produk, 5)) as id from produk";
        if (koneksi.eksekusiQuery(query, true)) {
            rsGenID = koneksi.getRs();
            try{
                rsGenID.next();
                angka = rsGenID.getInt("id") +1;
                if (angka <= 9 ) {
                    id = "P0000" + (angka); 
                }
                else if (angka > 9 && angka < 100 ) {
                    id="P000"+ (angka);
                }
                else if (angka > 99 && angka < 1000 ) {
                    id="P00"+ (angka);
                }
                else if (angka > 999 && angka < 10000 ) {
                    id="P0"+ (angka);
                }
                else{
                    id="P"+(angka);
                }
                
            } catch (SQLException ex) {
                System.out.println("Failed Generate id :" + ex);
                return null;
            }
        }
        return id;
    }
    
}
