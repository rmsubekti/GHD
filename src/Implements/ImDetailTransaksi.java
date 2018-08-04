/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.DBSetting;
import Entity.DetailTransaksi;
import Factory.Factory;
import Interfaces.IDBSetting;
import Interfaces.IDetailTransaksi;
import Koneksi.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public class ImDetailTransaksi implements IDetailTransaksi{
    private String query;
    private DB koneksi;
    private ResultSet rsDetTransaksi, rsGenID;
    private List<DetailTransaksi> listDetTransaksi;
    private DBSetting setting;
    private final IDBSetting settingDAO;

    public ImDetailTransaksi() {
        settingDAO = Factory.getSettingDAO();
        setting = settingDAO.getSetting();
        koneksi = new DB();
        koneksi.getKoneksi(setting);
    }

    @Override
    public boolean insertDetailTransaksi(DetailTransaksi detailTransaksi) {
        query = "insert into det_transaksi values('" +
                detailTransaksi.getId_detail()+ "','" +
                detailTransaksi.getId_transaksi() + "','" +
                detailTransaksi.getId_barang() + "','" +
                detailTransaksi.getJumlah() + "','" +
                detailTransaksi.getTotal_harga()+ "')";
        return koneksi.eksekusiQuery(query, false);
    }

    @Override
    public List selectDetailTransaksi(String id) {
        query="select * from det_transaksi where id_detail = '%" +
                id + "' order by id_detail ASC";
        if (koneksi.eksekusiQuery(query, true)) {
            rsDetTransaksi = koneksi.getRs();
            listDetTransaksi = new ArrayList<>();
            try{
                while(rsDetTransaksi.next()){
                    DetailTransaksi detTransaksi = new DetailTransaksi(
                            rsDetTransaksi.getString("id-detail"),
                            rsDetTransaksi.getString("id_transaksi"),
                            rsDetTransaksi.getString("id_produk"),
                            rsDetTransaksi.getInt("jumlah"),
                            rsDetTransaksi.getInt("total_harga")
                    );
                    listDetTransaksi.add(detTransaksi);
                }
                rsDetTransaksi.close();
            } catch (SQLException ex) {
                System.out.println("Err(Select Obat) :" + ex);
                return null;
            }
            return listDetTransaksi;
        }
        return null;
    }

    @Override
    public String generateIDDetailTransaksi() {
        String id="";
        int angka =0;
        query = "select max(right(id_detail, 9)) as id from det_transaksi";
        if (koneksi.eksekusiQuery(query, true)) {
            rsGenID = koneksi.getRs();
            try{
                rsGenID.next();
                angka = rsGenID.getInt("id") + 1;
                if (angka <= 9 ) {
                    id = "DT00000000" + (angka); 
                }
                else if (angka > 9 && angka < 100 ) {
                    id="DT0000000"+ (angka);
                }
                else if (angka > 99 && angka < 1000 ) {
                    id="DT000000"+ (angka);
                }
                else if (angka > 999 && angka < 10000 ) {
                    id="DT00000"+ (angka);
                }
                else if (angka > 9999 && angka < 100000 ) {
                    id="DT0000"+ (angka);
                }
                else if (angka > 99999 && angka < 1000000 ) {
                    id="DT000"+ (angka);
                }
                else if (angka > 999999 && angka < 10000000 ) {
                    id="DT00"+ (angka);
                }
                else if (angka > 9999999 && angka < 100000000 ) {
                    id="DT0"+ (angka);
                } else{
                    id="DT"+(angka);
                }
                
            } catch (SQLException ex) {
                System.out.println("Failed Generate id :" + ex);
                return null;
            }
        }
        return id;
    }
    
}
