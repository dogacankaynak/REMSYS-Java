import java.awt.BorderLayout;
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
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordTF1;
	private JButton btnSignUp;
	private JLabel label;
	private JPasswordField passwordTF2;
	private JLabel errorMessage;
	private boolean userAgency;
	JRadioButton rdbtnAgency = new JRadioButton("Agency");
	JRadioButton rdbtnUser = new JRadioButton("User");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(84, 168, 86, 16);
		contentPane.add(lblUserName);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(180, 162, 134, 28);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(84, 207, 86, 16);
		contentPane.add(lblPassword);
		
		passwordTF1 = new JPasswordField();
		passwordTF1.setBounds(180, 201, 134, 28);
		contentPane.add(passwordTF1);
		
		btnSignUp = new JButton("SignUp");
		btnSignUp.setBounds(197, 327, 117, 29);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String password1 = passwordTF1.getText();
				String password2 = passwordTF2.getText();
				try {
					if(!FileHandler.userNameCheck(username))
					{
						if( !password1.equals( "") && !password2.equals( "") && !username.equals( ""))
						{
							if(password1.equals( password2))
							{
								try {
									if(userAgency)
										FileHandler.writeUserToFile( username, password1 , "user");
									else if(!userAgency)
									{
										FileHandler.writeUserToFile( username, password1 , "agency");
									}
									
									errorMessage.setText( "");
									LoginPage lp = new LoginPage();
									lp.setVisible( true);
									dispose();
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
								errorMessage.setText( "passwords are not the same");
						}
						else
							errorMessage.setText( "please fill all the fields");
						
					}
					else
						errorMessage.setText("Username Already Exsist");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		rdbtnAgency.setBackground(Color.LIGHT_GRAY);
		
		
		rdbtnAgency.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	rdbtnUser.setSelected(false);
		    	userAgency = false ; 
				

	        }
		});
		    rdbtnUser.setBackground(Color.LIGHT_GRAY);
		    rdbtnUser.addActionListener (new ActionListener () {
			    public void actionPerformed(ActionEvent e) {
			    	rdbtnAgency.setSelected(false);
			    	userAgency = true ; 
					
			    
		        }
		    });
		
		label = new JLabel("Password:");
		label.setBounds(84, 246, 86, 16);
		contentPane.add(label);
		
		passwordTF2 = new JPasswordField();
		passwordTF2.setBounds(180, 240, 134, 28);
		contentPane.add(passwordTF2);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(142, 300, 194, 16);
		contentPane.add(errorMessage);

		
		rdbtnAgency.setBounds(162, 285, 109, 23);
		contentPane.add(rdbtnAgency);
		
		
		rdbtnUser.setBounds(274, 285, 109, 23);
		contentPane.add(rdbtnUser);
		
		JLabel logo = new JLabel("New label");
		logo.setBounds(152, 11, 211, 134);
		contentPane.add(logo);
		ImageIcon logoIcon = new ImageIcon("src/logo.png");
		Image logoImage = logoIcon.getImage();
		Image newLogo = logoImage.getScaledInstance(220, 145,  java.awt.Image.SCALE_SMOOTH); 
		logoIcon = new ImageIcon(newLogo);
		logo.setIcon(logoIcon);
	}
}
