/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class TrainSystem extends javax.swing.JFrame {

    /**
     * Creates new form TrainSystem
     */
    public TrainSystem() {
        initComponents();
        groupButton();
    }
    
private void groupButton( ) {

ButtonGroup bg1 = new ButtonGroup( );
bg1.add(jRadioButtonStd);
bg1.add(jRadioButtonEco);
bg1.add(jRadioButtonFclass);

ButtonGroup bg2 = new ButtonGroup( );
bg2.add(jRadioButtonOneway);
bg2.add(jRadioButtonReturn);

ButtonGroup bg3 = new ButtonGroup( );
bg3.add(jRadioButtonAdultYes);
bg3.add(jRadioButtonChildYes);


}

 public Connection getConnection() {
        Connection con =null;
        try{
            
        
        con =    (Connection) DriverManager.getConnection("jdbc:mysql://localhost/train_db", "root", "Ray-07767767");
        //JOptionPane.showMessageDialog(null,"Connected");
        return con;
        
        
        
    }catch (SQLException ex ){
        Logger.getLogger(TrainSystem.class.getName()).log(Level.SEVERE,null,ex);
        JOptionPane.showMessageDialog(null,"Not Connected");
        return con;
    }
    }
 
 public boolean checkInputs(){
        if(
         jtxtLastName.getText()==null
         ||jtxtAdult.getText()==null
         ||jtxtChild.getText()==null
         ||jtxtFrom.getText()==null
         ||jtxtTo.getText()==null
         ||jtxtClass.getText()==null
         ||jtxtTicketType.getText()==null
         ||jtxtTicketNo.getText()==null
         ||jtxtDate.getText()==null
         ||jtxtTime.getText()==null
         ||jtxtPrice.getText()==null 
         ||jtxtSubTotal.getText()==null
         ||jtxtTax.getText()==null)       
                
            
        {
            return false;
        }
        else{
            try{
                Float.parseFloat(jtxtPrice.getText());
                return true;
        }catch(Exception ex){
            return false;
        }
    }
 }
 
 public ArrayList<Train> getTrainList(){
        
        ArrayList<Train> trainList = new ArrayList<>();
        Connection con = getConnection();
        String query ="SELECT * FROM trainhani";
        
        Statement st;
        ResultSet rs;
        
        try{
            
            st =  con.createStatement();
            rs = st.executeQuery(query);
            Train train;
            
            while (rs.next())
            {
             train = new Train(
                            rs.getString("first_name"),rs.getString("last_name"),rs.getString("adult"),rs.getString("child"),
                            rs.getString("frm"),rs.getString("tu"),rs.getString("class"),rs.getString("ticket_type"),rs.getInt("ticket_number"),
                            rs.getString("date"),rs.getString("time"),Double.parseDouble(rs.getString("price")),Double.parseDouble(rs.getString("sub_total")),
                            Double.parseDouble(rs.getString("tax")));
             
                trainList.add(train);
            }
            
            
        }catch(SQLException ex){
                Logger.getLogger(TrainSystem.class.getName()).log(Level.SEVERE, null,ex);
            }
        
        return trainList;
        
    }
 
 
 public void Show_Product_In_JTable (){
        
        ArrayList<Train> list = getTrainList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[14];
        for (int i=0;i < list.size();i++)
        {
            row[0]=list.get(i).getFname();
            row[1]=list.get(i).getLname();
            row[2]=list.get(i).getAdult();
            row[3]=list.get(i).getChild();
            row[4]=list.get(i).getFrom();
            row[5]=list.get(i).getTo();
            row[6]=list.get(i).getClasss();
            row[7]=list.get(i).getTicketType();
            row[8]=list.get(i).getTicketNumber();
            row[9]=list.get(i).getDate();
            row[10]=list.get(i).getTime();
            row[11]=list.get(i).getPrice();
            row[12]=list.get(i).getSub_Total();
            row[13]=list.get(i).getTax();
                    
            
            model.addRow(row);
        }
        
    }
 
 
  public void ShowItem(int index){
      
        jtxtFirstName.setText (getTrainList().get(index).getFname());
        jtxtLastName.setText (getTrainList().get(index).getLname());
        jtxtAdult.setText (getTrainList().get(index).getAdult());
        jtxtChild.setText (getTrainList().get(index).getChild());
        jtxtFrom.setText (getTrainList().get(index).getFrom());
        jtxtTo.setText (getTrainList().get(index).getTo());
        jtxtClass.setText (getTrainList().get(index).getClasss());
        jtxtTicketType.setText (getTrainList().get(index).getTicketType());
        jtxtTicketNo.setText(Integer.toString(getTrainList().get(index).getTicketNumber()));
        jtxtPrice.setText(Double.toString(getTrainList().get(index).getPrice()));
        jtxtDate.setText (getTrainList().get(index).getDate());
        
        jtxtTime.setText (getTrainList().get(index).getTime());
        jtxtSubTotal.setText(Double.toString(getTrainList().get(index).getSub_Total()));
        jtxtTax.setText(Double.toString(getTrainList().get(index).getTax()));
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonStd = new javax.swing.JRadioButton();
        jRadioButtonEco = new javax.swing.JRadioButton();
        jRadioButtonFclass = new javax.swing.JRadioButton();
        jRadioButtonOneway = new javax.swing.JRadioButton();
        jRadioButtonAdultYes = new javax.swing.JRadioButton();
        jRadioButtonChildYes = new javax.swing.JRadioButton();
        jRadioButtonReturn = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jtxtFirstName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtxtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtFrom = new javax.swing.JTextField();
        jtxtTicketType = new javax.swing.JTextField();
        jtxtAdult = new javax.swing.JTextField();
        jtxtChild = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jtxtClass = new javax.swing.JTextField();
        jtxtTo = new javax.swing.JTextField();
        jtxtDate = new javax.swing.JTextField();
        jtxtRoute = new javax.swing.JTextField();
        jtxtTicketNo = new javax.swing.JTextField();
        jtxtPrice = new javax.swing.JTextField();
        jtxtTime = new javax.swing.JTextField();
        jtxtError = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtSubTotal = new javax.swing.JTextField();
        jtxtTax = new javax.swing.JTextField();
        jtxtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtxtSum = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Class");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Ticket type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Adult");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Child");

        jRadioButtonStd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonStd.setText("Standard");

        jRadioButtonEco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonEco.setText("Economy");

        jRadioButtonFclass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonFclass.setText("First Class");

        jRadioButtonOneway.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonOneway.setText("One way");

        jRadioButtonAdultYes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonAdultYes.setText("Yes");
        jRadioButtonAdultYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdultYesActionPerformed(evt);
            }
        });

        jRadioButtonChildYes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonChildYes.setText("Yes");

        jRadioButtonReturn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonReturn.setText("Return");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("FirstName");

        jtxtFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("LastName");

        jtxtLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Destination");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Add City", "Saida", "Tyre", "Nabateih", "baalbak", "Bekaa", "Trablus", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonStd)
                            .addComponent(jRadioButtonEco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButtonOneway)
                            .addComponent(jRadioButtonReturn)))
                    .addComponent(jRadioButtonFclass))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addGap(70, 70, 70)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonAdultYes)
                            .addComponent(jLabel3))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jRadioButtonChildYes))
                        .addGap(166, 166, 166))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButtonStd)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonEco)
                            .addComponent(jRadioButtonReturn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonFclass)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonOneway)
                            .addComponent(jRadioButtonAdultYes)
                            .addComponent(jRadioButtonChildYes))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Class");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ticket type");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Adult");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Child");

        jtxtFrom.setEditable(false);
        jtxtFrom.setBackground(new java.awt.Color(204, 204, 204));
        jtxtFrom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtTicketType.setEditable(false);
        jtxtTicketType.setBackground(new java.awt.Color(204, 204, 204));
        jtxtTicketType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtAdult.setEditable(false);
        jtxtAdult.setBackground(new java.awt.Color(204, 204, 204));
        jtxtAdult.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtChild.setEditable(false);
        jtxtChild.setBackground(new java.awt.Color(204, 204, 204));
        jtxtChild.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Route");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Price");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Time");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Ticket No.");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Date");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("To");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("From");

        jtxtClass.setEditable(false);
        jtxtClass.setBackground(new java.awt.Color(204, 204, 204));
        jtxtClass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtTo.setEditable(false);
        jtxtTo.setBackground(new java.awt.Color(204, 204, 204));
        jtxtTo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtDate.setEditable(false);
        jtxtDate.setBackground(new java.awt.Color(204, 204, 204));
        jtxtDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtRoute.setEditable(false);
        jtxtRoute.setBackground(new java.awt.Color(204, 204, 204));
        jtxtRoute.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtTicketNo.setEditable(false);
        jtxtTicketNo.setBackground(new java.awt.Color(204, 204, 204));
        jtxtTicketNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtPrice.setEditable(false);
        jtxtPrice.setBackground(new java.awt.Color(204, 204, 204));
        jtxtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtTime.setEditable(false);
        jtxtTime.setBackground(new java.awt.Color(204, 204, 204));
        jtxtTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtError.setEditable(false);
        jtxtError.setBackground(new java.awt.Color(204, 204, 204));
        jtxtError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jtxtClass, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtxtTicketType, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtxtAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtChild, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtTo)
                            .addComponent(jtxtDate)
                            .addComponent(jtxtTime)
                            .addComponent(jtxtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(122, 122, 122))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtxtRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(40, 40, 40)
                                            .addComponent(jtxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jtxtTicketNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jtxtError)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTicketType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jtxtTicketNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14)
                    .addComponent(jtxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13)
                    .addComponent(jtxtRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtError, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Sub Total");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tax");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total");

        jtxtSubTotal.setEditable(false);
        jtxtSubTotal.setBackground(new java.awt.Color(204, 204, 204));
        jtxtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtTax.setEditable(false);
        jtxtTax.setBackground(new java.awt.Color(204, 204, 204));
        jtxtTax.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtxtTotal.setEditable(false);
        jtxtTotal.setBackground(new java.awt.Color(204, 204, 204));
        jtxtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Total");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtxtSum.setEditable(false);
        jtxtSum.setBackground(new java.awt.Color(204, 204, 204));
        jtxtSum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Total Price");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(91, 91, 91)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTax, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jtxtSum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtxtSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtxtTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FirstName", "LastName", "Adult", "Child", "From", "To", "Class", "TicketType", "TicketNo", "Date", "Time", "Price", "SubTotal", "Tax"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Insert");
        jButton7.setMaximumSize(new java.awt.Dimension(115, 23));
        jButton7.setMinimumSize(new java.awt.Dimension(115, 23));
        jButton7.setPreferredSize(new java.awt.Dimension(115, 23));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Update to db");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Delete");
        jButton9.setMaximumSize(new java.awt.Dimension(115, 23));
        jButton9.setMinimumSize(new java.awt.Dimension(115, 23));
        jButton9.setPreferredSize(new java.awt.Dimension(115, 23));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Adimn");

        jMenuItem1.setText("Admin Login");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonAdultYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdultYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAdultYesActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         
        Show_Product_In_JTable ();
        this.getContentPane().setBackground(Color.CYAN);
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          if ( JOptionPane.showConfirmDialog(new JFrame(), 
       "Are you sure you want to exit this session.", 
       "Exitting Window", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 

          System.out.println("Should Exit: " + WindowConstants.DISPOSE_ON_CLOSE); 
          System.exit(WindowConstants.DISPOSE_ON_CLOSE); 
      } 
      else { 
      
          System.out.println("Should not Exit: " + WindowConstants.DISPOSE_ON_CLOSE); 
          return; 
      }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        jtxtSubTotal.setText(null);
        jtxtTax.setText(null);
        jtxtTotal.setText(null);
        jtxtClass.setText(null);
        jtxtTicketType.setText(null);
        jtxtAdult.setText(null);
        jtxtChild.setText(null);
        jtxtFrom.setText(null);
        jtxtTo.setText(null);
        jtxtDate.setText(null);
        jtxtTime.setText(null);
        jtxtTicketNo.setText(null);
        jtxtPrice.setText(null);
        jtxtRoute.setText(null);
        jtxtFirstName.setText(null);
        jtxtLastName.setText(null);
        jtxtSum.setText(null);
        jComboBox1.setSelectedItem("Add City");
        jRadioButtonStd.setSelected(false);
        jRadioButtonEco.setSelected(false);
        jRadioButtonFclass.setSelected(false);
        jRadioButtonOneway.setSelected(false);
        jRadioButtonReturn.setSelected(false);
        jRadioButtonAdultYes.setSelected(false);
        jRadioButtonChildYes.setSelected(false);
        
        
                
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Calendar timer = Calendar.getInstance();
            timer.getTime();
            SimpleDateFormat Tdate = new SimpleDateFormat("YYYY-MM-dd");
            jtxtDate.setText(Tdate.format(timer.getTime()));
             SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
             jtxtTime.setText(sdf.format(timer.getTime()));
             
             int num1;
            String OrderRefNo = "";
            num1 = 1325 +(int) (Math.random() *4238);
            OrderRefNo +=num1 +1325;
            jtxtTicketNo.setText(OrderRefNo);
            
            jtxtFrom.setText("Beirut");
            
            jtxtTo.setText((String)jComboBox1.getSelectedItem());
            jtxtRoute.setText("ANT");
            


            double Tax = 19.50;
            double MilesSaida = 25.78;
            double MilesTyre = 35.22;
            double MilesNabateih = 45.23;
            double MilesBaalbak = 55.98;
            double totalCost,eco = 3.85,fclass = 5.60;
            
//============================================================ Saida Standard ====================================================================            
            
            if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * MilesSaida)/100;
                String tax = String.format(" %.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesSaida + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida * 2 );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format(".2f",((MilesSaida  * 2)+ totalCost) );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida -18  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesSaida -18) + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesSaida-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesSaida -18 )* 2 + totalCost)  );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
 //========================================================  Saida  Economic  =====================================================================================           
            if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * MilesSaida)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida+eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesSaida + totalCost+eco );
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida * 2 +eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesSaida+eco ) * 2 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida -18+eco  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesSaida+eco)-18 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesSaida +eco-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesSaida-18) * 2) + totalCost+eco) ;
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
  
            
 //=====================================================Saida First Class ===========================================================================         
            if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * MilesSaida)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida+fclass );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesSaida + totalCost+fclass );
                jtxtTotal.setText(Total);
                jtxtClass.setText("FirstClass");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesSaida+fclass) * 2  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesSaida +fclass)* 2+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesSaida -18+fclass  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesSaida-18+fclass)+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Saida")))
            {
                totalCost =(Tax * (MilesSaida)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesSaida +fclass-18) * 2);
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesSaida +fclass-18) * 2 +totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            //============================================================ Tyre Standard ==================================================================== 
            
            
            
            
            if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * MilesTyre)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesTyre + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre * 2 );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesTyre  * 2)+ totalCost) );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre -18  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesTyre -18) + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesTyre-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesTyre -18 )* 2 + totalCost)  );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
 //========================================================  Tyre Economic  =====================================================================================           
            if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * MilesTyre)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre+eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesTyre + totalCost+eco );
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre * 2 +eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesTyre+eco ) * 2 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre -18+eco  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesTyre+eco)-18 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesTyre +eco-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesTyre-18) * 2) + totalCost+eco) ;
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
  
            
 //=====================================================Tyre First Class ===========================================================================         
            if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * MilesTyre)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre+fclass );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesTyre + totalCost+fclass );
                jtxtTotal.setText(Total);
                jtxtClass.setText("FirstClass");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesTyre+fclass) * 2  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesTyre +fclass)* 2+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesTyre -18+fclass  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesTyre-18+fclass)+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Tyre")))
            {
                totalCost =(Tax * (MilesTyre)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesTyre +fclass-18) * 2);
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesTyre +fclass-18) * 2 +totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            
            
            
            
            
            
            
            //============================================================ Nabateih Standard ==================================================================== 
            
            
            
            
            if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * MilesNabateih)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesNabateih + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih * 2 );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesNabateih  * 2)+ totalCost) );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih -18  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesNabateih -18) + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesNabateih-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesNabateih -18 )* 2 + totalCost)  );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
 //========================================================  Nabateih Economic  =====================================================================================           
            if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * MilesNabateih)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih+eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesNabateih + totalCost+eco );
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih * 2 +eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesNabateih+eco ) * 2 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih -18+eco  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesNabateih+eco)-18 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesNabateih +eco-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesNabateih-18) * 2) + totalCost+eco) ;
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
  
            
 //=====================================================NabateihFirst Class ===========================================================================         
            if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * MilesNabateih)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih+fclass );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesNabateih + totalCost+fclass );
                jtxtTotal.setText(Total);
                jtxtClass.setText("FirstClass");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesNabateih+fclass) * 2  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesNabateih +fclass)* 2+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesNabateih -18+fclass  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesNabateih-18+fclass)+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("Nabateih")))
            {
                totalCost =(Tax * (MilesNabateih)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesNabateih +fclass-18) * 2);
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesNabateih +fclass-18) * 2 +totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            
            
            
              
            
            
            
            //============================================================ Baalbak Standard ==================================================================== 
            
            
            
            
            if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * MilesBaalbak)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesBaalbak + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak * 2 );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesBaalbak  * 2)+ totalCost) );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak -18  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesBaalbak -18) + totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonStd.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesBaalbak-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesBaalbak -18 )* 2 + totalCost)  );
                jtxtTotal.setText(Total);
                jtxtClass.setText("STN");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
 //========================================================  Baalbak Economic  =====================================================================================           
            if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * MilesBaalbak)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak+eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesBaalbak + totalCost+eco );
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak * 2 +eco );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesBaalbak+eco ) * 2 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak -18+eco  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesBaalbak+eco)-18 + totalCost);
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonEco.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesBaalbak +eco-18) * 2) ;
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",((MilesBaalbak-18) * 2) + totalCost+eco) ;
                jtxtTotal.setText(Total);
                jtxtClass.setText("Eco");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
  
            
 //===================================================== Baalbak First Class ===========================================================================         
            if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * MilesBaalbak)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak+fclass );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",MilesBaalbak + totalCost+fclass );
                jtxtTotal.setText(Total);
                jtxtClass.setText("FirstClass");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonAdultYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesBaalbak+fclass) * 2  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesBaalbak +fclass)* 2+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("Yes");
                jtxtChild.setText("No");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonOneway.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak))/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",MilesBaalbak -18+fclass  );
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesBaalbak-18+fclass)+ totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("OneWay");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            else if((jRadioButtonFclass.isSelected()) && (jRadioButtonReturn.isSelected()) && (jRadioButtonChildYes.isSelected()) 
                    &&(jComboBox1.getSelectedItem().equals("baalbak")))
            {
                totalCost =(Tax * (MilesBaalbak)*2)/100;
                String tax = String.format("%.2f", totalCost);
                jtxtTax.setText(tax);
                String Subtotal = String.format("%.2f",(MilesBaalbak +fclass-18) * 2);
                jtxtSubTotal.setText(Subtotal);
                String Total = String.format("%.2f",(MilesBaalbak +fclass-18) * 2 +totalCost );
                jtxtTotal.setText(Total);
                jtxtClass.setText("First Class");
                jtxtTicketType.setText("Return");
                jtxtAdult.setText("No");
                jtxtChild.setText("Yes");
                jtxtPrice.setText(Total);
            }
            
            
            
            
            

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        jtxtFirstName.setText(model.getValueAt(jTable1.getSelectedRow(),0).toString());
        jtxtLastName.setText(model.getValueAt(jTable1.getSelectedRow(),1).toString());
        jtxtAdult.setText(model.getValueAt(jTable1.getSelectedRow(),2).toString());
        jtxtChild.setText(model.getValueAt(jTable1.getSelectedRow(),3).toString());
        jtxtFrom.setText(model.getValueAt(jTable1.getSelectedRow(),4).toString());
        jtxtTo.setText(model.getValueAt(jTable1.getSelectedRow(),5).toString());
        jtxtClass.setText(model.getValueAt(jTable1.getSelectedRow(),6).toString());
        
        jtxtTicketType.setText(model.getValueAt(jTable1.getSelectedRow(),7).toString());
        jtxtTicketNo.setText(model.getValueAt(jTable1.getSelectedRow(),8).toString());
        jtxtDate.setText(model.getValueAt(jTable1.getSelectedRow(),9).toString());
        jtxtTime.setText(model.getValueAt(jTable1.getSelectedRow(),10).toString());
        jtxtPrice.setText(model.getValueAt(jTable1.getSelectedRow(),11).toString());
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      
        if(checkInputs() && jtxtFirstName.getText() !=null)
        {
            Connection con = getConnection();
            try {
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO trainhani(first_name,last_name,adult,child,frm,tu,class,ticket_type,ticket_number,date,time,price,sub_total,tax)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                ps.setString(1,jtxtFirstName.getText());
                ps.setString(2,jtxtLastName.getText());
                ps.setString(3,jtxtAdult.getText());
                ps.setString(4,jtxtChild.getText());
                ps.setString(5,jtxtFrom.getText());
                ps.setString(6,jtxtTo.getText());
                ps.setString(7,jtxtClass.getText());
                ps.setString(8,jtxtTicketType.getText());
                ps.setString(9,jtxtTicketNo.getText());
                ps.setString(10,jtxtDate.getText());
                ps.setString(11,jtxtTime.getText());
                ps.setString(12,jtxtPrice.getText());
                ps.setString(13,jtxtSubTotal.getText());
                ps.setString(14,jtxtTax.getText());
                
                ps.executeUpdate();
                
                
                Show_Product_In_JTable();
                 
                JOptionPane.showMessageDialog(null,"Data is Inserted!! ");
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"One or more Field are Empty!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
        if (checkInputs() && jtxtTicketNo.getText() !=null)
        {
            
           
            Connection con = getConnection();
            
            
            
            
                try{
                    
                PreparedStatement ps = con.prepareStatement ("UPDATE trainhani SET  last_name = ?, adult = ?, child = ?,frm = ?, tu = ?,class = ?, ticket_type = ?, ticket_number = ?, price = ?, time = ?, date = ?,sub_total = ? , tax = ? WHERE first_name = ?" );
                
               
                ps.setString(1,jtxtLastName.getText());
                ps.setString(2,jtxtAdult.getText());
                ps.setString(3,jtxtChild.getText());
                ps.setString(4,jtxtFrom.getText());
                ps.setString(5,jtxtTo.getText());
                ps.setString(6,jtxtClass.getText());
                ps.setString(7,jtxtTicketType.getText());
                ps.setString(8,jtxtTicketNo.getText());
                ps.setString(9,jtxtPrice.getText());
                ps.setString(10,jtxtTime.getText());
                ps.setString(11,jtxtDate.getText());
                ps.setString(12,jtxtSubTotal.getText());
                ps.setString(13,jtxtTax.getText());
                
                ps.setString(14,jtxtFirstName.getText());
                ps.executeUpdate();
                Show_Product_In_JTable();
                
                JOptionPane.showMessageDialog(null,"Data is Updated!! ");
                
                
            }catch(SQLException ex){
                Logger.getLogger(TrainSystem.class.getName()).log(Level.SEVERE, null,ex);
                
            }
        }     
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
         if (!jtxtFirstName.getText().equals("") )
        {
           
            
                try{
                     
                     
                    Connection con = getConnection();
                    PreparedStatement ps = con.prepareStatement ("DELETE FROM trainhani WHERE first_name = ?") ;
                     
                
                     ps.setString(1,jtxtFirstName.getText());
                     ps.executeUpdate();
                     Show_Product_In_JTable();
                     
                   
                     
                     JOptionPane.showMessageDialog(null,"Data Deleted!! ");
                
            }catch(SQLException ex){
                Logger.getLogger(TrainSystem.class.getName()).log(Level.SEVERE, null,ex);
                JOptionPane.showMessageDialog(null,"Data Not Deleted!! ");
            }
            
               
         
        } else  {
    JOptionPane.showMessageDialog(null, "Enter only ID number: Product not deleted!");
}
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int index = jTable1.getSelectedRow();
       ShowItem(index);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        double sum = 0.0;
        try{
            
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT SUM(price) FROM trainhani");
        
    while (res.next()) {
      double c = res.getDouble(1);
      sum = sum + c;
      String Sum = String.format("%.2f", sum);
      jtxtSum.setText(Sum);
      
      }
        }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        
         if ( JOptionPane.showConfirmDialog(new JFrame(), 
       "Are you sure you want to exit this session.", 
       "Exitting Window", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 

          System.out.println("Should Exit: " + WindowConstants.DISPOSE_ON_CLOSE); 
          System.exit(WindowConstants.DISPOSE_ON_CLOSE); 
      } 
      else { 
      
          System.out.println("Should not Exit: " + WindowConstants.DISPOSE_ON_CLOSE); 
          return; 
      }
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(TrainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButtonAdultYes;
    private javax.swing.JRadioButton jRadioButtonChildYes;
    private javax.swing.JRadioButton jRadioButtonEco;
    private javax.swing.JRadioButton jRadioButtonFclass;
    private javax.swing.JRadioButton jRadioButtonOneway;
    private javax.swing.JRadioButton jRadioButtonReturn;
    private javax.swing.JRadioButton jRadioButtonStd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxtAdult;
    private javax.swing.JTextField jtxtChild;
    private javax.swing.JTextField jtxtClass;
    private javax.swing.JTextField jtxtDate;
    private javax.swing.JTextField jtxtError;
    private javax.swing.JTextField jtxtFirstName;
    private javax.swing.JTextField jtxtFrom;
    private javax.swing.JTextField jtxtLastName;
    private javax.swing.JTextField jtxtPrice;
    private javax.swing.JTextField jtxtRoute;
    private javax.swing.JTextField jtxtSubTotal;
    private javax.swing.JTextField jtxtSum;
    private javax.swing.JTextField jtxtTax;
    private javax.swing.JTextField jtxtTicketNo;
    private javax.swing.JTextField jtxtTicketType;
    private javax.swing.JTextField jtxtTime;
    private javax.swing.JTextField jtxtTo;
    private javax.swing.JTextField jtxtTotal;
    // End of variables declaration//GEN-END:variables
}
