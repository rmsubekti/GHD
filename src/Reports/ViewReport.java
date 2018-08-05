/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;
import Factory.Factory;
import Interfaces.IDBSetting;
import Koneksi.DB;
import java.awt.HeadlessException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RahmatSubekti
 */
public class ViewReport {
    private final DB db = new DB();
    private final IDBSetting setting = Factory.getSettingDAO();
    
    public void Transaksi(){
        try{
            db.getKoneksi(setting.getSetting());
            try{
                Map<String, Object> parameter = new HashMap<>();
                File rpt = new File("src/Reports/Transaksi.jrxml");
                JasperDesign jDesign = null;
                jDesign = (JasperDesign) JRXmlLoader.load(rpt);
                parameter.clear();
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport,
                        parameter,db.getKoneksi(setting.getSetting()));
                JasperViewer.viewReport(jPrint,false);
            }catch(JRException e){
                JOptionPane.showMessageDialog(null, "Laporan Tidak Ditemukan " + e);
            }
        }catch(HeadlessException e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    public void Pelanggan(){
        try{
            db.getKoneksi(setting.getSetting());
            try{
                Map<String, Object> parameter = new HashMap<>();
                File rpt = new File("src/Reports/Pelanggan.jrxml");
                JasperDesign jDesign = null;
                jDesign = (JasperDesign) JRXmlLoader.load(rpt);
                parameter.clear();
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport,
                        parameter,db.getKoneksi(setting.getSetting()));
                JasperViewer.viewReport(jPrint,false);
            }catch(JRException e){
                JOptionPane.showMessageDialog(null, "Laporan Tidak Ditemukan " + e);
            }
        }catch(HeadlessException e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    public void Produk(){
        try{
            db.getKoneksi(setting.getSetting());
            try{
                Map<String, Object> parameter = new HashMap<>();
                File rpt = new File("src/Reports/Produk.jrxml");
                JasperDesign jDesign = null;
                jDesign = (JasperDesign) JRXmlLoader.load(rpt);
                parameter.clear();
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport,
                        parameter,db.getKoneksi(setting.getSetting()));
                JasperViewer.viewReport(jPrint,false);
            }catch(JRException e){
                JOptionPane.showMessageDialog(null, "Laporan Tidak Ditemukan " + e);
            }
        }catch(HeadlessException e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
}
