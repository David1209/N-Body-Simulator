package nBodySimulator;

import java.awt.Color;
import java.util.ArrayList;

public class Body {
	int size;
	double vx, vy, x, y, z, mass;
	Color c;
	ArrayList<double[]> hist = new ArrayList<double[]>();
	
	public Body() {
		this(20, 1.0);
	}
	
	public Body(int size, double speed) {
		this.size = size;
		c = Color.red;
		x = 0;
		y = 0;
		z = 0;
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
		double[] loc = {x, y, z};
//		System.out.println("Getting location: " + x);
		return loc;
	}
	
	public void setLoc(double[] loc) {
		x = loc[0];
		y = loc[1];
		z = loc[2];
		double[] a = {x, y};
		hist.add(a);
//		System.out.println("Updating location to: " + x);
	}
	
	public double getDistance(Body b) {
		double[] locb = b.getLoc();
		return Math.sqrt(Math.pow(Math.abs(locb[0] - x), 2) + Math.pow(Math.abs(locb[1] - y), 2) +  Math.pow(Math.abs(locb[2] - z), 2));
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
