package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Admin extends JFrame implements ActionListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Admin");
	createGui();
	}
	private void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1556, 838);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Driver");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(442, 248, 192, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Client");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(923, 243, 192, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnFeedback = new JButton("FeedBack");
		btnFeedback.setForeground(Color.WHITE);
		btnFeedback.setBackground(Color.BLACK);
		btnFeedback.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnFeedback.addActionListener(this);
		btnFeedback.setBounds(770, 0, 385, 44);
		contentPane.add(btnFeedback);
		
		JButton btnNewButton_2 = new JButton("Driver Details");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(0, 0, 385, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Booking Details");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(385, 0, 385, 44);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(0, 0, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnShowFeedback = new JButton("Show FeedBack");
		btnShowFeedback.addActionListener(this);
		btnShowFeedback.setForeground(Color.WHITE);
		btnShowFeedback.setBackground(Color.BLACK);
		btnShowFeedback.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnShowFeedback.setBounds(1155, 0, 385, 44);
		contentPane.add(btnShowFeedback);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Admin.class.getResource("/corejavaproject/image/b.jpg")));
		label.setBounds(0, 0, 1540, 801);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		if(caption.equals("Driver"))
		{Driver d=new Driver();
		d.setVisible(true);}
		if(caption.equals("Client"))
		{Client c=new Client();
		c.setVisible(true);}
		if(caption.equals("FeedBack"))
		{FeedBack f=new FeedBack();
		f.setVisible(true);}
		if(caption.equals("Driver Details"))
		{DriverDetails dd=new DriverDetails();
		dd.setVisible(true);}
		if(caption.equals("Booking Details"))
		{BookingDetails bd=new BookingDetails();
		bd.setVisible(true);}
		if(caption.equals("Show FeedBack"))
		{FeedBackInfo fi=new FeedBackInfo();
		fi.setVisible(true);}	
	}
}
