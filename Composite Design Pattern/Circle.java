package compositePattern;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements IShape{
	
	int x, y, radius;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/*
	public void paint(Graphics g) {
		System.out.println("X: "+x +" Y: "+ y + " R: "+ radius);
		g.setColor(Color.RED);
		System.out.println(x + y + radius);
		g.drawOval(x, y, radius, radius);
	}
	*/
	
	public void draw(Graphics g) {
		//Graphics g = null;
		//this.paint(g);
		g.setColor(Color.RED);
		g.fillOval(x, y, radius, radius);
	}
}
