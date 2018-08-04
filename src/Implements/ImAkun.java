/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.Akun;
import Entity.DBSetting;
import Factory.Factory;
import Interfaces.IAkun;
import Interfaces.IDBSetting;
import Koneksi.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public class ImAkun implements IAkun{
    private String query;
    private DB koneksi;
    private ResultSet rsGenID, rsAkun;
    private List<Akun> listAkun;
    private DBSetting setting;
    private final IDBSetting settingDAO;

    public ImAkun() {
        settingDAO = Factory.getSettingDAO();
        setting = settingDAO.getSetting();
        koneksi = new DB();
        koneksi.getKoneksi(setting);
    }

    @Override
    public boolean insertAkun(Akun akun) {
        query = "insert into akun values('" +
                akun.getId_akun()+ "','" +
                akun.getId_orang() + "','" +
                akun.getUsername() + "','" +
                akun.getPassword() + "','" +
                akun.getRole()+ "')";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean updateAkun(Akun akun) {
         query = "update akun set id_orang='" + akun.getId_orang()+
                "', username='" + akun.getUsername() +
                "', password='" + akun.getPassword() +
                "', role='" + akun.getRole() +
                "' where id='" + 
                akun.getId_akun() + "';";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public boolean deleteAkun(String id) {
        query= "delete from akun where id='" + id + "'";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public List selectAkun() {
        query="select * from akun";
        if (koneksi.eksekusiQuery(query, true)) {
            rsAkun = koneksi.getRs();
            listAkun = new ArrayList<>();
            try{
                while(rsAkun.next()){
                    Akun l = new Akun(
                            rsAkun.getString("id"),
                            rsAkun.getString("id_orang"),
                            rsAkun.getString("username"),
                            rsAkun.getString("password"),
                            rsAkun.getString("role")
                    );
                    listAkun.add(l);
                }
                rsAkun.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Login) :" + ex);
                return null;
            }
            return listAkun;
        }
        return null;
    }
    @Override
    public List selectAkun(String username, String password) {
        query="select * from akun where username='" +
                username + "' and password='" + password + "'";
        if (koneksi.eksekusiQuery(query, true)) {
            rsAkun = koneksi.getRs();
            listAkun = new ArrayList<>();
            try{
                while(rsAkun.next()){
                    Akun l = new Akun(
                            rsAkun.getString("id"),
                            rsAkun.getString("id_orang"),
                            rsAkun.getString("username"),
                            rsAkun.getString("password"),
                            rsAkun.getString("role")
                    );
                    listAkun.add(l);
                }
                rsAkun.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Login) :" + ex);
                return null;
            }
            return listAkun;
        }
        return null;
    }

    @Override
    public String generateIDAkun() {
        String id="";
        int angka = 0;
        query = "select max(right(id, 6)) as id from akun";
        if (koneksi.eksekusiQuery(query, true)) {
            rsGenID = koneksi.getRs();
            try{
                rsGenID.next();
                angka = rsGenID.getInt("id") +1;
                if (angka <= 9 ) {
                    id = "A00000" + (angka); 
                }
                else if (angka > 9 && angka < 100 ) {
                    id="A0000"+ (angka);
                }
                else if (angka > 99 && angka < 1000 ) {
                    id="A000"+ (angka);
                }
                else if (angka > 999 && angka < 10000 ) {
                    id="A00"+ (angka);
                }
                else if (angka > 9999 && angka < 100000 ) {
                    id="A0"+ (angka);
                }
                else{
                    id="A"+(angka);
                }
                
            } catch (SQLException ex) {
                System.out.println("Failed Generate id :" + ex);
                return null;
            }
        }
        return id;
    }

}
