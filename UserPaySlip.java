/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpackage;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 *
 * @author USER
 */
public class UserPaySlip extends javax.swing.JFrame {
Connection con;
ResultSet rs2,rs3,rs4,rs5;
PreparedStatement ps,ps1;
Statement stmt;
String ename;
int c;
    /**
     * Creates new form UserPaySlip
     */
    public UserPaySlip() 
    {
        initComponents();
        try
        {
        c=0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollmanagement?useSSL=false","root","admin@1234");
        String sql2;
        sql2 ="select * from Salary";
        stmt=this.con.createStatement();
        rs2=stmt.executeQuery(sql2);
        while(rs2.next())
        {
           c2.addItem(rs2.getString("E_id"));
           c++;
        }
         rs2.close();
         stmt.close();
         con.close();
        }
        catch(Exception e)
        {
        
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

        c2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Id" }));

        t1.setColumns(20);
        t1.setRows(5);
        jScrollPane1.setViewportView(t1);

        jButton1.setText("Generate Pay Slip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        b3.setText("Generate");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(b3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
     String basic,da,ta,hra,gross,pf,net;
        try
        {
            String sql1;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollmanagement?useSSL=false","root","pritam@1234");
            stmt=this.con.createStatement();
            sql1="select * from Salary where E_id='"+c2.getSelectedItem()+"'";
            rs2=stmt.executeQuery(sql1);
            ename=rs2.getString("E_name");
         System.out.print(ename);
            basic=rs2.getString("Basic");
            da=rs2.getString("DA");
            ta=rs2.getString("TA");
            hra=rs2.getString("HRA");
            gross=rs2.getString("Gross");
            pf=rs2.getString("PF");
            net=rs2.getString("NET");
         
            
            if(rs2.next()){
          
                t1.append("\n     Employee ID "+rs2.getString("E_id"));
                t1.append("\n     Employee Name "+ename);
 
                t1.append("\n----------------------------------------------------------------");
                t1.append("\n");

                t1.append("\n                  HRA         : "+hra);
                t1.append("\n                  DA          : "+da);
                t1.append("\n                  TA         : "+ta);
                t1.append("\n                  PF          : "+pf);
                t1.append("\n                  Basic        : "+basic);
                
                /*double perday=basic/30;
                
                double f_half=perday/2;
                double s_half=perday/2;
                
                System.out.println(f_half);
                System.out.println(s_half);
                
                System.out.println(nf_half);
                System.out.println(ns_half);
                
                
                gross = hra+da+ta+pf+(nf_half*f_half)+(ns_half*s_half);
                 net = gross - pf;*/
             
                t1.append("\n-------------------------------------------------------");
                t1.append("\n");
 
              
                //t1.append("\n       Tax   :   2.1% of gross "+ (gross*2.1/100));   
                t1.append("\n -------------------------------------------------");
                t1.append("\n");
                t1.append("\n");    
                t1.append("\n");
                t1.append("   (  Signature  )      ");
                t1.append(rs2.getString(2));
            }
        }
        catch(Exception e)
        { System.out.println(e);}        // TODO add your handling code here:
    }//GEN-LAST:event_b3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* try{
            String id=String.valueOf(c2.getSelectedItem());

            int x=Integer.valueOf(id);
            //  System.out.println(x);
            String sql2="select * from Attendance where Emp_id='"+x+"'";
            rs2=stmt.executeQuery(sql2);
            rs2.next();
            String f_h=rs2.getString("First_Half");
            String s_h=rs2.getString("Second_Half");
            System.out.println(f_h);
            System.out.println(s_h);
            rs2.close();
            String sql3="select * from Attendance where Emp_id='"+x+"' and First_Half='Present'";
            rs3=stmt.executeQuery(sql3);
            int count=0;
            while(rs3.next())
            count++;
            int nf_half=count;
            rs3.close();
            String sql4="select * from Attendance where Emp_id='"+x+"' and Second_Half='Present'";
            rs4=stmt.executeQuery(sql4);
            int count1=0;
            while(rs4.next())
            count1++;
            int ns_half=count1;
            rs4.close();
            String sql5="select * from Salary where E_id='"+x+"'";
            rs5=stmt.executeQuery(sql5);
            ename=rs5.getString("E_name");
            System.out.print(ename);
            double gross=0.0;
            double net=0.0;

            java.util.Date d1 = new java.util.Date();
            int month = d1.getMonth();
            t1.setText(" ----------------   PAY SLIP FOR THE MONTH OF "+month+" ,2019  ------------------------");
            t1.append("\n");

            if(rs5.next()){

                t1.append("\n     Employee ID "+rs5.getString("E_id"));
                t1.append("\n     Employee Name "+ename);

                t1.append("\n----------------------------------------------------------------");
                t1.append("\n");

                double hra = rs5.getDouble("HRA");
                t1.append("\n                  HRA         : "+hra);
                double da  = rs5.getDouble("DA");
                t1.append("\n                  DA          : "+da);
                double ta  = rs5.getDouble("TA");
                t1.append("\n                  TA         : "+ta);
                double pf  = rs5.getDouble("PF");
                t1.append("\n                  PF          : "+pf);
                double basic  = rs5.getDouble("Basic");
                t1.append("\n                  Basic          : "+basic);

                /*double perday=basic/30;

                double f_half=perday/2;
                double s_half=perday/2;

                System.out.println(f_half);
                System.out.println(s_half);

                System.out.println(nf_half);
                System.out.println(ns_half);

                gross = hra+da+ta+pf+(nf_half*f_half)+(ns_half*s_half);
                net = gross - pf;

                t1.append("\n-------------------------------------------------------");
                t1.append("\n");

                t1.append("\n       GROSS SALARY :"+gross+"    \n       NET SALARY : "+net);
                //t1.append("\n       Tax   :   2.1% of gross "+ (gross*2.1/100));
                t1.append("\n -------------------------------------------------");
                t1.append("\n");
                t1.append("\n");
                t1.append("\n");
                t1.append("   (  Signature  )      ");
            }
            rs5.close();
        }catch(Exception e){
            System.out.println(e);
        }*/
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserPaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPaySlip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b3;
    private javax.swing.JComboBox<String> c2;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea t1;
    // End of variables declaration//GEN-END:variables
}
