package nBodySimulator;

import java.awt.Color;

public class Body {
	int size;
	double v, x, y, z;
	Color c;
	
	public Body() {
		size = 10;
	}
	
	public Body(int size, double speed) {
		this.size = size;
		v = speed;
		c = Color.red;
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
		System.out.println("Getting location: " + x);
		return loc;
	}
	
	public void setLoc(double[] loc) {
		x = loc[0];
		y = loc[1];
		z = loc[2];
		System.out.println("Updating location to: " + x);
	}
}
