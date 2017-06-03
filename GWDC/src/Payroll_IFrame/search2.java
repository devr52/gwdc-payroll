/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll_IFrame;


import static Payroll_IFrame.computeIFrame.absencesOut;
import static Payroll_IFrame.computeIFrame.absentCount;
import static Payroll_IFrame.computeIFrame.bonusOut;
import static Payroll_IFrame.computeIFrame.bonusa;
import static Payroll_IFrame.computeIFrame.bpOut1;
import static Payroll_IFrame.computeIFrame.caIn;
import static Payroll_IFrame.computeIFrame.caOut;
import static Payroll_IFrame.computeIFrame.dependentsV;
import static Payroll_IFrame.computeIFrame.deptOut1;
import static Payroll_IFrame.computeIFrame.designationOut1;
import static Payroll_IFrame.computeIFrame.dsrV;
import static Payroll_IFrame.computeIFrame.empIDout1;
import static Payroll_IFrame.computeIFrame.fnameOut1;
import static Payroll_IFrame.computeIFrame.foodLa;
import static Payroll_IFrame.computeIFrame.grossOut;
import static Payroll_IFrame.computeIFrame.hdOut;
import static Payroll_IFrame.computeIFrame.hdp;
import static Payroll_IFrame.computeIFrame.hsrV;
import static Payroll_IFrame.computeIFrame.lateM;
import static Payroll_IFrame.computeIFrame.latesOut;
import static Payroll_IFrame.computeIFrame.leavecV;
import static Payroll_IFrame.computeIFrame.loanD;
import static Payroll_IFrame.computeIFrame.loanOut;
import static Payroll_IFrame.computeIFrame.month13L;
import static Payroll_IFrame.computeIFrame.month13Out;
import static Payroll_IFrame.computeIFrame.msrV;
import static Payroll_IFrame.computeIFrame.ndOut;
import static Payroll_IFrame.computeIFrame.ndp;
import static Payroll_IFrame.computeIFrame.netOut;
import static Payroll_IFrame.computeIFrame.otOut;
import static Payroll_IFrame.computeIFrame.otp;
import static Payroll_IFrame.computeIFrame.pagibigL;
import static Payroll_IFrame.computeIFrame.pagibigOut;
import static Payroll_IFrame.computeIFrame.philhealthL;
import static Payroll_IFrame.computeIFrame.philhealthOut;
import static Payroll_IFrame.computeIFrame.picOut2;
import static Payroll_IFrame.computeIFrame.saltypeV;
import static Payroll_IFrame.computeIFrame.sssL;
import static Payroll_IFrame.computeIFrame.sssOut;
import static Payroll_IFrame.computeIFrame.statusV;
import static Payroll_IFrame.computeIFrame.surnameOut1;
import static Payroll_IFrame.computeIFrame.tiOut;
import static Payroll_IFrame.computeIFrame.tpOut;
import static Payroll_IFrame.computeIFrame.transpoLa;
import static Payroll_IFrame.computeIFrame.udM;
import static Payroll_IFrame.computeIFrame.udOut;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class search2 extends javax.swing.JFrame {

   ResultSet rs=null;
    PreparedStatement pst=null;
    Connection conn=null;
    Statement stmt=null;
    
    final void updateT(){
        
        try{
            String query="select empid,surname,firstname from empdata ORDER BY EMPID";
            
            pst=conn.prepareStatement(query);

            rs=pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }  
    
    public void openConnection(){
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/Peeroll;IGNORECASE=TRUE","edmon", "" );
        }
         catch( Exception e )
        {
           JOptionPane.showMessageDialog(null, "PROGRAM ALREADY IN USE.");
        }
    }
    
    public search2() {
        initComponents();
        openConnection();
        updateT();
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
        table2 = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                // This is how we disable editing:
                return false;
            }}
            ;
            jPanel6 = new javax.swing.JPanel();
            jLabel29 = new javax.swing.JLabel();
            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            fnameIn = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            idIn = new javax.swing.JTextField();
            jLabel2 = new javax.swing.JLabel();
            surnameIn = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            table2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            table2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            table2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    table2MouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(table2);

            jPanel6.setBackground(new java.awt.Color(255, 51, 51));

            jLabel29.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
            jLabel29.setForeground(new java.awt.Color(255, 255, 255));
            jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel29.setText("FIND EMPLOYEE");

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(103, 103, 103))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
            );

            jPanel1.setForeground(new java.awt.Color(102, 102, 102));

            jLabel1.setBackground(new java.awt.Color(0, 0, 0));
            jLabel1.setText("Employee ID:");

            fnameIn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            fnameIn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fnameInActionPerformed(evt);
                }
            });
            fnameIn.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    fnameInKeyReleased(evt);
                }
            });

            jLabel3.setBackground(new java.awt.Color(0, 0, 0));
            jLabel3.setText("First Name:");

            idIn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            idIn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    idInActionPerformed(evt);
                }
            });
            idIn.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    idInKeyReleased(evt);
                }
            });

            jLabel2.setBackground(new java.awt.Color(0, 0, 0));
            jLabel2.setText("Surname:");

            surnameIn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            surnameIn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    surnameInActionPerformed(evt);
                }
            });
            surnameIn.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    surnameInKeyReleased(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(idIn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(surnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(fnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(surnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(fnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void idInKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idInKeyReleased
        try {

            String query="SELECT empid,surname,firstname FROM EMPDATA where EMPID LIKE ?";

            pst=conn.prepareStatement(query);

            pst.setString(1, idIn.getText()+"%");

            rs=pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));

            rs=pst.executeQuery();

            if(rs.next()) {
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }

        catch(SQLException err)   {
            JOptionPane.showMessageDialog(null, err);
        }
    }//GEN-LAST:event_idInKeyReleased

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        try{
            int row=table2.getSelectedRow();
            String table_click=(table2.getModel().getValueAt(row, 0).toString());
            //disabled();

            String query="select empid,surname,firstname,designation,department,dsr,hsr,msr,leavec,civilstatus,pagibig,philhealth,sss,food,BP,transpo,dependents,saltype,image from empdata where empid='"+table_click+"'";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();

            if(rs.next()){
                empIDout1.setText(rs.getString(1));
                surnameOut1.setText(rs.getString(2));
                fnameOut1.setText(rs.getString(3));
                designationOut1.setText(rs.getString(4));
                deptOut1.setText(rs.getString(5));
                if(rs.getString(6)==(null)){
                    JOptionPane.showMessageDialog(null,"SALARY PROFILE FOR THIS EMPLOYEE IS NOT BEEN SET. GO TO SALARY MANAGEMENT MENU");
                }
                else{
                dsrV.setText(rs.getString(6));
                }
                hsrV.setText(rs.getString(7));
                msrV.setText(rs.getString(8));
                leavecV.setText(rs.getString(9));
                statusV.setText(rs.getString(10));
                pagibigL.setText(rs.getString(11));
                philhealthL.setText(rs.getString(12));
                sssL.setText(rs.getString(13));
                foodLa.setText(rs.getString(14));
                bpOut1.setText(rs.getString(15));
                transpoLa.setText(rs.getString(16));
                dependentsV.setText(rs.getString(17));
                saltypeV.setText(rs.getString(18));
                
                if(rs.getBytes("image")==null){
                    ImageIcon II=new ImageIcon(getClass().getResource("DEFAULT.png"));
                    picOut2.setIcon(II);
                }   
                else{
                byte[]imagedata=rs.getBytes("image");
                format=new ImageIcon(imagedata);
                picOut2.setIcon(format);
                }
            }
                
                lateM.setText("0");
                absentCount.setText("0");
                udM.setText("0");
                loanD.setText("0");
                bonusa.setText("0");
                month13L.setText("0");
                otp.setText("0");
                ndp.setText("0");
                hdp.setText("0");
                absentCount.setText("0");
                lateM.setText("0");
                udM.setText("0");
                loanD.setText("0");
                caIn.setText("0");
                
                String sal=saltypeV.getText();
                int bp=Integer.parseInt(bpOut1.getText());
                
                
                
                if(sal.equals("SEMI-MONTHLY")){
                   int semi=bp/2;
                   bpOut1.setText(Integer.toString(semi));
                }
                
             pagibigOut.setText(null);
             sssOut.setText(null);
             philhealthOut.setText(null);
             loanOut.setText(null);
             tiOut.setText(null);
             tpOut.setText(null);
             absencesOut.setText(null);
             udOut.setText(null);
             latesOut.setText(null);
             grossOut.setText(null);
             netOut.setText(null);
             bonusOut.setText(null);
             otOut.setText(null);
             ndOut.setText(null);
             hdOut.setText(null);
                
                

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        dispose();
    }//GEN-LAST:event_table2MouseClicked

    private void idInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInActionPerformed

    private void surnameInKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surnameInKeyReleased
        try {

            String query="SELECT empid,surname,firstname FROM EMPDATA where surname LIKE ?";

            pst=conn.prepareStatement(query);

            pst.setString(1, surnameIn.getText()+"%");

            rs=pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));

            rs=pst.executeQuery();

            if(rs.next()) {
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }

        catch(SQLException err)   {
            JOptionPane.showMessageDialog(null, err);
        }
    }//GEN-LAST:event_surnameInKeyReleased

    private void fnameInKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameInKeyReleased
        try {

            String query="SELECT empid,surname,firstname FROM EMPDATA where firstname LIKE ?";

            pst=conn.prepareStatement(query);

            pst.setString(1, fnameIn.getText()+"%");

            rs=pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));

            rs=pst.executeQuery();

            if(rs.next()) {
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }

        catch(SQLException err)   {
            JOptionPane.showMessageDialog(null, err);
        }
    }//GEN-LAST:event_fnameInKeyReleased

    private void fnameInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameInActionPerformed

    private void surnameInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameInActionPerformed

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
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fnameIn;
    private javax.swing.JTextField idIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField surnameIn;
    public static javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
private ImageIcon format=null;
String filename=null;
int s=0;
byte[] pimage=null;
}