/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Entity.DBSetting;
import Interfaces.IDBSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Rahmat Subekti
 */
public class ImDBSetting implements IDBSetting{
    private final Properties prop = new Properties();

    @Override
    public boolean setSetting(DBSetting setting) {
        try{
            prop.setProperty("host", setting.getHost());
            prop.setProperty("port", setting.getPort());
            prop.setProperty("database", setting.getDatabase());
            prop.setProperty("username", setting.getUsername());
            prop.setProperty("password", setting.getPassword());
            prop.storeToXML(new FileOutputStream("config.prop"), null);
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

    @Override
    public DBSetting getSetting() {
        DBSetting setting;
        File file = new File("config.prop");
        if (file.exists()) {
            try{
                prop.loadFromXML(new FileInputStream("config.prop"));
                setting = new DBSetting(
                    prop.getProperty("host"),
                    prop.getProperty("port"),
                    prop.getProperty("username"),
                    prop.getProperty("password"),
                    prop.getProperty("database")
                );
            } catch (IOException ex) {
                return null;
            }
            return setting;
        }
        return null;
    }
    
}
