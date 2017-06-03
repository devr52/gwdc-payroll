/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee_IFrame;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class employeeIFrame extends javax.swing.JInternalFrame {
    ResultSet rs=null;
    PreparedStatement pst=null;
    Connection conn=null;
    Statement stmt=null;
    
    

    final void updateT(){
        try
        {   
            String query="select empid,surname,firstname from EMPDATA ORDER BY empid";
            
            pst=conn.prepareStatement(query);

            rs=pst.executeQuery();
            empTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    public void clearDisabled(){
                empIDIn.setText(null);
                surnameIn.setText(null);
                fnameIn.setText(null);
                midNameIn.setText(null);
                bdateIn.setDate(null);
                ageIn.setText(null);
                addressIn.setText(null);
                contactnumIn.setText(null);
                emergencycontactIn.setText(null);
                dateofempIn.setDate(null);
                designationIn.setText(null);
                deptIn.setText(null);
                //SHHH
                genderIn.setSelectedItem(null);
                statusIn.setSelectedItem(null);
                probationIn.setSelectedItem(null);
                empTypeIn.setSelectedItem(null);
                empStatIn.setSelectedItem(null);
                shiftIn.setSelectedItem(null);
                picOut.setIcon(null);
                
                empIDIn.setEnabled(false);
                surnameIn.setEnabled(false);
                fnameIn.setEnabled(false);
                midNameIn.setEnabled(false);
                genderIn.setEnabled(false);
                bdateIn.setEnabled(false);
                ageIn.setEnabled(false);
                addressIn.setEnabled(false);
                statusIn.setEnabled(false);
                contactnumIn.setEnabled(false);
                emergencycontactIn.setEnabled(false);
                dateofempIn.setEnabled(false);
                designationIn.setEnabled(false);
                deptIn.setEnabled(false);
                probationIn.setEnabled(false);
                empTypeIn.setEnabled(false);
                empStatIn.setEnabled(false);
                shiftIn.setEnabled(false);
                attachBtn.setEnabled(false);
    }
        
    public void enabledClear(){
                empIDIn.setEnabled(true);
                surnameIn.setEnabled(true);
                fnameIn.setEnabled(true);
                midNameIn.setEnabled(true);
                genderIn.setEnabled(true);
                bdateIn.setEnabled(true);
                ageIn.setEnabled(true);
                addressIn.setEnabled(true);
                statusIn.setEnabled(true);
                contactnumIn.setEnabled(true);
                emergencycontactIn.setEnabled(true);
                dateofempIn.setEnabled(true);
                designationIn.setEnabled(true);
                deptIn.setEnabled(true);
                probationIn.setEnabled(true);
                empTypeIn.setEnabled(true);
                empStatIn.setEnabled(true);
                shiftIn.setEnabled(true);
                attachBtn.setEnabled(true);
                       
                surnameIn.setText(null);
                fnameIn.setText(null);
                midNameIn.setText(null);
                genderIn.setSelectedItem(null);
                bdateIn.setDate(null);
                ageIn.setText(null);
                statusIn.setSelectedItem(null);
                addressIn.setText(null);
                contactnumIn.setText(null);
                emergencycontactIn.setText(null);
                empIDIn.setText(null);
                dateofempIn.setDate(null);
                designationIn.setText(null);
                deptIn.setText(null);
                probationIn.setSelectedItem(null);
                empTypeIn.setSelectedItem(null);
                empStatIn.setSelectedItem(null);
                shiftIn.setSelectedItem(null);
                picOut.setIcon(null);
                
    }
    
    public final void disabled(){
        empIDIn.setEnabled(false);
        surnameIn.setEnabled(false);
        fnameIn.setEnabled(false);
        midNameIn.setEnabled(false);
        genderIn.setEnabled(false);
        bdateIn.setEnabled(false);
        ageIn.setEnabled(false);
        addressIn.setEnabled(false);
        statusIn.setEnabled(false);
        contactnumIn.setEnabled(false);
        emergencycontactIn.setEnabled(false);
        dateofempIn.setEnabled(false);
        designationIn.setEnabled(false);
        deptIn.setEnabled(false);
        probationIn.setEnabled(false);
        empTypeIn.setEnabled(false);
        empStatIn.setEnabled(false);
        shiftIn.setEnabled(false);
        attachBtn.setEnabled(false);
        
       
        saveBtn.setEnabled(false);
        updateBtn.setEnabled(false);
    }
    
    public void searchTableClick(){
        
        try{
          
            int row=empTable.getSelectedRow();
            String table_click=(empTable.getModel().getValueAt(row, 0).toString());
            saveBtn.setEnabled(true);
            updateBtn.setEnabled(true);
            disabled();
            
            String query="select * from EMPDATA where employeeid='"+table_click+"'";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            
            if(rs.next()){
                empIDIn.setText(rs.getString(1));
                surnameIn.setText(rs.getString(2));
                fnameIn.setText(rs.getString(3));
                midNameIn.setText(rs.getString(4));
                genderIn.setSelectedItem(rs.getString(5));
                //bdateIn.setText(rs.getString(6));
                ageIn.setText(rs.getString(7));
                addressIn.setText(rs.getString(8));
                statusIn.setSelectedItem(rs.getString(9));
                contactnumIn.setText(rs.getString(10));
                emergencycontactIn.setText(rs.getString(11));
                //dateofempIn.setText(rs.getString(12));
                designationIn.setText(rs.getString(13));
                deptIn.setText(rs.getString(14));
                probationIn.setSelectedItem(rs.getString(15));
                empTypeIn.setSelectedItem(rs.getString(16));
                empStatIn.setSelectedItem(rs.getString(17));
                shiftIn.setSelectedItem(rs.getString(18));
            }
            updateT();
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
    
    public employeeIFrame() {
        initComponents();
  
        openConnection();
        updateT();
        disabled();
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        surnameRB.setSelected(true);
    
                
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        companyDepPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        empIDIn = new javax.swing.JTextField();
        probationIn = new javax.swing.JComboBox();
        designationIn = new javax.swing.JTextField();
        deptIn = new javax.swing.JTextField();
        employeetypeInput = new javax.swing.JLabel();
        empTypeIn = new javax.swing.JComboBox();
        employeestatusInput = new javax.swing.JLabel();
        empStatIn = new javax.swing.JComboBox();
        employeestatusInput1 = new javax.swing.JLabel();
        shiftIn = new javax.swing.JComboBox();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        addnewBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        dateofempIn = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        basicInfoPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        surnameIn = new javax.swing.JTextField();
        midNameIn = new javax.swing.JTextField();
        fnameIn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addressIn = new javax.swing.JTextField();
        ageIn = new javax.swing.JTextField();
        genderIn = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        statusIn = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        contactnumIn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emergencycontactIn = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        attachBtn = new javax.swing.JButton();
        bdateIn = new com.toedter.calendar.JDateChooser();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        picOut = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                // This is how we disable editing:
                return false;
            }
        };
        searchPanel = new javax.swing.JPanel();
        designationRB = new javax.swing.JRadioButton();
        deptRB = new javax.swing.JRadioButton();
        surnameRB = new javax.swing.JRadioButton();
        emptypeRB = new javax.swing.JRadioButton();
        shiftRB = new javax.swing.JRadioButton();
        idRB = new javax.swing.JRadioButton();
        empstatRB = new javax.swing.JRadioButton();
        fnameRB = new javax.swing.JRadioButton();
        searchIn = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1012, 630));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        companyDepPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true), "COMPANY DEPLOYMENT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 24), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("Employee ID");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("Date of Employment");

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel15.setText("Probation Period");

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel16.setText("Designation");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel17.setText("Department");

        empIDIn.setToolTipText("EMPLOYEE ID MUST BE UNIQUE");

        probationIn.setEditable(true);
        probationIn.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        probationIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
        probationIn.setSelectedItem(null);
        probationIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        designationIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designationInActionPerformed(evt);
            }
        });

        employeetypeInput.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        employeetypeInput.setText("Employee Type");

        empTypeIn.setEditable(true);
        empTypeIn.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        empTypeIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REGULAR", "PROBATIONARY", "CONTRACTUAL", "PART-TIME", "TRAINEE", "OJT" }));
        empTypeIn.setSelectedItem(null);
        empTypeIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        employeestatusInput.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        employeestatusInput.setText("Employment Status");

        empStatIn.setEditable(true);
        empStatIn.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        empStatIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVE", "INACTIVE" }));
        empStatIn.setSelectedItem(null);
        empStatIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        empStatIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empStatInActionPerformed(evt);
            }
        });

        employeestatusInput1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        employeestatusInput1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        employeestatusInput1.setText("Shift");

        shiftIn.setEditable(true);
        shiftIn.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        shiftIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "NIGHT" }));
        shiftIn.setSelectedItem(null);
        shiftIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shiftIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftInActionPerformed(evt);
            }
        });

        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        editBtn.setText("EDIT");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        addnewBtn.setText("ADD NEW");
        addnewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewBtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Save.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Add User Male.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Edit User Male_2.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Delete_2.png"))); // NOI18N

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Save.png"))); // NOI18N

        cancelBtn.setText("CANCEL");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Clear Symbol.png"))); // NOI18N

        dateofempIn.setToolTipText("DATE FORMAT [ YYYY-MM-DD ]");
        dateofempIn.setDateFormatString("yyyy-MM-dd\n");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("*");

        javax.swing.GroupLayout companyDepPanelLayout = new javax.swing.GroupLayout(companyDepPanel);
        companyDepPanel.setLayout(companyDepPanelLayout);
        companyDepPanelLayout.setHorizontalGroup(
            companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyDepPanelLayout.createSequentialGroup()
                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(companyDepPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyDepPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addnewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(companyDepPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(companyDepPanelLayout.createSequentialGroup()
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(30, 30, 30)
                                .addComponent(dateofempIn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyDepPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(deptIn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(companyDepPanelLayout.createSequentialGroup()
                                    .addGap(153, 153, 153)
                                    .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(empIDIn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(designationIn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(employeestatusInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(employeetypeInput, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(employeestatusInput1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(probationIn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empTypeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empStatIn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shiftIn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        companyDepPanelLayout.setVerticalGroup(
            companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyDepPanelLayout.createSequentialGroup()
                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(companyDepPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(probationIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(empIDIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(companyDepPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(employeetypeInput)
                                    .addComponent(empTypeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(employeestatusInput)
                                    .addComponent(empStatIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employeestatusInput1)
                                    .addComponent(shiftIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(companyDepPanelLayout.createSequentialGroup()
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateofempIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(designationIn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(deptIn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addnewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyDepPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(companyDepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(113, 113, 113))
        );

        getContentPane().add(companyDepPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 580, 330));

        basicInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true), "BASIC INFORMATION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 24), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Address");

        surnameIn.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        surnameIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameInActionPerformed(evt);
            }
        });

        midNameIn.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        midNameIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                midNameInFocusGained(evt);
            }
        });

        fnameIn.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        fnameIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnameInFocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Middle Name");

        addressIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressInActionPerformed(evt);
            }
        });

        genderIn.setEditable(true);
        genderIn.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        genderIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", " " }));
        genderIn.setSelectedItem(null);
        genderIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        genderIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderInActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("     Surname");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Birthday");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Age");

        statusIn.setEditable(true);
        statusIn.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        statusIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married", "Widowed", "Separated", " " }));
        statusIn.setSelectedItem(null);
        statusIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        statusIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusInActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Civil Status");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Gender");

        contactnumIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactnumInActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Contact Number");

        emergencycontactIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergencycontactInActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Contact in case of Emergency");

        attachBtn.setText("Attach Photo");
        attachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachBtnActionPerformed(evt);
            }
        });

        bdateIn.setDateFormatString("yyyy-MM-dd\n");

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        picOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jDesktopPane1.setLayer(picOut, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(picOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("*");

        javax.swing.GroupLayout basicInfoPanelLayout = new javax.swing.GroupLayout(basicInfoPanel);
        basicInfoPanel.setLayout(basicInfoPanelLayout);
        basicInfoPanelLayout.setHorizontalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addComponent(surnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(midNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderIn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addComponent(bdateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(ageIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(addressIn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(statusIn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emergencycontactIn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(attachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactnumIn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        basicInfoPanelLayout.setVerticalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fnameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(3, 3, 3)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(bdateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ageIn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))))
                .addGap(11, 11, 11)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactnumIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emergencycontactIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))))
        );

        getContentPane().add(basicInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 230));

        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), "EMPLOYEE LIST", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 24))); // NOI18N
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        empTable.setRowHeight(20);
        empTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);

        tablePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 360));

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Search by:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 14))); // NOI18N
        searchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchPanelMouseExited(evt);
            }
        });
        searchPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchPanelFocusGained(evt);
            }
        });
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        designationRB.setText("Designation");
        designationRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designationRBActionPerformed(evt);
            }
        });
        searchPanel.add(designationRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 16, 99, -1));

        deptRB.setText("Department");
        deptRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptRBActionPerformed(evt);
            }
        });
        searchPanel.add(deptRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 43, 99, -1));

        surnameRB.setText("Surname");
        surnameRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameRBActionPerformed(evt);
            }
        });
        searchPanel.add(surnameRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 43, 85, -1));

        emptypeRB.setText("Employee Type");
        emptypeRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptypeRBActionPerformed(evt);
            }
        });
        searchPanel.add(emptypeRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 68, -1, -1));

        shiftRB.setText("Shift");
        shiftRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftRBActionPerformed(evt);
            }
        });
        searchPanel.add(shiftRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 91, 99, -1));

        idRB.setText("Employee ID");
        idRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRBActionPerformed(evt);
            }
        });
        searchPanel.add(idRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 16, -1, -1));

        empstatRB.setText("Status");
        empstatRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empstatRBActionPerformed(evt);
            }
        });
        searchPanel.add(empstatRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 91, 85, -1));

        fnameRB.setText("First Name");
        fnameRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameRBActionPerformed(evt);
            }
        });
        searchPanel.add(fnameRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 68, 100, -1));

        searchIn.setForeground(new java.awt.Color(51, 51, 51));
        searchIn.setText("Search...");
        searchIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchInMouseClicked(evt);
            }
        });
        searchIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInActionPerformed(evt);
            }
        });
        searchIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInKeyReleased(evt);
            }
        });
        searchPanel.add(searchIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 17, 108, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESOURCES/Find User Male.png"))); // NOI18N
        searchPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        tablePanel.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 380, 130));

        jButton1.setText("VIEW LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tablePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 400, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void designationInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_designationInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_designationInActionPerformed

    private void empStatInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empStatInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empStatInActionPerformed

    private void shiftInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftInActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String bdayT=((JTextField)bdateIn.getDateEditor().getUiComponent()).getText();
        String empdateT=((JTextField)bdateIn.getDateEditor().getUiComponent()).getText();
        
        /*   String empidT=empIDIn.getText();
        String surnameT=surnameIn.getText();
        String fnameT=fnameIn.getText();
        String genderT=genderIn.getSelectedItem().toString();
        String statusT=statusIn.getSelectedItem().toString();
        
        
        if(empidT.equals("")){JOptionPane.showMessageDialog(null,"ENTER EMPLOYEE ID");}
        else if(surnameT.equals("")){JOptionPane.showMessageDialog(null,"ENTER SURNAME");}
        else if(fnameT.equals("")){JOptionPane.showMessageDialog(null,"ENTER FIRST NAME");}
        else if(genderT.equals("")){JOptionPane.showMessageDialog(null,"ENTER gender");}
        else if(bdayT.equals("")){JOptionPane.showMessageDialog(null,"ENTER BIRTHDAY USING PROPER DATE FORMAT yyyy/MM/dd");}
        else if(empdateT.equals("")){JOptionPane.showMessageDialog(null,"ENTER EMPLOYMENT DATE USING PROPER DATE FORMAT yyyy/MM/dd");}
        else if(statusT.equals("")){JOptionPane.showMessageDialog(null,"ENTER CIVIL STATUS.");}
        
        else{*/
            try {
                String query="insert into EMPDATA(empid,surname,firstname,middlename,gender,birthdate,age,address,civilstatus,contactnum,contactinemer,dateofemp,designation,department,probation,employeetype,employmentstatus,shift,image) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                pst=conn.prepareStatement(query);

                pst.setString(1,empIDIn.getText());
                pst.setString(2,surnameIn.getText()); 
                pst.setString(3,fnameIn.getText());
                pst.setString(4,midNameIn.getText());
                
                if(genderIn.getSelectedItem()==null){pst.setString(5,"");}
                    else{pst.setString(5,genderIn.getSelectedItem().toString());}
                
                if(bdayT.equals("")){pst.setString(6,"1521-04-27");}
                    else{pst.setString(6,((JTextField)bdateIn.getDateEditor().getUiComponent()).getText());}
                
                pst.setString(7,ageIn.getText());
                pst.setString(8,addressIn.getText());
                
                if(statusIn.getSelectedItem()==null){pst.setString(9,"");}
                    else{pst.setString(9,statusIn.getSelectedItem().toString());}
                    
                
                pst.setString(10,contactnumIn.getText());
                pst.setString(11,emergencycontactIn.getText());
                
                if(empdateT.equals("")){pst.setString(12,"1521-04-27");}
                    else{pst.setString(12,((JTextField)dateofempIn.getDateEditor().getUiComponent()).getText());}

                pst.setString(13,designationIn.getText());
                pst.setString(14,deptIn.getText());
                
                if(probationIn.getSelectedItem()==null){pst.setString(15,"");}
                    else{pst.setString(15,probationIn.getSelectedItem().toString());}
                
                if(empTypeIn.getSelectedItem()==null){pst.setString(16,"");}
                    else{pst.setString(16,empTypeIn.getSelectedItem().toString());}
                
                if(empStatIn.getSelectedItem()==null){pst.setString(17,"");}
                    else{pst.setString(17,empStatIn.getSelectedItem().toString());}
                
                if(shiftIn.getSelectedItem()==null){pst.setString(18,"");}
                    else{pst.setString(18,shiftIn.getSelectedItem().toString());}
      
                pst.setBytes(19,pimage);


                pst.execute();

                JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED");



            }
            catch(SQLException e){

                JOptionPane.showMessageDialog(null, e);
            }
            
        clearDisabled();
        updateT();
        saveBtn.setEnabled(false);

    }//GEN-LAST:event_saveBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        updateBtn.setEnabled(true);

        empIDIn.setEnabled(true);
        surnameIn.setEnabled(true);
        fnameIn.setEnabled(true);
        midNameIn.setEnabled(true);
        genderIn.setEnabled(true);
        bdateIn.setEnabled(true);
        ageIn.setEnabled(true);
        addressIn.setEnabled(true);
        statusIn.setEnabled(true);
        contactnumIn.setEnabled(true);
        emergencycontactIn.setEnabled(true);
        dateofempIn.setEnabled(true);
        designationIn.setEnabled(true);
        deptIn.setEnabled(true);
        probationIn.setEnabled(true);
        empTypeIn.setEnabled(true);
        empStatIn.setEnabled(true);
        shiftIn.setEnabled(true);
        attachBtn.setEnabled(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void addnewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewBtnActionPerformed
        enabledClear();
        saveBtn.setEnabled(true);
        editBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        surnameIn.requestFocus();
        
    }//GEN-LAST:event_addnewBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int p=JOptionPane.showConfirmDialog(null, "DELETE THIS DATA?" , "DELETE EMPLOYEE",JOptionPane.YES_NO_OPTION);
        if(p==0){
            try{
                String query="delete from EMPDATA where empid=?";
                pst=conn.prepareStatement(query);

                pst.setString(1,empIDIn.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null,"Employee DATA Deleted");

                clearDisabled();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            updateT();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        int row=empTable.getSelectedRow();
        String table_click=(empTable.getModel().getValueAt(row, 0).toString());

        try{

            String query="UPDATE EMPDATA SET empid='"+empIDIn.getText()+"' , surname='"+surnameIn.getText()+"' , firstname='"+fnameIn.getText()+"' , middlename='"+midNameIn.getText()+"' , gender='"+genderIn.getSelectedItem()+"' ,birthdate='"+((JTextField)bdateIn.getDateEditor().getUiComponent()).getText()+"',dateofemp='"+((JTextField)dateofempIn.getDateEditor().getUiComponent()).getText()+"', age='"+ageIn.getText()+"' , address='"+addressIn.getText()+"' , civilstatus='"+statusIn.getSelectedItem()+"' , contactnum='"+contactnumIn.getText()+"' , contactinemer='"+emergencycontactIn.getText()+"' , designation='"+designationIn.getText()+"' , department='"+deptIn.getText()+"' , probation='"+probationIn.getSelectedItem()+"' , employeetype='"+empTypeIn.getSelectedItem()+"' , employmentstatus='"+empStatIn.getSelectedItem()+"' , shift='"+shiftIn.getSelectedItem()+"', image=? where empid='"+table_click+"'";

            pst=conn.prepareStatement(query);
            
            pst.setBytes(1,pimage);
           
            pst.execute();

            JOptionPane.showMessageDialog(null,"DATA UPDATED");

            clearDisabled();

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }

        updateT();
        editBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearDisabled();
        updateT();
        saveBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        editBtn.setEnabled(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void surnameInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameInActionPerformed

    }//GEN-LAST:event_surnameInActionPerformed

    private void addressInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressInActionPerformed

    private void genderInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderInActionPerformed

    }//GEN-LAST:event_genderInActionPerformed

    private void statusInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusInActionPerformed

    private void contactnumInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnumInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactnumInActionPerformed

    private void emergencycontactInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergencycontactInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emergencycontactInActionPerformed

    private void attachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachBtnActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        ImageIcon icon=new ImageIcon(filename);
        picOut.setIcon(icon);
        
        try{
            File image=new File(filename);
            FileInputStream fis=new FileInputStream(image);
            
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
            byte [] buf=new byte[1024];
            for(int readNum;(readNum=fis.read(buf)) !=-1;){
                bos.write(buf,0,readNum);
            }
           pimage=bos.toByteArray(); 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

    }//GEN-LAST:event_attachBtnActionPerformed

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        
        
        try{
            int row=empTable.getSelectedRow();
            String table_click=(empTable.getModel().getValueAt(row, 0).toString());
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            disabled();

            String query="select * from EMPDATA where empid='"+table_click+"'";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();

            if(rs.next()){

                empIDIn.setText(rs.getString(1));
                surnameIn.setText(rs.getString(2));
                fnameIn.setText(rs.getString(3));
                midNameIn.setText(rs.getString(4));
                genderIn.setSelectedItem(rs.getString(5));
                bdateIn.setDate(rs.getDate(6));
                ageIn.setText(rs.getString(7));
                addressIn.setText(rs.getString(8));
                statusIn.setSelectedItem(rs.getString(9));
                contactnumIn.setText(rs.getString(10));
                emergencycontactIn.setText(rs.getString(11));
                designationIn.setText(rs.getString(12));
                deptIn.setText(rs.getString(13));
                probationIn.setSelectedItem(rs.getString(14));
                empTypeIn.setSelectedItem(rs.getString(15));
                empStatIn.setSelectedItem(rs.getString(16));
                shiftIn.setSelectedItem(rs.getString(17));
                dateofempIn.setDate(rs.getDate(18));
                
                if(rs.getBytes("image")==null){
                    ImageIcon II=new ImageIcon(getClass().getResource("DEFAULT.png"));
                    picOut.setIcon(II);
                }   
                else{
                byte[]imagedata=rs.getBytes("image");
                format=new ImageIcon(imagedata);
                picOut.setIcon(format);
                }
        }
  
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_empTableMouseClicked

    private void designationRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_designationRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(false);
        fnameRB.setSelected(false);
        empstatRB.setSelected(false);
        designationRB.setSelected(true);
        deptRB.setSelected(false);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(false);
    }//GEN-LAST:event_designationRBActionPerformed

    private void deptRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(false);
        fnameRB.setSelected(false);
        empstatRB.setSelected(false);
        designationRB.setSelected(false);
        deptRB.setSelected(true);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(false);
    }//GEN-LAST:event_deptRBActionPerformed

    private void surnameRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(true);
        fnameRB.setSelected(false);
        empstatRB.setSelected(false);
        designationRB.setSelected(false);
        deptRB.setSelected(false);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(false);
    }//GEN-LAST:event_surnameRBActionPerformed

    private void emptypeRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptypeRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(false);
        fnameRB.setSelected(false);
        empstatRB.setSelected(false);
        designationRB.setSelected(false);
        deptRB.setSelected(false);
        emptypeRB.setSelected(true);
        shiftRB.setSelected(false);
    }//GEN-LAST:event_emptypeRBActionPerformed

    private void shiftRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(false);
        fnameRB.setSelected(false);
        empstatRB.setSelected(false);
        designationRB.setSelected(false);
        deptRB.setSelected(false);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(true);
    }//GEN-LAST:event_shiftRBActionPerformed

    private void idRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idRBActionPerformed
        idRB.setSelected(true);
        surnameRB.setSelected(false);
        fnameRB.setSelected(false);
        empstatRB.setSelected(false);
        designationRB.setSelected(false);
        deptRB.setSelected(false);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(false);

    }//GEN-LAST:event_idRBActionPerformed

    private void empstatRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empstatRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(false);
        fnameRB.setSelected(false);
        empstatRB.setSelected(true);
        designationRB.setSelected(false);
        deptRB.setSelected(false);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(false);
    }//GEN-LAST:event_empstatRBActionPerformed

    private void fnameRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameRBActionPerformed
        idRB.setSelected(false);
        surnameRB.setSelected(false);
        fnameRB.setSelected(true);
        empstatRB.setSelected(false);
        designationRB.setSelected(false);
        deptRB.setSelected(false);
        emptypeRB.setSelected(false);
        shiftRB.setSelected(false);
    }//GEN-LAST:event_fnameRBActionPerformed

    private void searchInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchInMouseClicked
        searchIn.setText(null);
    }//GEN-LAST:event_searchInMouseClicked

    private void searchPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelMouseExited

    }//GEN-LAST:event_searchPanelMouseExited

    private void searchPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchPanelFocusGained

    }//GEN-LAST:event_searchPanelFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateT();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fnameInFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameInFocusGained
       if(surnameIn.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Please enter a surname.");
           surnameIn.requestFocus();
       }
    }//GEN-LAST:event_fnameInFocusGained

    private void midNameInFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_midNameInFocusGained
        if(surnameIn.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Please enter a surname.");
           surnameIn.requestFocus();
       }
        if(fnameIn.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter a firstname.");
            fnameIn.requestFocus();
        }
    }//GEN-LAST:event_midNameInFocusGained

    private void searchInKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInKeyReleased
       if(idRB.isSelected()==true){
                try {

                    String query="SELECT empid,surname,firstname FROM EMPDATA where empID LIKE ?";
                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }

                    searchTableClick();

                }

                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }

            }

            else if(surnameRB.isSelected()==true){
                try {

                    String query="SELECT empid,surname,firstname FROM EMPDATA where surname LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }
            
                    searchTableClick();

                }
                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }

            else if(fnameRB.isSelected()==true){
                try {

                    String query="SELECT empid,surname,firstname FROM EMPDATA where firstname LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();
                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }
               
                    searchTableClick();

                }
                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }

            else if(empstatRB.isSelected()==true){
                try {

                    String query="SELECT empid,employmentstatus,surname,firstname FROM EMPDATA where employmentstatus LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                
                    searchTableClick();

                }
                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }

            else if(designationRB.isSelected()==true){
                try {

                    String query="SELECT empid,designation,surname,firstname from EMPDATA where designation LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }


                    searchTableClick();

                }
                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }

            else if(deptRB.isSelected()==true){
                try {

                    String query="SELECT empid,surname,firstname,department FROM EMPDATA where department LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                 
                    searchTableClick();

                }
                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }
            else if(emptypeRB.isSelected()==true){
                try {

                    String query="SELECT empid,surname,firstname,employeetype FROM EMPDATA where employeetype LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                  

                    searchTableClick();

                }
                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }
            else if(shiftRB.isSelected()==true){
                try {

                    String query="SELECT empid,shift,surname,firstname FROM empdata where shift LIKE ?";

                    pst=conn.prepareStatement(query);

                    pst.setString(1, searchIn.getText()+"%");

                    rs=pst.executeQuery();
                    empTable.setModel(DbUtils.resultSetToTableModel(rs));

                    rs=pst.executeQuery();

                    if(rs.next()) {
                        rs=pst.executeQuery();
                        empTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                  

                    searchTableClick();
                }

                catch(SQLException err)   {
                    JOptionPane.showMessageDialog(null, err);
                }
            }
     
    }//GEN-LAST:event_searchInKeyReleased

    private void searchInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnewBtn;
    private javax.swing.JTextField addressIn;
    private javax.swing.JTextField ageIn;
    private javax.swing.JButton attachBtn;
    private javax.swing.JPanel basicInfoPanel;
    private com.toedter.calendar.JDateChooser bdateIn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel companyDepPanel;
    private javax.swing.JTextField contactnumIn;
    private com.toedter.calendar.JDateChooser dateofempIn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField deptIn;
    private javax.swing.JRadioButton deptRB;
    private javax.swing.JTextField designationIn;
    private javax.swing.JRadioButton designationRB;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emergencycontactIn;
    private javax.swing.JTextField empIDIn;
    private javax.swing.JComboBox empStatIn;
    private javax.swing.JTable empTable;
    private javax.swing.JComboBox empTypeIn;
    private javax.swing.JLabel employeestatusInput;
    private javax.swing.JLabel employeestatusInput1;
    private javax.swing.JLabel employeetypeInput;
    private javax.swing.JRadioButton empstatRB;
    private javax.swing.JRadioButton emptypeRB;
    private javax.swing.JTextField fnameIn;
    private javax.swing.JRadioButton fnameRB;
    private javax.swing.JComboBox genderIn;
    private javax.swing.JRadioButton idRB;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField midNameIn;
    private javax.swing.JLabel picOut;
    private javax.swing.JComboBox probationIn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchIn;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JComboBox shiftIn;
    private javax.swing.JRadioButton shiftRB;
    private javax.swing.JComboBox statusIn;
    private javax.swing.JTextField surnameIn;
    private javax.swing.JRadioButton surnameRB;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
private ImageIcon format=null;
String filename=null;
int s=0;
byte[] pimage=null;
    
}
