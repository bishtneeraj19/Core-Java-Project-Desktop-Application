package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Driver extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver frame = new Driver();
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
	public Driver() {
		setTitle("Driver");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 654);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddDriver = new JButton("Add Driver");
		btnAddDriver.setForeground(new Color(0, 0, 255));
		btnAddDriver.setBackground(Color.BLACK);
		btnAddDriver.addActionListener(this);
		btnAddDriver.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnAddDriver.setBounds(159, 86, 185, 48);
		contentPane.add(btnAddDriver);
		
		JButton btnNewButton = new JButton("Edit Driver");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnNewButton.setBounds(578, 86, 185, 48);
		contentPane.add(btnNewButton);
		
		JButton btnAssignDriver = new JButton("Assign Driver");
		btnAssignDriver.setForeground(new Color(0, 0, 255));
		btnAssignDriver.setBackground(Color.BLACK);
		btnAssignDriver.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnAssignDriver.addActionListener(this);
		btnAssignDriver.setBounds(361, 375, 221, 48);
		contentPane.add(btnAssignDriver);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Driver.class.getResource("/corejavaproject/image/why-kei-8e2gal_GIE8-unsplash.jpg")));
		label.setBounds(0, 0, 885, 617);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		if(caption.equals("Add Driver"))
		{
		AddDriver d=new AddDriver();
		d.setVisible(true);		
	}
		if(caption.equals("Edit Driver"))
		{
			EditDriver ed=new EditDriver();
			ed.setVisible(true);
		}
		if(caption.equals("Assign Driver"))
		{
			AssignDriver ad=new AssignDriver();
			ad.setVisible(true);
		}
	}
}
