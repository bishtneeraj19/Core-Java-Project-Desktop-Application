package corejavaproject.gui;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import corejavaproject.dbtask.CrudOperation;
public class RequestDriver extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtduration;
	private JDateChooser dc1,dc2;
	private	JComboBox<String>cmbid;
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
					RequestDriver frame = new RequestDriver();
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
	public RequestDriver() {
		setTitle("Request Driver");
		con=CrudOperation.createConnection();
		createGui();
		
	}
private void createGui()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1124, 748);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblBookingDate = new JLabel("Booking Date");
	lblBookingDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblBookingDate.setBounds(135, 259, 156, 34);
	contentPane.add(lblBookingDate);
	
	JLabel lblNewLabel = new JLabel("Duration");
	lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblNewLabel.setBounds(135, 343, 156, 34);
	contentPane.add(lblNewLabel);
	
	JLabel lblRequestdate = new JLabel("RequestDate");
	lblRequestdate.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	lblRequestdate.setBounds(135, 423, 156, 34);
	contentPane.add(lblRequestdate);
	
	 cmbid = new JComboBox();
	 cmbid.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	 cmbid.setModel(new DefaultComboBoxModel(new String[] {"Select ClientId"}));
	 cmbid.setBounds(406, 80, 212, 27);
	 fillCombo();
	 contentPane.add(cmbid);
	 
    dc1 = new JDateChooser();
    dc1.setDateFormatString("yyyy-MM-dd");
	dc1.setBounds(377, 259, 156, 26);
	contentPane.add(dc1);
	
	dc2 = new JDateChooser();
	dc1.setDateFormatString("yyyy-MM-dd");
	dc2.setBounds(377, 431, 156, 26);
	contentPane.add(dc2);
	
	txtduration = new JTextField();
	txtduration.setBounds(377, 354, 156, 26);
	contentPane.add(txtduration);
	txtduration.setColumns(10);
	
	JButton btnAdd = new JButton("Submit ");
	btnAdd.addActionListener(this);
	btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 24));
	btnAdd.setBounds(274, 536, 135, 34);
	contentPane.add(btnAdd);
}

@Override
public void actionPerformed(ActionEvent e) {
	String duration=txtduration.getText();
	java.util.Date d1=dc1.getDate();
	java.util.Date d2=dc2.getDate();
	String driverid=(String)cmbid.getSelectedItem();
	if(driverid.equalsIgnoreCase("Select ClientId"))
	{
		JOptionPane.showMessageDialog(this, "Please select valid ID");
	
	}
	if(duration.isEmpty()||d1==null||d2==null)
		JOptionPane.showMessageDialog(this,"Data Required");
	else
	{
		long date1 =d1.getTime();
		java.sql.Date sd1=new java.sql.Date(date1);
		long date2 =d2.getTime();
		java.sql.Date sd2=new java.sql.Date(date2);
		try {
			
				String strinsert2="insert into requestdriver(BookingDate, Duration, RequestDate,ClientId) values(?,?,?,?)";
					psadd=con.prepareStatement(strinsert2);
					psadd.setDate(1, sd1);
					psadd.setString(2, duration);
					psadd.setDate(3, sd2);
					psadd.setString(4, driverid);
				int row2=psadd.executeUpdate();
					if(row2>0)
					{
					JOptionPane.showMessageDialog(this, "record added");
					
				
					
					}
				
					
							
						}catch(SQLException se) {
							System.out.println(se);
						}
							
						finally {
							
							try {
								if(psadd!=null)
									{
									psadd.close();
							}}
							catch(SQLException se) {System.out.println(se);}
							
							
	}
}
}}
