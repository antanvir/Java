package SignUp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.awt.event.ActionEvent;

public class SignUpForm {

	private JFrame frame;
	private JTextField s_name;
	private JTextField mail;
	private JTextField us_name;
	private JTextField s_pass;
	private JTextField cnf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm window = new SignUpForm();
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
	public SignUpForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("SIGN UP FORM");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(130, 21, 189, 29);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(27, 104, 122, 29);
		frame.getContentPane().add(lblName);
		
		JLabel lblmail = new JLabel("Email");
		lblmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmail.setBounds(27, 155, 122, 29);
		frame.getContentPane().add(lblmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(27, 209, 122, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(27, 264, 122, 29);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblconfirmPass = new JLabel("Confirm Password");
		lblconfirmPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblconfirmPass.setBounds(27, 315, 138, 35);
		frame.getContentPane().add(lblconfirmPass);
		
		JButton btnNewButton = new JButton("Finish");
		
	//==>	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = us_name.getText();
				String upass = s_pass.getText();
				String cpass = cnf_pass.getText();
				
				if(!upass.equals(cpass)) {
					JOptionPane.showMessageDialog(null,"Password mismatched.\nConfirm again.");
					cnf_pass.setText(null);
					s_pass.setText(null);
				}
				
				else {
					String uinfo = uname+","+upass+"\n";
					
					try {   
	
						 Files.write(Paths.get("UserInfo.txt"), uinfo.getBytes(), StandardOpenOption.APPEND);
	
				    } catch (IOException ex) { 
				    	
				        ex.printStackTrace();
				    }
					
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(269, 424, 133, 35);
		frame.getContentPane().add(btnNewButton);
		
		s_name = new JTextField();
		s_name.setBounds(189, 104, 213, 29);
		frame.getContentPane().add(s_name);
		s_name.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(189, 161, 213, 29);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		us_name = new JTextField();
		us_name.setBounds(186, 215, 216, 29);
		frame.getContentPane().add(us_name);
		us_name.setColumns(10);
		
		s_pass = new JTextField();
		s_pass.setBounds(185, 264, 217, 29);
		frame.getContentPane().add(s_pass);
		s_pass.setColumns(10);
		
		cnf_pass = new JTextField();	
		cnf_pass.setBounds(186, 324, 216, 29);
		frame.getContentPane().add(cnf_pass);
		cnf_pass.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(27, 70, 375, 12);
		frame.getContentPane().add(separator);
	}
}
