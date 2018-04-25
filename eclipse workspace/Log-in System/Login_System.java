package LogIn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import SignUp.SignUpForm;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JSeparator;
import java.awt.Color;

public class Login_System {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(155, 11, 143, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(23, 62, 101, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(23, 137, 110, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(134, 62, 257, 21);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(134, 137, 257, 21);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
	//==>
		
		JButton btnLogin = new JButton("Log In");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = username.getText();
				String pass= password.getText();
				
				Scanner input;
				ArrayList<String> nameL,passL;
				nameL= new ArrayList();
				passL= new ArrayList();
				
				boolean sign_up= false;
				try {
					
					input = new Scanner(new File("UserInfo.txt"));
					
					while(input.hasNextLine()) {
						sign_up=true;
						
						String line=input.nextLine();
						String lineSplit[]=line.split(",");
						
						nameL.add(lineSplit[0]);	passL.add(lineSplit[1]);
						
					}
				
				} catch (FileNotFoundException e) {
				
					e.printStackTrace();
				}
				//Scanner input =new Scanner(new File("UserInfo.txt"));
				
				boolean noName=true;
				for(String name : nameL) {
				
					if(user.equals(name)) {
						
						noName=false;
						boolean notPass=true;
						
						for(String secret: passL) {
							if(pass.equals(secret)) {
								JOptionPane.showMessageDialog(null,"You're successfully Logged in.");
								notPass=false;  break;
							}
						}
						if(notPass==true) {
							JOptionPane.showMessageDialog(null,"Wrong password!","LOGIN ERROR",JOptionPane.ERROR_MESSAGE);
							//username.setText(null);
							password.setText(null);
						}
					}
				}
				if(noName && sign_up) {
					JOptionPane.showMessageDialog(null,"Wrong username or password!\nOtherwise\n"
							+ "You are not signed in,please sign up first.","LOGIN ERROR",JOptionPane.ERROR_MESSAGE);
					//username.setText(null);
					//password.setText(null);
				}
				
				if(!sign_up) {
					JOptionPane.showMessageDialog(null,"Please sign up first.","LOGIN ERROR",JOptionPane.ERROR_MESSAGE);
					username.setText(null);
					password.setText(null);
				}
			}
		});
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD,  13));
		btnLogin.setBounds(23, 201, 79, 35);
		frame.getContentPane().add(btnLogin);
	
	//==>
		JButton btnSignUp = new JButton("Sign Up");
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username.setText(null);
				password.setText(null);
				
				SignUpForm info =new SignUpForm();
				SignUpForm.main(null);
			}
			
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD,  13));
		btnSignUp.setBounds(312, 201, 89, 35);
		frame.getContentPane().add(btnSignUp);
		
	//==>
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				username.setText(null);
				password.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD,  13));
		btnReset.setBounds(123, 201, 79, 35);
		frame.getContentPane().add(btnReset);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 44, 367, 0);
		frame.getContentPane().add(separator);
		
	//==>	
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame =new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Are you sure you want to exit?","LOGIN SYSTEM",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(224, 201, 67, 35);
		frame.getContentPane().add(btnExit);
	}
}
