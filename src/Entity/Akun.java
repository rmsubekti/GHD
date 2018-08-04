/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Rahmat Subekti
 */
public class Akun {
    private String id_akun,id_orang, username,password,role;

    public Akun(String id_akun, String id_orang, String username, String password, String role) {
        this.id_akun = id_akun;
        this.id_orang = id_orang;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Akun() {
    }

    public String getId_akun() {
        return id_akun;
    }

    public void setId_akun(String id_akun) {
        this.id_akun = id_akun;
    }

    public String getId_orang() {
        return id_orang;
    }

    public void setId_orang(String id_orang) {
        this.id_orang = id_orang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
