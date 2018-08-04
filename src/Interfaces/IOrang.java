/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Orang;
import java.util.List;

/**
 *
 * @author Rahmat Subekti
 */
public interface IOrang {
    boolean insertOrang(Orang orang);
    boolean updateOrang(Orang orang);
    boolean deleteOrang(String id);
    List selectOrang(String id, String nama);
    List selectKaryawan(String id, String nama);
    String generateIDOrang();
}
