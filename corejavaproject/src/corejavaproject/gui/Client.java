package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setTitle("Client");
		createGui();
	}
	private void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1052, 737);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddClient = new JButton("Add Client");
	btnAddClient.addActionListener(this);
		btnAddClient.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnAddClient.setBounds(171, 298, 156, 51);
		contentPane.add(btnAddClient);
		
		JButton btnEditClient = new JButton("Edit Client");
	btnEditClient.addActionListener(this);
		btnEditClient.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnEditClient.setBounds(606, 298, 173, 43);
		contentPane.add(btnEditClient);
		
		JButton btnRequestDriver = new JButton("Request Driver");
		btnRequestDriver.addActionListener(this);
		btnRequestDriver.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnRequestDriver.setBounds(356, 439, 214, 43);
		contentPane.add(btnRequestDriver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		if(caption.equals("Add Client"))
		{AddClient a=new AddClient();
		a.setVisible(true);}
		if(caption.equals("Edit Client"))
		{EditClient c=new EditClient();
		c.setVisible(true);}
		if(caption.equals("Request Driver"))
		{RequestDriver r=new RequestDriver();
		r.setVisible(true);}
	}
}
