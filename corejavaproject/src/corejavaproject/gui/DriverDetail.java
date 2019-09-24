package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import corejavaproject.dbtask.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;

public class DriverDetail extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private JTextField txtage;
	private JTextField txtgender;
	private JTextField txtaddress;
	private Connection con;
	private PreparedStatement pssearch,psadd,psupdate,psdelete;
	private ResultSet rssearch,rsdelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverDetail frame = new DriverDetail();
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
	public DriverDetail() {
		con=CrudOperation.createConnection();
		createGui();
	}
	private void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1099, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DriverId");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(130, 141, 83, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(130, 194, 83, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(130, 255, 83, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PhoneNo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(130, 315, 83, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(130, 375, 83, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(130, 427, 83, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(130, 480, 83, 27);
		contentPane.add(lblNewLabel_6);
		
		txtid = new JTextField();
		txtid.setBounds(388, 141, 96, 26);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(388, 194, 96, 26);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtmail = new JTextField();
		txtmail.setBounds(388, 255, 96, 26);
		contentPane.add(txtmail);
		txtmail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setBounds(388, 315, 96, 26);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtage = new JTextField();
		txtage.setBounds(388, 375, 96, 26);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		txtgender = new JTextField();
		txtgender.setBounds(388, 427, 96, 26);
		contentPane.add(txtgender);
		txtgender.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(388, 480, 96, 26);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(128, 578, 85, 21);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(290, 578, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(439, 578, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(607, 578, 85, 21);
		contentPane.add(btnDelete);
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
		String caption=e.getActionCommand();
		System.out.println(caption);
		if(caption.equals("search"))
				{
			if(id.isEmpty())
				JOptionPane.showMessageDialog(this, "Data Reqiured");
			else
			{
				try {
					
					String strsql="select * from driverdetails where DriverId=?";
						pssearch=con.prepareStatement(strsql);
						pssearch.setString(1, id);
						System.out.println(pssearch);
						rssearch=pssearch.executeQuery();
					if(rssearch.next()==true)
						
					{
							String drivername=rssearch.getString("name");
							txtname.setText(drivername);	
							String drivermail=rssearch.getString("email");
							txtmail.setText(drivermail);
							String driverphone=rssearch.getString("phoneno");
							txtphone.setText(driverphone);
							String driverage=rssearch.getString("age");
							txtage.setText(driverage);
							String drivergender=rssearch.getString("gender");
							txtgender.setText(drivergender);
							String driveraddress=rssearch.getString("address");
							txtaddress.setText(driveraddress);
							
							
						
					}
						
					else
					{
						JOptionPane.showMessageDialog(this, "No Such id");
						
					}
						
							
							
							
						}
						
				
						catch(SQLException se)
						{
							
							System.out.println(se);
						}

						finally {
							
							try {
								if(rssearch!=null)rssearch.close();
								if(pssearch!=null)pssearch.close();
								
							}
							catch(SQLException se) {System.out.println(se);}
							}}
			}
		if(caption.equals("add"))
		{
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
		if(caption.equals("update"))
		{
			try {
		String strupdate="update driverdetails set  Name=?, Email=?, PhoneNo=?, Age=?,Gender=?, Address=?  where DriverId=?";
			psupdate=con.prepareStatement(strupdate);
			String name2=txtname.getText();
			String mail2=txtmail.getText();
			String phone2=txtphone.getText();
			String age2=txtage.getText();
			String gender2=txtgender.getText();
			String address2=txtaddress.getText();
			psupdate.setString(1, name2);
			psupdate.setString(2, mail2);
			psupdate.setString(3, phone2);
			psupdate.setString(4, age2);
			psupdate.setString(5, gender2);
			psupdate.setString(6, address2);
			psupdate.setString(7, id);
		int rw=	psupdate.executeUpdate();
		System.out.println(rw);
		if(rw>0)
		{
			
			JOptionPane.showMessageDialog(this, "RecordUpdated","updation",JOptionPane.INFORMATION_MESSAGE);
		txtid.setText("");
			txtname.setText("");
			txtphone.setText("");
			txtmail.setText("");
			txtage.setText("");
			txtgender.setText("");
			txtaddress.setText("");
		}
				
			}
			catch(SQLException se) {System.out.println(se);}

		}
		
				}
	}

