/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import Entity.DBSetting;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rahmat Subekti
 */
public class DB {
    private Connection koneksi;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public Connection getKoneksi(DBSetting setting) {
        if (koneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    String url="jdbc:mysql://"+setting.getHost()+":"+setting.getPort()+"/"+setting.getDatabase();
                    koneksi = (Connection) DriverManager.getConnection(url,setting.getUsername(),setting.getPassword());
                } catch (SQLException ex) {
                    return null;
                }
                //System.out.println("Koneksi Sukses");
            } catch (ClassNotFoundException ex) {
                return null;
            }
        }
        return koneksi;
    }

    public ResultSet getRs() {
        return rs;
    }
        
    public boolean eksekusiQuery(String query, boolean status){
        try {
            ps = (PreparedStatement) koneksi.prepareStatement(query);
            if (status) {
                rs = ps.executeQuery();
            }else{
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            System.err.println(ex+": Query Gagal");
            return false;
        }
    }
}
