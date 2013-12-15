package nBodySimulator;

import java.awt.*;
import java.util.ArrayList;

public class BodyCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	ArrayList<Body> bodys;
	double worldsize;
	int windowsize;
	
    public BodyCanvas() {
    }
 
    public BodyCanvas(ArrayList<Body> bodys, double worldsize, int windowsize) {
    	this.bodys = bodys;
    	this.worldsize = worldsize;
    	this.windowsize = windowsize;
    }
    public void paint(Graphics graphics) {    	
        for(int i = 0; i < bodys.size(); i++) {
        	double loc[] = world2screen(bodys.get(i).getLoc());
        	ArrayList<double[]> hist = bodys.get(i).getHistory();
        	graphics.setColor(Color.white);
        	boolean set = false;
        	double[] prev = {0.0, 0.0};
        	for(double[] h : hist) {
        		double[] h1 = world2screen(h);
        		if(set) {
        			graphics.drawLine((int)prev[0], (int)prev[1], (int)h1[0], (int)h1[1]);
        		}
        		prev = h1;
        		set = true;
        	}
        	graphics.setColor(bodys.get(i).getColor());
        	int size = bodys.get(i).getSize();
        	graphics.fillOval((int)(loc[0] - 0.5*size), (int)(loc[1] - 0.5*size), size, size);
        }
        
    }
    
    private double[] world2screen(double[] l) {
    	double[] w = new double[2];
//    	w[0] = (l[0] / worldsize) * windowsize;
//    	System.out.println("Scaling " + l[0] + " to " + worldsize);
//    	w[1] = (l[1] / worldsize) * windowsize;
    	w[0] = ((l[0] / worldsize) * windowsize) + (0.5 * windowsize);
    	w[1] = ((l[1] / worldsize) * windowsize) + (0.5 * windowsize);
//    	System.out.println("Scaling " + l[1] + " to " + w[1]);
    	return w;
    }
}
