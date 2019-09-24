package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class EditClient extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private JTextField txtaddress;
private	JComboBox<String>cmbid;
	private Connection con;
	private PreparedStatement pscombo,psshow,psupdate,psdelete;
	private ResultSet rscombo,rsshow;
	private JButton btnShowDetails;
	private JButton btnUpdate;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditClient frame = new EditClient();
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
	public void fillCombo()
	{
		try {
			String strsql="select ClientId  from clientdetails";
			pscombo=con.prepareStatement(strsql);
			rscombo=pscombo.executeQuery();
			while(rscombo.next())
			{
				String id=rscombo.getString("ClientId");
				cmbid.addItem(id);
			}
			
			
			
		} 
		
		catch (SQLException se) {
System.out.println(se);		}
		finally
		{
			try {
				if(rscombo!=null)rscombo.close();
						if(pscombo!=null)pscombo.close();
			} catch (SQLException se) {
System.out.println(se);			}
		}
		
		
		
	}
	public EditClient() {
		setTitle("Edit Client");
		con=CrudOperation.createConnection();
		createGui();
	}
private void createGui()
{setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100, 100, 1151, 750);
contentPane = new JPanel();
contentPane.setBackground(Color.RED);
contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
setContentPane(contentPane);
contentPane.setLayout(null);


JLabel lblNewLabel_1 = new JLabel("Name");
lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
lblNewLabel_1.setBounds(320, 274, 115, 27);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Email");
lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
lblNewLabel_2.setBounds(320, 326, 115, 27);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("PhoneNo");
lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
lblNewLabel_3.setBounds(320, 376, 115, 27);
contentPane.add(lblNewLabel_3);

JLabel lblNewLabel_6 = new JLabel("Address");
lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
lblNewLabel_6.setBounds(320, 433, 115, 27);
contentPane.add(lblNewLabel_6);



txtname = new JTextField();
txtname.setEditable(false);
txtname.setBounds(575, 280, 194, 27);
contentPane.add(txtname);
txtname.setColumns(10);

txtmail = new JTextField();
txtmail.setBounds(575, 333, 194, 26);
contentPane.add(txtmail);
txtmail.setColumns(10);

txtphone = new JTextField();
txtphone.setBounds(575, 383, 194, 26);
contentPane.add(txtphone);
txtphone.setColumns(10);



txtaddress = new JTextField();
txtaddress.setBounds(575, 440, 194, 26);
contentPane.add(txtaddress);
txtaddress.setColumns(10);

 cmbid = new JComboBox();
cmbid.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
cmbid.setModel(new DefaultComboBoxModel(new String[] {"Select ClientId"}));
cmbid.setBounds(406, 80, 212, 27);
fillCombo();
contentPane.add(cmbid);

btnShowDetails = new JButton("Show Details");
btnShowDetails.addActionListener(this);
btnShowDetails.setFont(new Font("Times New Roman", Font.BOLD, 24));
btnShowDetails.setBounds(108, 556, 194, 37);
contentPane.add(btnShowDetails);

btnUpdate = new JButton("Update");
btnUpdate.addActionListener(this);
btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 24));
btnUpdate.setBounds(406, 556, 124, 37);
contentPane.add(btnUpdate);

btnDelete = new JButton("Delete");
btnDelete.addActionListener(this);
btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 24));
btnDelete.setBounds(662, 556, 124, 37);
contentPane.add(btnDelete);

}

@Override
public void actionPerformed(ActionEvent e) {
	String caption=e.getActionCommand();
	if(caption.equals("Show Details"))
	{
		String driverid=(String)cmbid.getSelectedItem();
		if(driverid.equalsIgnoreCase("Select ClientId"))
		{
			JOptionPane.showMessageDialog(this, "Please select valid ID");
		
		}
		
else
{
	try {
		
		String strsql="select * from clientdetails where ClientId=?";
			psshow=con.prepareStatement(strsql);
			psshow.setString(1, driverid);
			System.out.println(psshow);
			rsshow=psshow.executeQuery();
		if(rsshow.next()==true)
			
		{
				String drivername=rsshow.getString("name");
				txtname.setText(drivername);	
				String drivermail=rsshow.getString("email");
				txtmail.setText(drivermail);
				String driverphone=rsshow.getString("phoneno");
				txtphone.setText(driverphone);
				String driveraddress=rsshow.getString("address");
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
					if(rsshow!=null)rsshow.close();
					if(psshow!=null)psshow.close();
					
				}
				catch(SQLException se) {System.out.println(se);}
				}}
}
	if(caption.equals("Update"))
	{
		try {
			String strupdate="update clientdetails set   Email=?, PhoneNo=?, Address=?  where ClientId=?";
				psupdate=con.prepareStatement(strupdate);
				String mail=txtmail.getText();
				String phone=txtphone.getText();
				String address=txtaddress.getText();
				String id=(String)cmbid.getSelectedItem();
				psupdate.setString(1, mail);
				psupdate.setString(2, phone);
				psupdate.setString(3, address);
				psupdate.setString(4, id);
			int rw=	psupdate.executeUpdate();
			System.out.println(rw);
			if(rw>0)
			{
				
				JOptionPane.showMessageDialog(this, "RecordUpdated","updation",JOptionPane.INFORMATION_MESSAGE);
				cmbid.removeAllItems();
				cmbid.addItem("Select DriverId");
				fillCombo();
				txtname.setText("");
				txtphone.setText("");
				txtmail.setText("");
				txtaddress.setText("");
			}
					
				}
				catch(SQLException se) {System.out.println(se);}

			}
	if(caption.equals("Delete"))
	{
	String driverid=(String)cmbid.getSelectedItem();//to select item from comboBox
	if(driverid.equalsIgnoreCase("Select ClientId"))
	{
		JOptionPane.showMessageDialog(this, "Please select valid ID");
	
	}
	else
	{
		int option=JOptionPane.showConfirmDialog(this, "Are u sure u wish to delete");
		if(option==0)
		{
			try {
				String strdelete="delete from clientdetails where clientid=?";
				psdelete=con.prepareStatement(strdelete);
		psdelete.setString(1, driverid);
		int row=psdelete.executeUpdate();
		if(row>0)
		{
			JOptionPane.showMessageDialog(this, "Record Deleted");
			cmbid.removeAllItems();
			cmbid.addItem("Select DriverId");
			fillCombo();
		}
			} catch (SQLException se) {
System.out.println(se);			}
		
		finally
		{
			try {
				if(psdelete!=null)psdelete.close();
			} catch (SQLException se) {System.out.println(se);
			}
			
		}}
	}

}	
}
}
