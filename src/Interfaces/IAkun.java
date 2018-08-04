/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Akun;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public interface IAkun {
    boolean insertAkun(Akun akun);
    boolean updateAkun(Akun akun);
    boolean deleteAkun(String id);
    List selectAkun(String username, String password);
    List selectAkun();
    String generateIDAkun();
}
