package Factory;

import Implements.*;
import Interfaces.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rahmat Subekti
 */
public class Factory {
    private static IAkun AkunDAO;
    private static IDBSetting SettingDAO;
    private static IDetailTransaksi DetailDAO;
    private static IKategori KategoriDAO;
    private static IOrang OrangDAO;
    private static IProduk ProdukDAO;
    private static ITransaksi TransaksiDAO;
    
    public static IAkun getAkunDAO(){
        AkunDAO = new ImAkun();
        return AkunDAO;
    }

    public static IDBSetting getSettingDAO() {
        SettingDAO = new ImDBSetting();
        return SettingDAO;
    }

    public static IDetailTransaksi getDetailDAO() {
        DetailDAO = new ImDetailTransaksi();
        return DetailDAO;
    }

    public static IKategori getKategoriDAO() {
        KategoriDAO = new ImKategori();
        return KategoriDAO;
    }

    public static IOrang getOrangDAO() {
       OrangDAO = new ImOrang();
       return OrangDAO;
    }

    public static IProduk getProdukDAO() {
        ProdukDAO = new ImProduk();
        return ProdukDAO;
    }

    public static ITransaksi getTransaksiDAO() {
        TransaksiDAO = new ImTransaksi();
        return TransaksiDAO;
    }
}
