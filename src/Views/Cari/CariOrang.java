/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Cari;

import Entity.Orang;
import Factory.Factory;
import Interfaces.IOrang;
import Views.FrmAkun;
import Views.FrmTransaksi;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rahmat Subekti
 */
public class CariOrang extends javax.swing.JDialog {
    public  FrmAkun akun = null;
    public FrmTransaksi transaksi = null;
    private DefaultTableModel dtmOrang;
    private String[] tableHeader;
    private IOrang orangDAO;
    private List<Orang> listOrang;
    private Orang jo;
    /**
     * Creates new form CariOrang
     * @param parent
     * @param modal
     */
    public CariOrang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        orangDAO = Factory.getOrangDAO();
        tableHeader = new String[]{
            "ID",
            "Nama",
            "Alamat",
            "Email",
            "No. Telpon"
        };
        dtmOrang = new DefaultTableModel(null, tableHeader);
        tblOrang.setModel(dtmOrang);
        refreshIsiTable();
    }

    private void refreshIsiTable() {
        listOrang = orangDAO.selectOrang(
                txtCari.getText(), 
                txtCari.getText());
        dtmOrang = (DefaultTableModel) tblOrang.getModel();
        dtmOrang.setRowCount(0);
        
        listOrang.stream().forEach((data) -> {
            dtmOrang.addRow(new Object[]{
                data.getId_orang(),
                data.getNama(),
                data.getAlamat(),
                data.getEmail(),
                data.getNo_telpon()
            });
        });
        
        if (tblOrang.getRowCount()>0) {
            int baris = tblOrang.getRowCount()-1;
            tblOrang.setRowSelectionInterval(baris, baris);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrang = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari Orang");
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.UTILITY);

        tblOrang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblOrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrang);

        btnCari.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrangMouseClicked
        // TODO add your handling code here:
        int baris = tblOrang.getSelectedRow();
        jo = new Orang(
                tblOrang.getValueAt(baris,0).toString(),
                tblOrang.getValueAt(baris,1).toString(),
                tblOrang.getValueAt(baris,2).toString(),
                tblOrang.getValueAt(baris,3).toString(),
                tblOrang.getValueAt(baris,4).toString()
        );
        if (akun != null) akun.dto=jo;
        else transaksi.dto=jo;
        
        this.dispose();
    }//GEN-LAST:event_tblOrangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CariOrang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariOrang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariOrang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariOrang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CariOrang dialog = new CariOrang(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrang;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
