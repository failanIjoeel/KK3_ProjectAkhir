/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author lenovo
 */
public class Login extends javax.swing.JFrame {
     Connection conn = null;
    Statement st = null;

    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal) {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/data_siswa","root","");
            st=conn.createStatement();
            JOptionPane.showMessageDialog(null, "Berhasil Login...");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Gagal terkoneksi Karena " + ex);
        }
    }
    
    private void CekLogin(){
            try{
                if(txtuser.getText().equals("") ||txtpass.getPassword().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                    txtuser.requestFocus();
                    HapusLayar();
                }else{
                    st = conn.createStatement();
                    String sql = ("SELECT * FROM login WHERE username = '"+txtuser.getText()+"' AND password = '"+String.valueOf(txtpass.getPassword())+"'");
                    ResultSet rs = st.executeQuery(sql);
                }
                if(rs.next()){
                    this.dispose();
                    new Siswa().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "User Name dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan",
                    JOptionPane.ERROR_MESSAGE);
                    HapusLayar();   
                }
                    
            }catch(Exception e){
             e.printStackTrace();
            }
    }
private void HapusLayar() {
        txtUsername.setText("");
        txtPass.setText("");
        txtUsername.setEnabled(true);
        txtPass.setEnabled(true);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JLabel();
        txtPass = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        tbLogin = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LOGIN");

        txtUsername.setText("Username");

        txtPass.setText("Password");

        tbLogin.setText("Login");
        tbLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPass)
                                .addComponent(txtUsername))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtuser, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addComponent(txtpass)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(tbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(98, 98, 98)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(tbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbLoginActionPerformed
        // TODO add your handling code here:
         try{ 
            if(txtuser.getText().equals("") ||  
            txtpass.getPassword().equals("")){ 
            JOptionPane.showMessageDialog(rootPane, "Data  Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);  txtuser.requestFocus(); 
            HapusLayar(); 
       }else{ 
            st = conn.createStatement(); 
            String sql = ("SELECT * FROM login WHERE username =  '"+txtuser.getText()+"' AND password =  '"+String.valueOf(txtpass.getPassword())+"'");  ResultSet rs = st.executeQuery(sql); 
            if(rs.next()){ 
            this.dispose(); 
            new Siswa().setVisible(true);  }else{ 
            JOptionPane.showMessageDialog(rootPane, "User  Name dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan",  JOptionPane.ERROR_MESSAGE); 
            HapusLayar(); 
            } 
        } 
        }catch(Exception e){ 
            e.printStackTrace(); 
        }
    }//GEN-LAST:event_tbLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Login dialog = new Login (new javax.swing.JFrame(),true);
                    dialog.addWindowListener(new
                java.awt.event.WindowAdapter() {
            @Override
            public void

        windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                      }
                    });
            dialog.setVisible(true);
            }
        });
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton tbLogin;
    private javax.swing.JLabel txtPass;
    private javax.swing.JLabel txtUsername;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
