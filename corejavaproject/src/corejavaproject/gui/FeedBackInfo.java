package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import corejavaproject.dbtask.CrudOperation;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FeedBackInfo extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private Connection con;
	private PreparedStatement psdata,pscount;
	private ResultSet rscount,rsdata;
	private String[][]data;
	private String[]Cols={"Fid", "DriverId", "ClientId", "Date", "Text"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedBackInfo frame = new FeedBackInfo();
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
	public FeedBackInfo() {
	con=CrudOperation.createConnection();
		createGui();	
	}
	public void fillArray()
	{
		try {
			String strcount="select count(*) from feedbackinfo";
int rowcnt=0;
pscount=con.prepareStatement(strcount);
rscount=pscount.executeQuery();
if(rscount.next())
	rowcnt=	rscount.getInt(1);
data=new String[rowcnt][5];//object
String strsql="select * from feedbackinfo"	;
psdata=con.prepareStatement(strsql);

rsdata=psdata.executeQuery();
int row=0;
while(rsdata.next())
{data[row][0]=rsdata.getString("Fid");
data[row][1]=rsdata.getString("driverid");
data[row][2]=rsdata.getString("clientid");
data[row][3]=rsdata.getString("date");
data[row][4]=rsdata.getString("text");



row++;


}
		
		} catch (SQLException se) {
System.out.println(se);		}
		
		
	}
private void createGui()
{
	setTitle("FeedBack Info");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1127, 796);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
setLocationRelativeTo(null);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	 scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 46, 952, 666);
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
	scrollPane.setViewportView(table);


}
}

