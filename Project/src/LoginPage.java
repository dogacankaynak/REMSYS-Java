import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private JLabel errorMessage;
	private JLabel signUp;
	private JButton btnLogin;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(62, 178, 86, 16);
		contentPane.add(lblUserName);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(158, 172, 134, 28);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(62, 231, 86, 16);
		contentPane.add(lblPassword);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(158, 225, 134, 28);
		contentPane.add(passwordTF);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(158, 288, 117, 29);
		contentPane.add(btnLogin);
		btnLogin.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String password = passwordTF.getText();
				try {
					if( FileHandler.checkAccount(username, password))
					{
						if(FileHandler.checkUser() == 0)
						{
							setVisible(false);
							admin newAdmin = new admin();
							newAdmin.frame.setVisible(true);
						}
						else if(FileHandler.checkUser() == 1)
						{
							System.out.print("postad");
							
						}
						else if (FileHandler.checkUser() == 2)
						{
							setVisible(false);
							SeeAds newSeeAds = new SeeAds();
							newSeeAds.frame.setVisible(true);
						}
						

					}
					else
					{
						errorMessage.setText( "Username or password is wrong");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		signUp = new JLabel("Haven't you enrolled yet");
		signUp.setForeground(Color.BLUE);
		signUp.setBounds(168, 328, 168, 16);
		contentPane.add(signUp);
		signUp.addMouseListener( new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpPage sp = new SignUpPage();
				sp.setVisible( true);
				dispose();
				
			}
		});
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(123, 328, 234, 16);
		contentPane.add(errorMessage);
		
		JLabel logo = new JLabel("New label");
		logo.setBounds(95, 27, 211, 134);
		contentPane.add(logo);
		ImageIcon logoIcon = new ImageIcon("src/logo.png");
		Image logoImage = logoIcon.getImage();
		Image newLogo = logoImage.getScaledInstance(220, 145,  java.awt.Image.SCALE_SMOOTH); 
		logoIcon = new ImageIcon(newLogo);
		logo.setIcon(logoIcon);
	}
}
