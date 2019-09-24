package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

public class LabourDetails extends JFrame implements ActionListener
{

	private JPanel contentPane;
	
	private JTextField txtlid;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtaddress;
	private JTextField txtgender;
	private JTextField txtage;
	private JTextField txtwid;
	private Connection con;
	private PreparedStatement psadd;
	private JTextField txtstatus;
	private JDateChooser dc1,dc2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabourDetails frame = new LabourDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LabourDetails() {
		createGui();
		
	}
private void createGui()
{
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1551, 838);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);	

	JLabel lblNewLabel = new JLabel("LId");
	lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel.setBounds(130, 141, 115, 27);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_1.setBounds(130, 194, 115, 27);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("WorkerId");
	lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_2.setBounds(130, 479, 115, 27);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("PhoneNo");
	lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_3.setBounds(130, 254, 115, 27);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Age");
	lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_4.setBounds(130, 426, 115, 27);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Gender");
	lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_5.setBounds(130, 374, 115, 27);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Address");
	lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_6.setBounds(130, 314, 115, 27);
	contentPane.add(lblNewLabel_6);
	
	txtlid = new JTextField();
	txtlid.setBounds(388, 141, 194, 26);
	contentPane.add(txtlid);
	txtlid.setColumns(10);
	
	txtname = new JTextField();
	txtname.setBounds(388, 194, 194, 26);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	txtphone = new JTextField();
	txtphone.setBounds(388, 255, 194, 26);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	txtaddress = new JTextField();
	txtaddress.setBounds(388, 315, 194, 26);
	contentPane.add(txtaddress);
	txtaddress.setColumns(10);
	
	txtgender = new JTextField();
	txtgender.setBounds(388, 375, 194, 26);
	contentPane.add(txtgender);
	txtgender.setColumns(10);
	
	txtage = new JTextField();
	txtage.setBounds(388, 427, 194, 26);
	contentPane.add(txtage);
	txtage.setColumns(10);
	
	txtwid = new JTextField();
	txtwid.setBounds(388, 480, 194, 26);
	contentPane.add(txtwid);
	txtwid.setColumns(10);
	
	
	
	JButton btnAdd = new JButton("Add");
	btnAdd.addActionListener(this);
	btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	
	btnAdd.setBounds(256, 706, 115, 43);
	contentPane.add(btnAdd);
	
	JLabel lblNewLabel_7 = new JLabel("DateOfJoining");
	lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	lblNewLabel_7.setBounds(95, 543, 150, 27);
	contentPane.add(lblNewLabel_7);
	
	JLabel lblNewLabel_8 = new JLabel("DateOfLeaving");
	lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	lblNewLabel_8.setBounds(95, 602, 150, 27);
	contentPane.add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel("Status");
	lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	lblNewLabel_9.setBounds(130, 658, 115, 27);
	contentPane.add(lblNewLabel_9);
	
	 dc1 = new JDateChooser();
	  dc1.setDateFormatString("yyyy-MM-dd");
	dc1.setBounds(388, 543, 194, 27);
	contentPane.add(dc1);
	
	 dc2 = new JDateChooser();
	  dc1.setDateFormatString("yyyy-MM-dd");
	dc2.setBounds(388, 602, 194, 27);
	contentPane.add(dc2);
	
	txtstatus = new JTextField();
	txtstatus.setBounds(388, 658, 194, 27);
	contentPane.add(txtstatus);
	txtstatus.setColumns(10);
}

@Override
public void actionPerformed(ActionEvent e) {
	String lid=txtlid.getText();
	String name=txtname.getText();
	String phone=txtphone.getText();
	String address=txtaddress.getText();
	String gender=txtgender.getText();
	String age=txtage.getText();
	String wid=txtwid.getText();	
	String status=txtstatus.getText();
	java.util.Date d1=dc1.getDate();
	java.util.Date d2=dc2.getDate();
	if(lid.isEmpty()||name.isEmpty()||wid.isEmpty()||phone.isEmpty()||age.isEmpty()||gender.isEmpty()||address.isEmpty()||status.isEmpty()||dc1==null||dc2==null)
		JOptionPane.showMessageDialog(this, "Data Reqiured");
	else
	{
		long date1 =d1.getTime();
		java.sql.Date sd1=new java.sql.Date(date1);
		long date2 =d2.getTime();
		java.sql.Date sd2=new java.sql.Date(date2);
	
			try {
				String strinsert="insert into Labourdetails values(?,?,?,?,?,?,?,?,?,?)";
				psadd=con.prepareStatement(strinsert);
				psadd.setString(1,lid);
				psadd.setString(2, name);  
				psadd.setString(3, phone);
				psadd.setString(4, address);
				psadd.setString(5, gender);
				psadd.setString(6, age);
				psadd.setString(7, wid);
				psadd.setDate(8, sd1);
				psadd.setDate(9, sd2);
				psadd.setString(10, status);
				System.out.println(psadd);
				
				int row=psadd.executeUpdate();//insert/update/delete
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "record added");
				txtlid.setText("");
				txtname.setText("");
				txtaddress.setText("");
				txtphone.setText("");
				txtgender.setText("");
				txtage.setText("");
				txtwid.setText("");
				txtstatus.setText("");
				}
				
				
				
				
			}catch (SQLException se) {
System.out.println(se);
			}
			
			finally {
				
				try {
					if(psadd!=null)
						psadd.close();
				}
				catch(SQLException se) {System.out.println(se);}
				
			}
			
	}	
}
}
