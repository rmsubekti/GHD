/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.DBSetting;
import Entity.Orang;
import Factory.Factory;
import Interfaces.IDBSetting;
import Interfaces.IOrang;
import Koneksi.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public class ImOrang implements IOrang {
    private String query;
    private DB koneksi;
    private ResultSet rsOrang;
    private ResultSet rsGenID;
    private List<Orang> listOrang;
    private DBSetting setting;
    private final IDBSetting settingDAO;

    public ImOrang() {
        settingDAO = Factory.getSettingDAO();
        setting = settingDAO.getSetting();
        koneksi = new DB();
        koneksi.getKoneksi(setting);
    }
    

    @Override
    public boolean insertOrang(Orang orang) {
        query = "insert into orang values('" +
                orang.getId_orang()+ "','" +
                orang.getNama() + "','" +
                orang.getNo_telpon() + "','" +
                orang.getAlamat() + "','" +
                orang.getEmail()+ "')";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean updateOrang(Orang orang) {
        query = "update orang set nama='" + orang.getNama()+
                "', telpon='" + orang.getNo_telpon() +
                "', alamat='" + orang.getAlamat() +
                "', email='" + orang.getEmail() +
                "' where id_orang='" + 
                orang.getId_orang() + "';";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean deleteOrang(String id_orang) {
        query= "delete from orang where id_orang='" +
                id_orang + "'";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public List selectOrang(String id, String nama) {
        query="select * from orang where id_orang like '%" +
                id + "%' or nama like '%" + nama + "' order by id_orang ASC";
        if (koneksi.eksekusiQuery(query, true)) {
            rsOrang = koneksi.getRs();
            listOrang = new ArrayList<>();
            try{
                while(rsOrang.next()){
                    Orang orang = new Orang(
                            rsOrang.getString("id_orang"),
                            rsOrang.getString("nama"),
                            rsOrang.getString("alamat"),
                            rsOrang.getString("email"),
                            rsOrang.getString("telpon")
                    );
                    listOrang.add(orang);
                }
                rsOrang.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Orang) :" + ex);
                return null;
            }
            return listOrang;
        }
        return null;
    }

    @Override
    public String generateIDOrang() {
        String id="";
        int angka = 0;
        query = "select max(right(id_orang, 7)) as id from orang";
        if (koneksi.eksekusiQuery(query, true)) {
            rsGenID = koneksi.getRs();
            try{
                rsGenID.next();
                angka = rsGenID.getInt("id") +1;
                if (angka <= 9 ) {
                    id = "O000000" + (angka); 
                }
                else if (angka > 9 && angka < 100 ) {
                    id="O00000"+ (angka);
                }
                else if (angka > 99 && angka < 1000 ) {
                    id="O0000"+ (angka);
                }
                else if (angka > 999 && angka < 10000 ) {
                    id="O000"+ (angka);
                }
                else if (angka > 9999 && angka < 100000 ) {
                    id="O00"+ (angka);
                }
                else if (angka > 99999 && angka < 1000000 ) {
                    id="O0"+ (angka);
                }
                else{
                    id="O"+(angka);
                }
                
            } catch (SQLException ex) {
                System.out.println("Failed Generate id :" + ex);
                return null;
            }
        }
        return id;
    }

    @Override
    public List selectKaryawan(String id, String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
