package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import corejavaproject.dbtask.CrudOperation;
import java.sql.*;
public class AddDriver extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private JTextField txtage;
	private JTextField txtgender;
	private JTextField txtaddress;
	private Connection con;
	private PreparedStatement psadd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDriver frame = new AddDriver();
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
	public AddDriver() {
		setTitle("Add Driver");
		con=CrudOperation.createConnection();
createGui();		
	}
	private void createGui()
	{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1077, 758);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setLocationRelativeTo(null);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("DriverId");
	lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel.setBounds(130, 141, 115, 27);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_1.setBounds(130, 194, 115, 27);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Email");
	lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_2.setBounds(130, 255, 115, 27);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("PhoneNo");
	lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_3.setBounds(130, 315, 115, 27);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Age");
	lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_4.setBounds(130, 375, 115, 27);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Gender");
	lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_5.setBounds(130, 427, 115, 27);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Address");
	lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_6.setBounds(130, 480, 115, 27);
	contentPane.add(lblNewLabel_6);
	
	txtid = new JTextField();
	txtid.setBounds(388, 141, 194, 26);
	contentPane.add(txtid);
	txtid.setColumns(10);
	
	txtname = new JTextField();
	txtname.setBounds(388, 194, 194, 26);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	txtmail = new JTextField();
	txtmail.setBounds(388, 255, 194, 26);
	contentPane.add(txtmail);
	txtmail.setColumns(10);
	
	txtphone = new JTextField();
	txtphone.setBounds(388, 315, 194, 26);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	txtage = new JTextField();
	txtage.setBounds(388, 375, 194, 26);
	contentPane.add(txtage);
	txtage.setColumns(10);
	
	txtgender = new JTextField();
	txtgender.setBounds(388, 427, 194, 26);
	contentPane.add(txtgender);
	txtgender.setColumns(10);
	
	txtaddress = new JTextField();
	txtaddress.setBounds(388, 480, 194, 26);
	contentPane.add(txtaddress);
	txtaddress.setColumns(10);
	
	
	
	JButton btnAdd = new JButton("Add");
	btnAdd.addActionListener(this);
	btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	
	btnAdd.setBounds(290, 556, 115, 43);
	contentPane.add(btnAdd);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id=txtid.getText();
		String name=txtname.getText();
		String mail=txtmail.getText();
		String phone=txtphone.getText();
		String age=txtage.getText();
		String gender=txtgender.getText();
		String address=txtaddress.getText();		
		if(id.isEmpty()||name.isEmpty()||mail.isEmpty()||phone.isEmpty()||age.isEmpty()||gender.isEmpty()||address.isEmpty())
			JOptionPane.showMessageDialog(this, "Data Reqiured");
		else
		{
			
		
				try {
					String strinsert="insert into driverdetails values(?,?,?,?,?,?,?)";
					psadd=con.prepareStatement(strinsert);
					psadd.setString(1,id);
					psadd.setString(2, name);  
					psadd.setString(3, mail);
					psadd.setString(4, phone);
					psadd.setString(5, age);
					psadd.setString(6, gender);
					psadd.setString(7, address);
					System.out.println(psadd);
					
					int row=psadd.executeUpdate();//insert/update/delete
					if(row>0)
					{
						JOptionPane.showMessageDialog(this, "record added");
					txtid.setText("");
					txtname.setText("");
					txtphone.setText("");
					txtmail.setText("");
					txtage.setText("");
					txtgender.setText("");
					txtaddress.setText("");
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