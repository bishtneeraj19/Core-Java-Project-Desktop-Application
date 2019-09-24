package corejavaproject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener,KeyListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		createGui();
	
	}
private void createGui()
{
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1550, 838);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);	
	
	JLabel lblId = new JLabel("ID");
	lblId.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblId.setBounds(469, 272, 105, 29);
	contentPane.add(lblId);
	
	JLabel lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblPassword.setBounds(469, 389, 105, 29);
	contentPane.add(lblPassword);
	
	txtid = new JTextField();
	txtid.addKeyListener(this);
	txtid.setBounds(704, 273, 144, 29);
	contentPane.add(txtid);
	txtid.setColumns(10);
	
	txtpass = new JPasswordField();
	txtpass.addKeyListener(this);
	txtpass.setBounds(704, 389, 144, 30);
	contentPane.add(txtpass);
	
	JButton btnSubmit = new JButton("SUBMIT");
	btnSubmit.setForeground(Color.BLUE);
	btnSubmit.setBackground(Color.LIGHT_GRAY);
	btnSubmit.addActionListener(this);
	btnSubmit.addKeyListener(this);
	btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 24));
	btnSubmit.setBounds(586, 523, 144, 29);
	contentPane.add(btnSubmit);
	
	JLabel lblDriverOnDemand = new JLabel("DRIVER ON DEMAND MANAGEMENT SYSTEM");
	lblDriverOnDemand.setForeground(Color.CYAN);
	lblDriverOnDemand.setBackground(Color.BLUE);
	lblDriverOnDemand.setFont(new Font("Times New Roman", Font.BOLD, 30));
	lblDriverOnDemand.setBounds(431, 91, 697, 59);
	contentPane.add(lblDriverOnDemand);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/corejavaproject/image/a.jpg")));
	lblNewLabel.setBounds(0, 0, 1536, 801);
	contentPane.add(lblNewLabel);
}
@Override
public void actionPerformed(ActionEvent e) {
login();
}
public void login()
{
	String id=txtid.getText();
	char []pass=txtpass.getPassword();
	String password=new String(pass);
	if(id.isEmpty()||password.isEmpty())
	{
		JOptionPane.showMessageDialog(this, "Data Reqiured", "Error",JOptionPane.ERROR_MESSAGE );
		
	}
	else
	{
		if(id.equalsIgnoreCase("Aditya")&&password.equals("adi@123"))
		{JOptionPane.showMessageDialog(this, "Hello "+id);
		Admin a=new Admin();
		a.setVisible(true);
		this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Invalid user id/passsword", "Invalid", JOptionPane.WARNING_MESSAGE);
		}
	}
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	int key=e.getKeyCode();
	if(key==10)
	{login();}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
