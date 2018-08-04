/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.DBSetting;

/**
 *
 * @author Rahmat Subekti
 */
public interface IDBSetting {
    boolean setSetting(DBSetting setting);
    DBSetting getSetting();
    
}
