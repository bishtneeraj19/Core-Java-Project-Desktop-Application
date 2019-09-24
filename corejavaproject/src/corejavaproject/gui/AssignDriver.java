package corejavaproject.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;

import corejavaproject.dbtask.CrudOperation;


import java.sql.*;
public class AssignDriver extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField txtcid;
	private JTextField txtduration;
	private JTextField txtcharges;
private JComboBox<String>cmbid;
private JDateChooser dc;
private Connection con;
private PreparedStatement pscombo,psadd;
private ResultSet rscombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignDriver frame = new AssignDriver();
					
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
	public AssignDriver() {
		setTitle("Assign Driver");
		con=(Connection) CrudOperation.createConnection();
		createGui();
	}
	private void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1154, 770);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientId = new JLabel("Client Id");
		lblClientId.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblClientId.setBounds(194, 114, 165, 34);
		contentPane.add(lblClientId);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblNewLabel.setBounds(194, 202, 165, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblDuration.setBounds(194, 292, 165, 34);
		contentPane.add(lblDuration);
		
		JLabel lblTotalcharges = new JLabel("TotalCharges");
		lblTotalcharges.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblTotalcharges.setBounds(194, 382, 165, 34);
		contentPane.add(lblTotalcharges);
		
		txtcid = new JTextField();
		txtcid.setBounds(502, 114, 165, 33);
		contentPane.add(txtcid);
		txtcid.setColumns(10);
		
		 dc = new JDateChooser();
		dc.setDateFormatString("yyyy-MM-dd");
		dc.setBounds(502, 202, 165, 34);
		contentPane.add(dc);
		
		txtduration = new JTextField();
		txtduration.setBounds(502, 292, 165, 33);
		contentPane.add(txtduration);
		txtduration.setColumns(10);
		
		txtcharges = new JTextField();
		txtcharges.setBounds(502, 382, 165, 33);
		contentPane.add(txtcharges);
		txtcharges.setColumns(10);
		
		 cmbid = new JComboBox();
			cmbid.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			cmbid.setModel(new DefaultComboBoxModel(new String[] {"Select DriverId"}));
			cmbid.setBounds(357, 458, 212, 40);
				contentPane.add(cmbid);
				
				JButton btnShowDriver = new JButton("Show Driver");
				btnShowDriver.addActionListener(this);
				btnShowDriver.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
				btnShowDriver.setBounds(142, 610, 217, 34);
				contentPane.add(btnShowDriver);
				
				JButton btnAssignDriver = new JButton("Assign Driver");
				btnAssignDriver.addActionListener(this);
				btnAssignDriver.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
				btnAssignDriver.setBounds(726, 610, 212, 34);
				contentPane.add(btnAssignDriver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cid=txtcid.getText();
		String duration=txtduration.getText();
		String totalcharge=txtcharges.getText();
		java.util.Date d=dc.getDate();
		
		String caption=e.getActionCommand();
		if(caption.equals("Show Driver"))
		{
		if(d==null||cid.isEmpty()||duration.isEmpty()||totalcharge.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "data required");
		}
		else {
			
		try {
			long date =d.getTime();
			java.sql.Date sd=new java.sql.Date(date);
			String strsql="select driverid from driverdetails where driverid not in(select driverid from assigndriver where date=?)";
			pscombo=con.prepareStatement(strsql);
			pscombo.setDate(1, sd);
			rscombo=pscombo.executeQuery();
			while(rscombo.next())
			{
				String id=rscombo.getString("DriverId");
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
		}}}
		if(caption.equals("Assign Driver"))
		{
		if(d==null||cid.isEmpty()||duration.isEmpty()||totalcharge.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "data required");
		}
		else {	
			long date =d.getTime();
			java.sql.Date sd1=new java.sql.Date(date);
		String driverid=(String)cmbid.getSelectedItem();//to select item from comboBox
		if(driverid.equalsIgnoreCase("Select DriverId"))
		{
			JOptionPane.showMessageDialog(this, "Please select valid ID");
		
		}
		
else
{
	try {
		
		String strinsert="insert into assigndriver( DriverId, ClientId, Date, Duration, TotalCharges) values(?,?,?,?,?)";
		psadd=con.prepareStatement(strinsert);
		psadd.setString(1,driverid);
		psadd.setString(2, cid);  
		psadd.setDate(3, sd1);
		psadd.setString(4, duration);
		psadd.setString(5, totalcharge);
		System.out.println(psadd);
		
		int row=psadd.executeUpdate();
		if(row>0)
		{
			JOptionPane.showMessageDialog(this, "record added");
		txtcid.setText("");
		txtduration.setText("");
		txtcharges.setText("");
		
		cmbid.removeAllItems();
		cmbid.addItem("Select DriverId");
		
		}}
		catch (SQLException se) {
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
}}}