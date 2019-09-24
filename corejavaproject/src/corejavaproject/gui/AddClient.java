package corejavaproject.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

import corejavaproject.dbtask.CrudOperation;

import javax.swing.JButton;
import java.sql.*;
public class AddClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private JTextField txtaddress;
	
	private Connection con;
	private PreparedStatement psadd1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClient frame = new AddClient();
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
	public AddClient() {
		setTitle("Add Client");
		con=CrudOperation.createConnection();
		createGui();
		
	}
private void createGui()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1183, 747);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel id = new JLabel("CLIENT ID");
	id.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	id.setBounds(125, 62, 156, 34);
	contentPane.add(id);
	JLabel name = new JLabel("NAME");
	name.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	name.setBounds(125, 138, 156, 34);
	contentPane.add(name);
	JLabel email = new JLabel("EMAIL");
	email.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	email.setBounds(125, 209, 156, 34);
	contentPane.add(email);
	JLabel phone = new JLabel("PHONE NO.");
	phone.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	phone.setBounds(125, 285, 156, 34);
	contentPane.add(phone);
	JLabel address = new JLabel("ADDRESS");
	address.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	address.setBounds(125, 357, 156, 34);
	contentPane.add(address);
	txtid = new JTextField();
	txtid.setBounds(377, 73, 156, 26);
	contentPane.add(txtid);
	txtid.setColumns(10);
	txtname = new JTextField();
	txtname.setBounds(377, 149, 156, 26);
	contentPane.add(txtname);
	txtname.setColumns(10);
	txtmail = new JTextField();
	txtmail.setBounds(377, 220, 156, 26);
	contentPane.add(txtmail);
	txtmail.setColumns(10);
	txtphone = new JTextField();
	txtphone.setBounds(377, 296, 156, 26);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	txtaddress = new JTextField();
	txtaddress.setBounds(377, 368, 156, 26);
	contentPane.add(txtaddress);
	txtaddress.setColumns(10);
	
	
	
	JButton btnAdd = new JButton("Add");
	btnAdd.addActionListener(this);
	btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 24));
	btnAdd.setBounds(282, 460, 135, 34);
	contentPane.add(btnAdd);
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	String id=txtid.getText();
	String name=txtname.getText();
	String phone=txtphone.getText();
	String email=txtmail.getText();
	String address=txtaddress.getText();
	
	if(id.isEmpty()||name.isEmpty()||phone.isEmpty()||email.isEmpty()||address.isEmpty())
		JOptionPane.showMessageDialog(this,"Data Required");
		
	else
	{
		try {
			
		String strinsert="insert into  clientdetails values(?,?,?,?,?)";
				psadd1=con.prepareStatement(strinsert);
				psadd1.setString(1, id);
				psadd1.setString(2, name);
				psadd1.setString(4, phone);
				psadd1.setString(3, email);
				psadd1.setString(5, address);
				
				System.out.println(psadd1);
				
			int row1=psadd1.executeUpdate();
			
				if(row1>0)
				{
				JOptionPane.showMessageDialog(this, "record added");
				txtid.setText("");
				txtname.setText("");
				txtphone.setText("");
				txtmail.setText("");
				txtaddress.setText("");
			
				
				}
			
				
						
					}catch(SQLException se) {
						System.out.println(se);
					}
						
					finally {
						
						try {
							if(psadd1!=null)
								{psadd1.close();
								
						}}
						catch(SQLException se) {System.out.println(se);}
						
						
}}}}

