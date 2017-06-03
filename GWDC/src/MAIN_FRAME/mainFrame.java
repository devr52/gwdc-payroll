
package MAIN_FRAME;

import static DBConnect.DBC.createEMPDATA;
import static DBConnect.DBC.createEMPDATA3;
import static DBConnect.DBC.createUT;
import Employee_IFrame.employeeIFrame;
import Help_IFRAME.helpIFrame;
import Payroll_IFrame.*;
import Reports_IFrame.reportsIFrame;
import Settings_IFrame.settingsFrame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.sql.*;

public class mainFrame extends javax.swing.JFrame {

    private static employeeIFrame f1=new employeeIFrame();
    private static reportsIFrame f2=new reportsIFrame();
    private static settingsFrame f3=new settingsFrame();
    private static helpIFrame f4=new helpIFrame();
    private static SalmgmtIFrame p1=new SalmgmtIFrame();
    private static computeIFrame p2=new computeIFrame();
    private static genIFrame p3=new genIFrame();

    
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    private Statement stmt=null;
    
    private boolean open_close;
    
         
   public void openConnection(){
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/Peeroll;IGNORECASE=TRUE","edmon", "" );
        }
         catch(Exception e )
        {
           JOptionPane.showMessageDialog(null, "PROGRAM ALREADY IN USE.");
        }
    }
   
    public mainFrame() {  
        initComponents();
        setIcon();
        createUT();
        createEMPDATA();
        createEMPDATA3();
        
                
        openConnection();
        
        pname.setVisible(false);
        userInput.requestFocus();
        reportsDD.setEnabled(false);
        reportsDD.setVisible(false);
        
        payrollDD.setEnabled(false);
        payrollDD.setVisible(false);
        
        helpDD.setEnabled(false);
        helpDD.setVisible(false);
        
        salmgmtBtn.setEnabled(false);
        gensalBtn.setEnabled(false);
        computesalBtn.setEnabled(false);
        salmgmtBtn.setVisible(false);
        gensalBtn.setVisible(false);
        computesalBtn.setVisible(false);
        
        logoutBtn.setVisible(false);
        logoutLb.setVisible(false);
        
        
        desktop.setVisible(false);
        employeeMnu.setEnabled(false);
        payrollMnu.setEnabled(false);
        reportsMnu.setEnabled(false);
        settingsMnu.setEnabled(false);
        helpMnu.setEnabled(false);
        dropMnu.setEnabled(false);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pname = new javax.swing.JLabel();
        reportsDD = new javax.swing.JLabel();
        salmgmtBtn = new javax.swing.JLabel();
        computesalBtn = new javax.swing.JLabel();
        gensalBtn = new javax.swing.JLabel();
        payrollDD = new javax.swing.JLabel();
        helpDD = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();
        loginLb = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        logoutLb = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        employeeMnu = new javax.swing.JButton();
        payrollMnu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reportsMnu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        settingsMnu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        exitMnu = new javax.swing.JButton();
        dropMnu = new javax.swing.JLabel();
        helpMnu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JLabel();
        loginBG = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        userInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        footertxt = new javax.swing.JLabel();
        bluebg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GWDC: EZ-Payroll");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(reportsDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 110, 100));

        salmgmtBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salmgmtBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salmgmtBtnMouseClicked(evt);
            }
        });
        getContentPane().add(salmgmtBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, 20));

        computesalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        computesalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                computesalBtnMouseClicked(evt);
            }
        });
        getContentPane().add(computesalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 110, 20));

        gensalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gensalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gensalBtnMouseClicked(evt);
            }
        });
        getContentPane().add(gensalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 105, 110, 20));
        getContentPane().add(payrollDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, 100));
        getContentPane().add(helpDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 50, 120, 100));

        desktop.setBackground(new java.awt.Color(102, 102, 102));
        desktop.setPreferredSize(new java.awt.Dimension(1024, 660));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 65, 1012, 630));

        loginLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Start Menu.png"))); // NOI18N
        loginLb.setText("    ");
        getContentPane().add(loginLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, 30, 30));

        loginBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(0, 153, 0));
        loginBtn.setText("     LOG-IN");
        loginBtn.setBorder(null);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, 100, 30));

        logoutLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/High Priority.png"))); // NOI18N
        logoutLb.setText("  ");
        getContentPane().add(logoutLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, 30, 30));

        logoutBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 51, 0));
        logoutBtn.setText("         LOG-OUT");
        logoutBtn.setBorder(null);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        getContentPane().add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 110, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/identity-card.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 18, 30, 30));

        employeeMnu.setBackground(new java.awt.Color(255, 51, 51));
        employeeMnu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        employeeMnu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/EMPLOYEEMENU_1.png"))); // NOI18N
        employeeMnu.setActionCommand("EMPLOYEE \nMANAGEMENT");
        employeeMnu.setBorder(null);
        employeeMnu.setContentAreaFilled(false);
        employeeMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeMnuActionPerformed(evt);
            }
        });
        getContentPane().add(employeeMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 18, 100, 30));

        payrollMnu.setBackground(new java.awt.Color(255, 51, 51));
        payrollMnu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        payrollMnu.setText("       PAYROLL");
        payrollMnu.setBorder(null);
        payrollMnu.setContentAreaFilled(false);
        payrollMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payrollMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollMnuActionPerformed(evt);
            }
        });
        getContentPane().add(payrollMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 18, 100, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/dollar-sign-and-piles-of-coins.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 18, 30, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/task-complete.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 30, 30));

        reportsMnu.setBackground(new java.awt.Color(255, 51, 51));
        reportsMnu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        reportsMnu.setText("    REPORTS");
        reportsMnu.setBorder(null);
        reportsMnu.setContentAreaFilled(false);
        reportsMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsMnu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsMnuMouseExited(evt);
            }
        });
        reportsMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsMnuActionPerformed(evt);
            }
        });
        getContentPane().add(reportsMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 120, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Installing Updates.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 18, 30, 30));

        settingsMnu.setBackground(new java.awt.Color(255, 51, 51));
        settingsMnu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        settingsMnu.setText("       SETTINGS");
        settingsMnu.setBorder(null);
        settingsMnu.setContentAreaFilled(false);
        settingsMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMnuActionPerformed(evt);
            }
        });
        getContentPane().add(settingsMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 18, 110, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Exit.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 18, 30, 30));

        exitMnu.setBackground(new java.awt.Color(255, 51, 51));
        exitMnu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        exitMnu.setText("    EXIT");
        exitMnu.setBorder(null);
        exitMnu.setContentAreaFilled(false);
        exitMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMnuActionPerformed(evt);
            }
        });
        getContentPane().add(exitMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 18, 80, 30));

        dropMnu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Menu.png"))); // NOI18N
        dropMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(dropMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 23, 30, 30));

        helpMnu.setBackground(new java.awt.Color(255, 51, 51));
        helpMnu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        helpMnu.setText("    HELP");
        helpMnu.setBorder(null);
        helpMnu.setContentAreaFilled(false);
        helpMnu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        helpMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMnuActionPerformed(evt);
            }
        });
        getContentPane().add(helpMnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 18, 90, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Help.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 18, 30, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 18, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 18, -1, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 18, -1, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 18, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 18, -1, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 18, -1, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/divider.PNG"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 18, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/HEADERBG_1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 60));

        loginPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        loginBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/loginBG.png"))); // NOI18N

        passwordInput.setBorder(null);
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });
        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordInputKeyPressed(evt);
            }
        });

        userInput.setBorder(null);
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addComponent(loginBG)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(loginBG)
        );

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 192, -1, 300));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        footertxt.setBackground(new java.awt.Color(255, 255, 255));
        footertxt.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        footertxt.setForeground(new java.awt.Color(255, 255, 255));
        footertxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        footertxt.setText("Copyright of Edmon. All Rights Reserved.");
        jPanel1.add(footertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 3, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 696, 1020, 20));

        bluebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/content-bg.jpg"))); // NOI18N
        getContentPane().add(bluebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1020, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnActionPerformed

    private void payrollMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollMnuActionPerformed
        if(open_close==false) {
            payrollDD.setEnabled(true);
            payrollDD.setVisible(true);
            salmgmtBtn.setVisible(true);
            gensalBtn.setVisible(true);
            computesalBtn.setVisible(true);
            salmgmtBtn.setEnabled(true);
            gensalBtn.setEnabled(true);
            computesalBtn.setEnabled(true);
        
            ImageIcon II =new ImageIcon(getClass().getResource("payrollDD.png"));
            payrollDD.setIcon(II);
            
            open_close= true;
        }
        else if (open_close==true) {
                payrollDD.setEnabled(false);
                payrollDD.setVisible(false);
                salmgmtBtn.setVisible(false);
                gensalBtn.setVisible(false);
                computesalBtn.setVisible(false);
                salmgmtBtn.setEnabled(false);
                gensalBtn.setEnabled(false);
                computesalBtn.setEnabled(false);
               
                payrollDD.setIcon(null);
            
                open_close=false;
        }  
        
    }//GEN-LAST:event_payrollMnuActionPerformed

    private void reportsMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsMnuActionPerformed
        f2=new reportsIFrame();
        desktop.add(f2);
        f2.setVisible(true);
        
        f1.dispose();
        f3.dispose();
        f4.dispose();
        
        p1.dispose();
        p2.dispose();
        p3.dispose();
        
  /*      
     if(open_close==false) {
            reportsDD.setEnabled(true);
            reportsDD.setVisible(true);
        
            ImageIcon II =new ImageIcon(getClass().getResource("reportsDD.png"));
            reportsDD.setIcon(II);
            
            open_close= true;
        }
        else if (open_close==true) {
                reportsDD.setEnabled(false);
                reportsDD.setVisible(false);
        
                reportsDD.setIcon(null);
            
                open_close=false;}
        */
        
    }//GEN-LAST:event_reportsMnuActionPerformed

    private void settingsMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMnuActionPerformed
        settingsFrame popup=new settingsFrame();
        popup.setVisible(true);
    }//GEN-LAST:event_settingsMnuActionPerformed

    private void exitMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMnuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMnuActionPerformed

    private void helpMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMnuActionPerformed
       try{
             Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Documents and Settings\\TRAINEE.PC22\\Desktop\\SDA\\html\\html\\DESIGN.HTML");
             
         }
         catch (Exception ex){
             JOptionPane.showMessageDialog(null,ex);
         }
        
        
     if(open_close==false) {
            helpDD.setEnabled(true);
            helpDD.setVisible(true);
        
           ImageIcon II =new ImageIcon(getClass().getResource("helpDD.png"));
            helpDD.setIcon(II);
            
            open_close= true;
        }
        else if (open_close==true) {
            helpDD.setEnabled(false);
            helpDD.setVisible(false);
        
            helpDD.setIcon(null);
            
            open_close=false;
        }  
        
    }//GEN-LAST:event_helpMnuActionPerformed

    private void employeeMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeMnuActionPerformed
        f1=new employeeIFrame();
        desktop.add(f1);
        f1.setVisible(true);
        
        f2.dispose();
        f3.dispose();
        f4.dispose();
        
        p1.dispose();
        p2.dispose();
        p3.dispose();
    }//GEN-LAST:event_employeeMnuActionPerformed

    private void reportsMnuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMnuMouseExited
        
    }//GEN-LAST:event_reportsMnuMouseExited

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
      
      
       try{
           String query="SELECT * FROM USERTABLE WHERE USER=? AND PASS=?";
           
           pst=conn.prepareStatement(query);
           pst.setString(1,userInput.getText());
           pst.setString(2,new String(passwordInput.getPassword()));
           
           rs=pst.executeQuery();
           
            if (rs.next()) {
                
            pname.setText(rs.getString("name")); 
            
            JOptionPane.showMessageDialog(null,"Login Successfully");
            desktop.setVisible(true);
            f1 = new employeeIFrame();
            desktop.add(f1);
            f1.setVisible(true);

            employeeMnu.setEnabled(true);
            payrollMnu.setEnabled(true);
            reportsMnu.setEnabled(true);
            settingsMnu.setEnabled(true);
            helpMnu.setEnabled(true);
            dropMnu.setEnabled(true);
           
            logoutBtn.setVisible(true);
            logoutLb.setVisible(true);
            
            loginPanel.setVisible(false);
            loginBtn.setVisible(false);
            loginLb.setVisible(false);
            
        }
            else {
                JOptionPane.showMessageDialog(null,"Wrong Username/Password");
                userInput.setText("");
                passwordInput.setText("");
                userInput.requestFocus();   
            }
        }
            
        catch(SQLException err){
                JOptionPane.showMessageDialog(null,err.toString());
                 }
       
       openConnection();
    
    }//GEN-LAST:event_loginButtonMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        logoutBtn.setVisible(false);
        logoutLb.setVisible(false);
        
        loginBtn.setVisible(true);
        loginLb.setVisible(true);
        loginPanel.setVisible(true);
        
        userInput.setText("");
        passwordInput.setText("");
        userInput.requestFocus(true);

        desktop.setVisible(false);
        employeeMnu.setEnabled(false);
        payrollMnu.setEnabled(false);
        reportsMnu.setEnabled(false);
        settingsMnu.setEnabled(false);
        helpMnu.setEnabled(false);
        dropMnu.setEnabled(false);
        
        reportsDD.setEnabled(false);
        reportsDD.setVisible(false);   
        helpDD.setEnabled(false);
        helpDD.setVisible(false);
         openConnection();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void passwordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
       
       try{
           String query="SELECT * FROM USERTABLE WHERE USER=? AND PASS=?";
           
           pst=conn.prepareStatement(query);
           pst.setString(1,userInput.getText());
           pst.setString(2,new String(passwordInput.getPassword()));
           
           rs=pst.executeQuery();
           
            if (rs.next()) {
                
            pname.setText(rs.getString("name")); 
            
            JOptionPane.showMessageDialog(null,"Login Successfully");
            desktop.setVisible(true);
            f1 = new employeeIFrame();
            desktop.add(f1);
            f1.setVisible(true);

            employeeMnu.setEnabled(true);
            payrollMnu.setEnabled(true);
            reportsMnu.setEnabled(true);
            settingsMnu.setEnabled(true);
            helpMnu.setEnabled(true);
            dropMnu.setEnabled(true);
           
            logoutBtn.setVisible(true);
            logoutLb.setVisible(true);
            
            loginPanel.setVisible(false);
            loginBtn.setVisible(false);
            loginLb.setVisible(false);
            
        }
            else {
                JOptionPane.showMessageDialog(null,"Wrong Username/Password");
                userInput.setText("");
                passwordInput.setText("");
                userInput.requestFocus();
            }
        }
            
        catch(SQLException err){
                JOptionPane.showMessageDialog(null,err.toString());
                 }
        finally{
           try{
               conn.close();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
       }
            
        }
        openConnection();
    }//GEN-LAST:event_passwordInputKeyPressed

    private void salmgmtBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salmgmtBtnMouseClicked
        p1=new SalmgmtIFrame();
        desktop.add(p1);
        p1.setVisible(true);
        
        payrollDD.setEnabled(false);
        salmgmtBtn.setEnabled(false);
        gensalBtn.setEnabled(false);
        computesalBtn.setEnabled(false);
        payrollDD.setVisible(false);
        salmgmtBtn.setVisible(false);
        computesalBtn.setVisible(false);
        gensalBtn.setVisible(false);
       
        
        payrollDD.setIcon(null);
        
        f1.dispose();
        f2.dispose();
        f3.dispose();
        f4.dispose();
        
        p2.dispose();
        p3.dispose();
        
    }//GEN-LAST:event_salmgmtBtnMouseClicked

    private void computesalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computesalBtnMouseClicked
        p2=new computeIFrame();
        desktop.add(p2);
        p2.setVisible(true);
        
        payrollDD.setEnabled(false);
        salmgmtBtn.setEnabled(false);
        gensalBtn.setEnabled(false);
        computesalBtn.setEnabled(false);
        payrollDD.setVisible(false);
        salmgmtBtn.setVisible(false);
        computesalBtn.setVisible(false);
        gensalBtn.setVisible(false);
        payrollDD.setIcon(null);

        f1.dispose();
        f2.dispose();
        f3.dispose();
        f4.dispose();
        
        p1.dispose();
        p3.dispose();
        


    }//GEN-LAST:event_computesalBtnMouseClicked

    private void gensalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gensalBtnMouseClicked
        p3=new genIFrame();
        desktop.add(p3);
        p3.setVisible(true);
        
        payrollDD.setEnabled(false);
        salmgmtBtn.setEnabled(false);
        gensalBtn.setEnabled(false);
        computesalBtn.setEnabled(false);
        payrollDD.setVisible(false);
        salmgmtBtn.setVisible(false);
        computesalBtn.setVisible(false);
        gensalBtn.setVisible(false);
        
        
        payrollDD.setIcon(null);
        
        f1.dispose();
        f2.dispose();
        f3.dispose();
        f4.dispose();
        
        p1.dispose();
        p2.dispose();

    }//GEN-LAST:event_gensalBtnMouseClicked

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bluebg;
    private javax.swing.JLabel computesalBtn;
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel dropMnu;
    private javax.swing.JButton employeeMnu;
    private javax.swing.JButton exitMnu;
    private javax.swing.JLabel footertxt;
    private javax.swing.JLabel gensalBtn;
    private javax.swing.JLabel helpDD;
    private javax.swing.JButton helpMnu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginBG;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel loginLb;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel logoutLb;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel payrollDD;
    private javax.swing.JButton payrollMnu;
    public static javax.swing.JLabel pname;
    private javax.swing.JLabel reportsDD;
    private javax.swing.JButton reportsMnu;
    private javax.swing.JLabel salmgmtBtn;
    private javax.swing.JButton settingsMnu;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("we.png")));
    }
}

