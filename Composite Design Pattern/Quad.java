package compositePattern;

import java.util.ArrayList; 
import java.util.List; 
import java.awt.Color;
import java.awt.Graphics;


public class Quad implements IShape{
	private List<IShape> componentList = new ArrayList<IShape>();
	private int x1,y1, x2,y2, x3,y3, x4,y4;
	
	public Quad() {
		
	}
	
	public void setX1(int x) { x1 = x; }
	public int getX1() { return x1; }
	public void setY1(int y) { y1 = y; }
	public int getY1() { return y1; }
	
	public void setX2(int x) { x2 = x; }
	public int getX2() { return x2; }
	public void setY2(int y) { y2 = y; }
	public int getY2() { return y2; }
	
	public void setX3(int x) { x3 = x; }
	public int getX3() { return x3; }
	public void setY3(int y) { y3 = y; }
	public int getY3() { return y3; }
	
	public void setX4(int x) { x4 = x; }
	public int getX4() { return x4; }
	public void setY4(int y) { y4 = y; }
	public int getY4() { return y4; }
	
	public void addComponents() {
		
		componentList.add(new Line(getX1(), getY1(), getX2(), getY2()));
		componentList.add(new Line(getX2(), getY2(), getX3(), getY3()));
		componentList.add(new Line(getX3(), getY3(), getX4(), getY4()));
		componentList.add(new Line(getX4(), getY4(), getX1(), getY1()));
		
	}
	
	public void draw(Graphics g) {
		
		this.addComponents();
		
		for(IShape component: componentList) {
			component.draw(g);
		}
	}
}
