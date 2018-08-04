/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghdesktop;

import Entity.DBSetting;
import Factory.Factory;
import Interfaces.IDBSetting;
import Koneksi.DB;
import Views.FrmLogin;
import Views.FrmSettingDB;

/**
 *
 * @author Rahmat Subekti
 */
public class GHDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IDBSetting DbSetting = Factory.getSettingDAO();
        DBSetting setting = DbSetting.getSetting();
        if (setting!=null) {
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
        }else{
            FrmSettingDB dbSetting = new FrmSettingDB();
            dbSetting.setVisible(true);
        }
    }
    
}
