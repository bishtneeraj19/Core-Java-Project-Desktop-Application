package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import corejavaproject.dbtask.CrudOperation;

import javax.swing.JButton;
import java.sql.*;
import java.awt.Font;
public class FeedBack extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtfid;
	private JTextField txtdid;
	private JTextField txtcid;
	private JTextField txttext;
private JDateChooser dc;
private Connection con;
private PreparedStatement psadd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedBack frame = new FeedBack();
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
	public FeedBack() {
		setTitle("FeedBack");
		con=CrudOperation.createConnection();
		createGui();
	}
private void createGui()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 772, 596);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);	
	
	JLabel lblFid = new JLabel("Fid");
	lblFid.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblFid.setBounds(199, 96, 96, 29);
	contentPane.add(lblFid);
	
	txtfid = new JTextField();
	txtfid.setBounds(408, 96, 176, 30);
	contentPane.add(txtfid);
	txtfid.setColumns(10);
	
	JLabel lblDriverid = new JLabel("Driverid");
	lblDriverid.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblDriverid.setBounds(199, 177, 96, 29);
	contentPane.add(lblDriverid);
	
	txtdid = new JTextField();
	txtdid.setBounds(408, 177, 176, 30);
	contentPane.add(txtdid);
	txtdid.setColumns(10);
	
	JLabel lblClientid = new JLabel("Clientid");
	lblClientid.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblClientid.setBounds(199, 246, 96, 29);
	contentPane.add(lblClientid);
	
	txtcid = new JTextField();
	txtcid.setBounds(408, 246, 176, 30);
	contentPane.add(txtcid);
	txtcid.setColumns(10);
	
	JLabel lblDate = new JLabel("date");
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblDate.setBounds(199, 320, 96, 29);
	contentPane.add(lblDate);
	
	 dc = new JDateChooser();
	 dc.setDateFormatString("yyyy-MM-dd");
	 dc.setBounds(408, 320, 176, 29);
	contentPane.add(dc);
	
	JLabel lblText = new JLabel("text");
	lblText.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblText.setBounds(199, 394, 96, 29);
	contentPane.add(lblText);
	
	txttext = new JTextField();
	txttext.setBounds(408, 394, 176, 50);
	contentPane.add(txttext);
	txttext.setColumns(10);
	
	JButton btnSubmit = new JButton("Submit");
	btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 24));
	btnSubmit.addActionListener(this);
	btnSubmit.setBounds(254, 475, 148, 37);
	contentPane.add(btnSubmit);
}

@Override
public void actionPerformed(ActionEvent e) {
	String fid=txtfid.getText();
	String did=txtdid.getText();
	String cid=txtcid.getText();
	String text=txttext.getText();
	java.util.Date d=dc.getDate();		
	if(text.isEmpty()||fid.isEmpty()||cid.isEmpty()||did.isEmpty()||d==null)
		JOptionPane.showMessageDialog(this, "Data Reqiured");
	else
	{
		long date =d.getTime();
		java.sql.Date sd=new java.sql.Date(date);
	
			try {
				String strinsert="insert into feedbackinfo values(?,?,?,?,?)";
				psadd=con.prepareStatement(strinsert);
				psadd.setString(1,fid);
				psadd.setString(2, did);  
				psadd.setString(3,cid);
				psadd.setDate(4, sd);
				psadd.setString(5, text);
				
			
				System.out.println(psadd);
				
				int row=psadd.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "record added");
					txtfid.setText("");
					txtdid.setText("");
					txtcid.setText("");
					txttext.setText("");
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
