package nBodySimulator;

import java.awt.Color;
import java.util.ArrayList;

public class Body {
	int size;
	double vx, vy, x, y, mass;
	Color c;
	ArrayList<double[]> hist = new ArrayList<double[]>();
	
	public Body() {
		this(20, 0.0, 0.0, 0.0, 0.0, 2000.0);
	}
	
	public Body(int size, double x, double y, double vx, double vy, double mass) {
		this.size = size;
		c = Color.red;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.mass = mass;
	}
	
	public ArrayList<double[]> getHistory() {
		return hist;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
	
	public Color getColor() {
		return c;
	}
	
	public double[] getLoc() {
		double[] loc = {x, y};
//		System.out.println("Getting location: " + x);
		return loc;
	}
	
	public void setLoc(double[] loc) {
		x = loc[0];
		y = loc[1];
		double[] a = {x, y};
		hist.add(a);
//		System.out.println("Updating location to: " + x);
	}
	
	public double getDistance(Body b) {
		double[] locb = b.getLoc();
		return Math.sqrt(Math.pow(Math.abs(locb[0] - x), 2) + Math.pow(Math.abs(locb[1] - y), 2));
	}
	
	public void setSpeed(double[] s) {
		this.vx = s[0];
		this.vy = s[1];
	}
	
	public double[] getSpeed() {
		double[] s = {vx, vy};
		return s;
	}
	
	public void update() {
		x += vx;
		y += vy;
		double[] a = {x, y};
		hist.add(a);
	}
	
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public double getMass() {
		return mass;
	}
}
