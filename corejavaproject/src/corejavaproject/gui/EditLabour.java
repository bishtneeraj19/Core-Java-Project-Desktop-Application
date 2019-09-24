package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditLabour extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtaddress;
	private JTextField txtgender;
	private JTextField txtage;
	private JTextField txtwid;
private	JComboBox<String>cmblid;
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
					EditLabour frame = new EditLabour();
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
			String strsql="select Lid  from labourdetails";
			pscombo=con.prepareStatement(strsql);
			rscombo=pscombo.executeQuery();
			while(rscombo.next())
			{
				String id=rscombo.getString("lid");
				cmblid.addItem(id);
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
	public EditLabour() {
		createGui();
		
	}
private void createGui()
{
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1550, 838);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);	
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_1.setBounds(320, 274, 115, 27);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("PhoneNo");
	lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_2.setBounds(320, 326, 115, 27);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Address");
	lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_3.setBounds(320, 376, 115, 27);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Gender");
	lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_4.setBounds(320, 427, 115, 27);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Age");
	lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_5.setBounds(320, 480, 115, 27);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Wid");
	lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel_6.setBounds(320, 533, 115, 27);
	contentPane.add(lblNewLabel_6);
	
	
	
	txtname = new JTextField();
	txtname.setBounds(575, 280, 194, 27);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	txtphone = new JTextField();
	txtphone.setBounds(575, 333, 194, 26);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	txtaddress = new JTextField();
	txtaddress.setBounds(575, 383, 194, 26);
	contentPane.add(txtaddress);
	txtaddress.setColumns(10);
	
	txtgender = new JTextField();
	txtgender.setBounds(575, 434, 194, 26);
	contentPane.add(txtgender);
	txtgender.setColumns(10);
	
	txtage = new JTextField();
	txtage.setBounds(575, 487, 194, 26);
	contentPane.add(txtage);
	txtage.setColumns(10);
	
	txtwid = new JTextField();
	txtwid.setBounds(575, 540, 194, 26);
	contentPane.add(txtwid);
	txtwid.setColumns(10);
	
	 cmblid = new JComboBox();
	cmblid.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	cmblid.setModel(new DefaultComboBoxModel(new String[] {"Select LId"}));
	cmblid.setBounds(406, 80, 212, 27);
	fillCombo();
	contentPane.add(cmblid);
	
	btnShowDetails = new JButton("Show Details");
	btnShowDetails.addActionListener(this);
	btnShowDetails.setFont(new Font("Times New Roman", Font.BOLD, 24));
	btnShowDetails.setBounds(111, 608, 194, 37);
	contentPane.add(btnShowDetails);
	
	btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(this);
	btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 24));
	btnUpdate.setBounds(416, 608, 124, 37);
	contentPane.add(btnUpdate);
	
	btnDelete = new JButton("Delete");
	btnDelete.addActionListener(this);
	btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 24));
	btnDelete.setBounds(670, 608, 124, 37);
	contentPane.add(btnDelete);
}

@Override
public void actionPerformed(ActionEvent e) {
	String caption=e.getActionCommand();
	if(caption.equals("Show Details"))
	{
		String lid=(String)cmblid.getSelectedItem();//to select item from comboBox
		if(lid.equalsIgnoreCase("Select Lid"))
		{
			JOptionPane.showMessageDialog(this, "Please select valid ID");
		
		}
		
else
{
	try {
		
		String strsql="select * from labourdetails where lid=?";
			psshow=con.prepareStatement(strsql);
			psshow.setString(1, lid);
			System.out.println(psshow);
			rsshow=psshow.executeQuery();
		if(rsshow.next()==true)
			
		{
				String name=rsshow.getString("name");
				txtname.setText(name);	
				String phoneno=rsshow.getString("phoneno");
				txtphone.setText(phoneno);
				String address=rsshow.getString("address");
				txtaddress.setText(address);
				String gender=rsshow.getString("gender");
				txtgender.setText(gender);
				String age=rsshow.getString("age");
				txtage.setText(age);
				String wid=rsshow.getString("wid");
				txtwid.setText(wid);
				
				
			
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
			String strupdate="update labourdetails set   phoneno=?, adrress=?,  where lId=?";
				psupdate=con.prepareStatement(strupdate);
				String phone=txtaddress.getText();
				String address=txtwid.getText();
				String id=(String)cmblid.getSelectedItem();
				psupdate.setString(1, phone);
				psupdate.setString(2, address);
				psupdate.setString(3, id);
			int rw=	psupdate.executeUpdate();
			System.out.println(rw);
			if(rw>0)
			{
				
				JOptionPane.showMessageDialog(this, "RecordUpdated","updation",JOptionPane.INFORMATION_MESSAGE);
				cmblid.removeAllItems();
				cmblid.addItem("Select lId");
				fillCombo();
				txtname.setText("");
				txtaddress.setText("");
				txtphone.setText("");
				txtgender.setText("");
				txtage.setText("");
				txtwid.setText("");
			}
					
				}
				catch(SQLException se) {System.out.println(se);}

			}
	if(caption.equals("Delete"))
	{
	String lid=(String)cmblid.getSelectedItem();//to select item from comboBox
	if(lid.equalsIgnoreCase("Select lId"))
	{
		JOptionPane.showMessageDialog(this, "Please select valid ID");
	
	}
	else
	{
		int option=JOptionPane.showConfirmDialog(this, "Are u sure u wish to delete");
		if(option==0)
		{
			try {
				String strdelete="delete from labourdetails where lid=?";
				psdelete=con.prepareStatement(strdelete);
		psdelete.setString(1, lid);
		int row=psdelete.executeUpdate();
		if(row>0)
		{
			JOptionPane.showMessageDialog(this, "Record Deleted");
			cmblid.removeAllItems();
			cmblid.addItem("Select LId");
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
