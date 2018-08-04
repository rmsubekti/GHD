/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.DBSetting;
import Entity.Kategori;
import Factory.Factory;
import Interfaces.IDBSetting;
import Interfaces.IKategori;
import Koneksi.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public class ImKategori implements IKategori {
    private String query;
    private DB koneksi;
    private ResultSet rsKategori, rsGenID;
    private List<Kategori> listKategori;
    private DBSetting setting;
    private final IDBSetting settingDAO;

    public ImKategori() {
        settingDAO = Factory.getSettingDAO();
        setting = settingDAO.getSetting();
        koneksi = new DB();
        koneksi.getKoneksi(setting);
    }
    
    @Override
    public boolean insertKategori(Kategori kategori) {
        query = "insert into kategori values('" +
                kategori.getId_kategori()+ "','" +
                kategori.getNama() + "','" +
                kategori.getKeterangan()+ "')";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean updateKategori(Kategori kategori) {
        query = "update kategori set nama='" + kategori.getNama()+
                "', keterangan='" + kategori.getKeterangan() +
                "' where id_kategori='" + 
                kategori.getId_kategori() + "';";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean deleteKategori(String id) {
        query= "delete from kategori where id_kategori='" +
                id + "'";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public List selectKategori(String id, String nama) {
        query="select * from kategori where id_kategori like '%" +
                id + "%' or nama like '%" + nama + "' order by id_kategori ASC";
        if (koneksi.eksekusiQuery(query, true)) {
            rsKategori = koneksi.getRs();
            listKategori = new ArrayList<>();
            try{
                while(rsKategori.next()){
                    Kategori kategori = new Kategori(
                            rsKategori.getString("id_kategori"),
                            rsKategori.getString("nama"),
                            rsKategori.getString("keterangan")
                    );
                    listKategori.add(kategori);
                }
                rsKategori.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Obat) :" + ex);
                return null;
            }
            return listKategori;
        }
        return null;
    }

    @Override
    public String generateIDKategori() {
        String id="";
        int angka = 0;
        query = "select max(right(id_kategori, 4)) as id from kategori";
        if (koneksi.eksekusiQuery(query, true)) {
            rsGenID = koneksi.getRs();
            try{
                rsGenID.next();
                angka = rsGenID.getInt("id") +1;
                if (angka <= 9 ) {
                    id = "K000" + (angka); 
                }
                else if (angka > 9 && angka < 100 ) {
                    id="K00"+ (angka);
                }
                else if (angka > 99 && angka < 1000 ) {
                    id="K0"+ (angka);
                }
                else{
                    id="K"+(angka);
                }
                
            } catch (SQLException ex) {
                System.out.println("Failed Generate id :" + ex);
                return null;
            }
        }
        return id;
    }
    
}
