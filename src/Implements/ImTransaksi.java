/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.DBSetting;
import Entity.Transaksi;
import Factory.Factory;
import Interfaces.IDBSetting;
import Interfaces.ITransaksi;
import Koneksi.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public class ImTransaksi implements ITransaksi{
    private String query;
    private DB koneksi;
    private ResultSet rsTransaksi, rsGenID;
    private List<Transaksi> listTransaksi;
    private DBSetting setting;
    private final IDBSetting settingDAO;

    public ImTransaksi() {
        settingDAO = Factory.getSettingDAO();
        setting = settingDAO.getSetting();
        koneksi = new DB();
        koneksi.getKoneksi(setting);
    }

    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
        query = "insert into transaksi values('" +
                transaksi.getId_transaksi()+ "','" +
                transaksi.getId_orang() + "','" +
                transaksi.getTanggal() + "','" +
                transaksi.getTotal_bayar()+ "')";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public List selectTransaksi(String kode, String tanggal) {
        query="select * from transaksi where id_transaksi like '%" +
                kode + "%' or tanggal = '%" + tanggal + "' order by id_transaksi ASC";
        if (koneksi.eksekusiQuery(query, true)) {
            rsTransaksi = koneksi.getRs();
            listTransaksi = new ArrayList<>();
            try{
                while(rsTransaksi.next()){
                    Transaksi transaksi = new Transaksi(
                            rsTransaksi.getString("id_transaksi"),
                            rsTransaksi.getString("id_orang"),
                            rsTransaksi.getString("tanggal"),
                            rsTransaksi.getInt("total_bayar")
                    );
                    listTransaksi.add(transaksi);
                }
                rsTransaksi.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Obat) :" + ex);
                return null;
            }
            return listTransaksi;
        }
        return null;
    }

    @Override
    public String generateIDTransaksi() {
        String id="";
        int angka = 0;
        query = "select max(right(id_transaksi, 8)) as id from transaksi";
        if (koneksi.eksekusiQuery(query, true)) {
            rsGenID = koneksi.getRs();
            try{
                rsGenID.next();
                angka = rsGenID.getInt("id") +1;
                if (angka <= 9 ) {
                    id = "T0000000" + (angka); 
                }
                else if (angka > 9 && angka < 100 ) {
                    id="T000000"+ (angka);
                }
                else if (angka > 99 && angka < 1000 ) {
                    id="T00000"+ (angka);
                }
                else if (angka > 999 && angka < 10000 ) {
                    id="T0000"+ (angka);
                }
                else if (angka > 9999 && angka < 100000 ) {
                    id="T000"+ (angka);
                }
                else if (angka > 99999 && angka < 1000000 ) {
                    id="T00"+ (angka);
                }
                else if (angka > 999999 && angka < 10000000 ) {
                    id="T0"+ (angka);
                }
                else{
                    id="T"+(angka);
                }
                
            } catch (SQLException ex) {
                System.out.println("Failed Generate id :" + ex);
                return null;
            }
        }
        return id;
    }
    
}
