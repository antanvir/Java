package loginsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Jtable{

    public static void main(String[] args){
        
        // create JFrame and JTable
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(65, 105, 225));
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        /*Object[] columns = {"Id","First Name","Last Name","Age"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        */
		
		
		JLabel lblNewLabel = new JLabel("User Information Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 23, 437, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Close Table");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(40, 274, 437, 36);
		frame.getContentPane().add(btnNewButton);
		
		
		
		Object[] columns = {"User Name","Email","Password"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
       
        
        // set the model to the table
        table.setModel(model);
        
        table.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        // Font font = new Font("",1,12);
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setRowHeight(25);
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(40, 70, 437, 200);
        pane.setFont(new Font("Tahoma", Font.BOLD, 13));
        pane.setBackground(Color.LIGHT_GRAY);
        
        frame.getContentPane().setLayout(null);
        
        frame.getContentPane().add(pane);
        
        
        
        
       // Object[][] row = new Object[1000][3];
        //Object[] row = new Object[3];
        String row[] = new String[3]; 
        
        Scanner in = null;
        try {
        	in = new Scanner(new File("C:\\Users\\My-PC\\eclipse-workspace\\LogInSystem\\UserInfo.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
        String line;
        int i=0;
		while(in.hasNextLine() ) {
			
			line = in.next();
			String arr[] = line.split(",");
			/*for(String word: arr) {
				System.out.println(word);
			}*/
			/*row[i][0]=arr[0];
			row[i][1]=arr[1];
			row[i][2]=arr[2];
			i++;*/
			
			row[0]=arr[0];
			row[1]=arr[1];
			row[2]=arr[2];
			
			model.addRow(new Object[] {row[0],row[1],row[2]});
        }
		
		frame.setSize(560,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}
	
}
