/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oce;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author user
 */
public class Treasury extends javax.swing.JFrame {

    private String Password;
    private String Username;
    private String Name;
    final String DB_URL = "jdbc:derby:DB;create=true;";  //Database URL
    final String USER = "app";
    final String PASS = "app";
    boolean Changing = false;
    public Treasury() {
        initComponents();
    }

    public Treasury(String U,String N,String P) {
        initComponents();
        Password=P;
        Username=U;
        Name=N;
        Welcome.setText("Welcome "+Name);
        B();
    }
    public void SetPassword(String P)
    {
        Password=P;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Balance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        FA = new javax.swing.JTextField();
        jlabel3 = new javax.swing.JLabel();
        AF = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Fund = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Change Password");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 160, -1));

        jButton2.setText("Sign Out");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 160, -1));
        getContentPane().add(Welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 20));

        jLabel1.setText("Add funds:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 20));

        Balance.setEditable(false);
        Balance.setOpaque(false);
        getContentPane().add(Balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 120, -1));

        jLabel2.setText("Balance:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        FA.setOpaque(false);
        getContentPane().add(FA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, -1));

        jlabel3.setText("Fund Activity:");
        getContentPane().add(jlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 90, 20));

        AF.setOpaque(false);
        getContentPane().add(AF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 120, -1));

        Add.setText("Add");
        Add.setOpaque(false);
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 70, -1));

        Fund.setText("Fund");
        Fund.setOpaque(false);
        Fund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FundActionPerformed(evt);
            }
        });
        getContentPane().add(Fund, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 70, -1));

        jButton3.setText("Line Chart");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jButton4.setText("Bar Chart");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 200, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oce/Clouds.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Changing == false) {
            Changing = true;
            ChangePass CP = new ChangePass(Password, Username, this);
            CP.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void B()
    {
        Date now = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat( "dd MM yyyy" ); 
        String sql = "SELECT * FROM FUNDS";
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
            double max=0;
            while (rs.next()) {
            if(rs.getString("DATE").equals(formatter.format( now )))
            {
                max=rs.getDouble("AMOUNT");
                Balance.setText(max+"");
                return;
            }
            }
        } catch (Exception E) {
            E.printStackTrace();
            sql = "CREATE TABLE FUNDS (ID int,DATE varchar(255),AMOUNT Double,PRIMARY KEY (ID))";
            try {
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (1,'10 02 2014',2000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (2,'04 03 2014',-1000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (3,'14 04 2014',2000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (4,'01 05 2014',500)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (5,'20 05 2014',-4000)";
                stmt.execute(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Done?", JOptionPane.YES_NO_OPTION);
        if(reply==1)
        {
            return;
        }
        Login L = new Login();
        L.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        double D;
        try
        {
            D=Double.parseDouble(AF.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Please enter a salary");
            return;
        }
        Date now = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat( "dd MM yyyy" ); 
        String sql = "SELECT * FROM FUNDS";
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
            int max=0;
            while (rs.next()) {
                if (rs.getInt("ID")>max) {
                    max=rs.getInt("ID");
                }
            if(rs.getString("DATE").equals(formatter.format( now )))
            {
                max=rs.getInt("ID");
                UPDB(max,D+rs.getDouble("AMOUNT"), formatter.format( now ));
                return;
            }
            }
            UpdateDB(max,D, formatter.format( now ));
        } catch (Exception E) {
            E.printStackTrace();
            sql = "CREATE TABLE FUNDS (ID int,DATE varchar(255),AMOUNT Double,PRIMARY KEY (ID))";
            try {
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (1,'10 02 2014',2000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (2,'04 03 2014',-1000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (3,'14 04 2014',2000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (4,'01 05 2014',500)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (5,'20 05 2014',-4000)";
                stmt.execute(sql);
                UpdateDB(5,D, formatter.format( now ));
            } catch (SQLException ex) {
                ex.printStackTrace();
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
       
    }//GEN-LAST:event_AddActionPerformed

    public void UPDB(int max,double S,String T)
    {
        Connection conn = null;
        Statement stmt = null;
        String sql = "UPDATE FUNDS SET AMOUNT="+S+" WHERE ID ="+max;
        try {
            //Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database.");

            //Execute query
            stmt = conn.createStatement();

            stmt.execute(sql);
            B();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    public void UpdateDB(int max,double S,String T)
    {
        Connection conn = null;
        Statement stmt = null;
        max++;
        String sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES ("+max+",'"+T+"',"+S+")";
        try {
            //Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database.");

            //Execute query
            stmt = conn.createStatement();

            stmt.execute(sql);
            B();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    private void FundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FundActionPerformed
        double D;
        try
        {
            D=Double.parseDouble(FA.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Please enter a salary");
            return;
        }
        D=-D;
        Date now = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat( "dd MM yyyy" ); 
        String sql = "SELECT * FROM FUNDS";
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
            int max=0;
            while (rs.next()) {
                if (rs.getInt("ID")>max) {
                    max=rs.getInt("ID");
                }
                
            if(rs.getString("DATE").equals(formatter.format( now )))
            {
                max=rs.getInt("ID");
                UPDB(max,D+rs.getDouble("AMOUNT"), formatter.format( now ));
                return;
            }
            }
            UpdateDB(max,D, formatter.format( now ));
        } catch (Exception E) {
            sql = "CREATE TABLE FUNDS (ID int,DATE varchar(255),AMOUNT Double,PRIMARY KEY (ID))";
            try {
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (1,'10 02 2014',2000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (2,'04 03 2014',-1000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (3,'14 04 2014',2000)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (4,'01 05 2014',500)";
                stmt.execute(sql);
                sql = "INSERT INTO FUNDS (ID,DATE,AMOUNT) VALUES (5,'20 05 2014',-4000)";
                stmt.execute(sql);
                UpdateDB(5,D, formatter.format( now ));
            } catch (SQLException ex) {
                ex.printStackTrace();
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
    
    }//GEN-LAST:event_FundActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection conn = null;
        Statement stmt = null;
        String sql = "SELECT * FROM FUNDS";
        try {
            //Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database.");

            //Execute query
            stmt = conn.createStatement();

            ResultSet rs=stmt.executeQuery(sql);
            DefaultCategoryDataset DS=new DefaultCategoryDataset();
            double F=0;
            while(rs.next())
            {
                F=F+rs.getDouble("AMOUNT");
                DS.setValue(F, "Balance per Date", rs.getString("DATE"));
            }
            JFreeChart FC=ChartFactory.createLineChart("Funds", "Date", "Balance", DS);
            CategoryPlot p=FC.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame=new ChartFrame("Line Chart",FC);
            frame.setVisible(true);
            frame.setSize(700,500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Connection conn = null;
        Statement stmt = null;
        String sql = "SELECT * FROM FUNDS";
        try {
            //Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database.");

            //Execute query
            stmt = conn.createStatement();

            ResultSet rs=stmt.executeQuery(sql);
            DefaultCategoryDataset DS=new DefaultCategoryDataset();
            double F=0;
            while(rs.next())
            {
                F=F+rs.getDouble("AMOUNT");
                DS.setValue(F, "Balance per Date", rs.getString("DATE"));
            }
            JFreeChart FC=ChartFactory.createBarChart3D("Funds", "Date", "Balance", DS);
            CategoryPlot p=FC.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame=new ChartFrame("Line Chart",FC);
            frame.setVisible(true);
            frame.setSize(700,500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Treasury.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Treasury().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AF;
    private javax.swing.JButton Add;
    private javax.swing.JTextField Balance;
    private javax.swing.JTextField FA;
    private javax.swing.JButton Fund;
    private javax.swing.JLabel Welcome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlabel3;
    // End of variables declaration//GEN-END:variables
}
