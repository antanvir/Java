package compositePattern;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class MakeShapes extends JPanel {

	/**
	 * Create the panel.
	 */
	public static JFrame frame;
	public Graphics g2 = getGraphics(); ;
	
	public MakeShapes() {
		
		JLabel label = new JLabel("<html>1. For Flag & Quad add points 'CLOCK-WISE'<br>"
						+ "2. For Circle add CENTER only [ radius predefined (100) ] <html>");  
	    label.setBounds(200, 0, 500, 80);
	    label.setForeground(Color.WHITE);
	    frame.add(label);
		
		JButton btnRect = new JButton("DRAW QUAD");
		btnRect.setBounds(51, 402, 120, 23);
		btnRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Quad quad = new Quad();
				quad.setX1(mousePos[0][0]);		quad.setY1(mousePos[0][1]);
				quad.setX2(mousePos[1][0]);		quad.setY2(mousePos[1][1]);
				quad.setX3(mousePos[2][0]);		quad.setY3(mousePos[2][1]);
				quad.setX4(mousePos[3][0]);		quad.setY4(mousePos[3][1]);
				
				quad.draw(getGraphics());
			}
		});
		//setLayout(null);
		frame.add(btnRect);
		
		JButton btnFlag = new JButton("DRAW FLAG");
		btnFlag.setBounds(210, 402, 120, 23);
		btnFlag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlagLikeShape flag = new FlagLikeShape();
				flag.setX1(mousePos[0][0]);		flag.setY1(mousePos[0][1]);
				flag.setX2(mousePos[1][0]);		flag.setY2(mousePos[1][1]);
				flag.setX3(mousePos[2][0]);		flag.setY3(mousePos[2][1]);
				flag.setX4(mousePos[3][0]);		flag.setY4(mousePos[3][1]);
				
				flag.draw(getGraphics());
			}
		});
		frame.add(btnFlag);
		
		JButton btnCircle = new JButton("DRAW CIRCLE");
		btnCircle.setBounds(357, 402, 120, 23);
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x, y;
				x = mousePos[0][0] - 40;
				y = mousePos[0][1] - 40;
				Circle circle = new Circle(x, y, 100);
				circle.draw(getGraphics());
			}
		});
		frame.add(btnCircle);
		
		JButton btnLine = new JButton("DRAW LINE");
		btnLine.setBounds(512, 402, 120, 23);
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Line line = new Line(mousePos[0][0], mousePos[0][1], mousePos[1][0], mousePos[1][1]);
				line.draw(getGraphics());
			}
		});
		frame.add(btnLine);
		
		
		JButton btnDraw = new JButton("REFRESH WINDOW");
		btnDraw.setBounds(200, 450, 255, 25);
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g2 = getGraphics();
				g2.setColor(Color.DARK_GRAY);
				g2.fillRect(0, 90, getWidth(), 310);
				
				i = 0;
			}
		});
		frame.add(btnDraw);
		
		
		frame.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				int x, y;
				x =  event.getX() - 5;
				y = event.getY() - 20;
			
				addPointsToArray( x,  y);
				//paintComponent((Graphics)g2, (int)event.getX(),(int) event.getY());
				Graphics g = getGraphics();
				g.setColor(Color.WHITE);
				g.fillOval(x, y, 5, 5);
			}

			
		});

	}
	
	/*
	public void paintComponent(Graphics g2, int x, int y) {
		//g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fillOval(x, y, 10, 10);
		//System.out.println("X: " + x + " Y: " + y);
	}
	*/
	
	int mousePos[][] = new int [15][2];
	int i = 0;
	
	public void addPointsToArray(int x, int y) {
		
		mousePos[i][0] = x;
		mousePos[i][1] = y;
		//System.out.println("X: " + x + " Y: " + y);
		i++;
	}
	
	public void paint(Graphics g) {
		g2 =  g;
		
		g2.setColor(Color.DARK_GRAY);
		g2.fillRect(0, 0, getWidth(), getHeight());
		//g2.setColor(Color.BLUE);
		//g2.fillOval(100, 150, 20, 20);
	}
	
	public static void main(String[] args) {
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    frame = new JFrame("Draw Different Shapes");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(750, 550);
	 
	    MakeShapes panel = new MakeShapes();
	 
	    frame.getContentPane().add(panel);
	 
	    frame.setVisible(true);
	  }
}
