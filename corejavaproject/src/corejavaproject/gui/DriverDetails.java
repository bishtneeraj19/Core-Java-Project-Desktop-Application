package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import corejavaproject.dbtask.CrudOperation;

import java.sql.*;
public class DriverDetails extends JFrame {

	private JPanel contentPane;
private JScrollPane scrollPane;
private JTable table;
private Connection con;
private PreparedStatement psdata,pscount;
private ResultSet rscount,rsdata;
private String[][]data;
private String[]Cols={"DriverID", "Name", "Email", "PhoneNo", "Age", "Gender", "Address"
};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverDetails frame = new DriverDetails();
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
	public DriverDetails() {
		setTitle("Driver Details");
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillArray()
	{
		try {
			String strcount="select count(*) from driverdetails";
int rowcnt=0;
pscount=con.prepareStatement(strcount);
rscount=pscount.executeQuery();
if(rscount.next())
	rowcnt=	rscount.getInt(1);
data=new String[rowcnt][7];//object
String strsql="select * from driverdetails"	;
psdata=con.prepareStatement(strsql);

rsdata=psdata.executeQuery();
int row=0;
while(rsdata.next())
{data[row][0]=rsdata.getString("driverid");
data[row][1]=rsdata.getString("name");
data[row][2]=rsdata.getString("email");
data[row][3]=rsdata.getString("phoneno");
data[row][4]=rsdata.getString("age");
data[row][5]=rsdata.getString("gender");
data[row][6]=rsdata.getString("address");

row++;


}
		
		} catch (SQLException se) {
System.out.println(se);		}
		
		
	}
private void createGui()
{
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1552, 838);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	 scrollPane = new JScrollPane();
	scrollPane.setBounds(139, 53, 1077, 725);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	table.setFillsViewportHeight(true);
	table.setBackground(Color.CYAN);
	JTableHeader header=table.getTableHeader();
	header.setForeground(Color.white);
	header.setBackground(Color.black);
	header.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	table.setForeground(Color.BLUE);
	table.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	fillArray();
	table.setModel(new DefaultTableModel(
			data,Cols
	));
	scrollPane.setViewportView(table);}
}
