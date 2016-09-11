/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {

    final String DB_URL = "jdbc:derby:DB;create=true;";  //Database URL
    final String USER = "app";
    final String PASS = "app";

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Password = new javax.swing.JPasswordField();
        UserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SignUp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Password.setOpaque(false);
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 170, -1));

        UserName.setOpaque(false);
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        getContentPane().add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 170, -1));

        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 65, 20));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 65, 20));

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 170, -1));

        jLabel4.setText(" Welcome!");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        SignUp.setText("Sign Up");
        SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpActionPerformed(evt);
            }
        });
        getContentPane().add(SignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 170, -1));

        jLabel3.setText("Sign in with your account:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, 20));

        jLabel5.setText("Create a new account:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 170, 20));

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oce/Clouds.jpg"))); // NOI18N
        getContentPane().add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String User = UserName.getText();
        if (User.equals("")) {
            JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            return;
        }
        String Pass = Password.getText();
        if (Pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            return;
        }
        String sql = "SELECT * FROM USERS";
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database.");

            //Execute query
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               
                if (rs.getString("USERNAME").toLowerCase().equals(User.toLowerCase())) {
                    if (rs.getString("PASSWORD").equals(Pass)) {
                        if (rs.getString("DEPARTMENT").equals("Admission")) {
                            Admission A = new Admission(rs.getString("USERNAME"), rs.getString("NAME"), rs.getString("PASSWORD"));
                            A.setVisible(true);
                            this.dispose();
                            return;
                        } else if (rs.getString("DEPARTMENT").equals("HR")) {
                            HR H = new HR(rs.getString("USERNAME"), rs.getString("NAME"), rs.getString("PASSWORD"));
                            H.setVisible(true);
                            this.dispose();
                            return;
                        } else if (rs.getString("DEPARTMENT").equals("Treasury")) {
                            Treasury T = new Treasury(rs.getString("USERNAME"), rs.getString("NAME"), rs.getString("PASSWORD"));
                            T.setVisible(true);
                            this.dispose();
                            return;
                        } else {
                            JOptionPane.showMessageDialog(this, "Your account has not yet been confirmed.");
                            return;
                        }
                    } else {
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
        } catch (Exception e) {
            sql = "CREATE TABLE USERS (USERNAME varchar(255),PASSWORD varchar(255),DEPARTMENT varchar(255), PHONE varchar(255),EMAIL varchar(255),NAME varchar(255),BIRTH varchar(255),POSITION varchar(255),SALARY DOUBLE, RECORDS varchar(255),PRIMARY KEY (USERNAME))";
            try {
                stmt.execute(sql);
                System.out.println("Table created");
                sql = "INSERT INTO USERS (USERNAME ,PASSWORD,DEPARTMENT, PHONE ,EMAIL,NAME ,BIRTH,SALARY,RECORDS,POSITION) VALUES ('Elio1','123456','HR','70336193','elio.bouhabib@lau.edu','Elio Bou Habib','27/07/1992',1000,'Default account.\n','Manager')";
                stmt.execute(sql);
                sql = "SELECT * FROM USERS";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    if (rs.getString("USERNAME").toLowerCase().equals(User.toLowerCase())) {
                        if (rs.getString("PASSWORD").equals(Pass)) {
                            if (rs.getString("DEPARTMENT").equals("Admission")) {
                                Admission A = new Admission(rs.getString("USERNAME"), rs.getString("NAME"), rs.getString("PASSWORD"));
                                A.setVisible(true);
                                this.dispose();
                                return;
                            } else if (rs.getString("DEPARTMENT").equals("HR")) {
                                HR H = new HR(rs.getString("USERNAME"), rs.getString("NAME"), rs.getString("PASSWORD"));
                                H.setVisible(true);
                                this.dispose();
                                return;
                            } else if (rs.getString("DEPARTMENT").equals("Treasury")) {
                                Treasury T = new Treasury(rs.getString("USERNAME"), rs.getString("NAME"), rs.getString("PASSWORD"));
                                T.setVisible(true);
                                this.dispose();
                                return;
                            } else {
                                JOptionPane.showMessageDialog(this, "Your account has not yet been confirmed.");
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            } catch (Exception f) {
                f.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpActionPerformed
        SignUp SU = new SignUp();
        SU.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SignUpActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton SignUp;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}