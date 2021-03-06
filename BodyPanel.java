/*
 * N-Body Simulator
 * By David van Erkelens, 10264019
 * December 15th, 2013
 */

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BodyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Body> bodys;
	double worldsize;
	int windowsize;
	
    public BodyPanel() {
    }
 
    public BodyPanel(ArrayList<Body> bodys, double worldsize, int windowsize) {
    	this.bodys = bodys;
    	this.worldsize = worldsize;
    	this.windowsize = windowsize;
    }
    public void paintComponent(Graphics graphics) { 
    	graphics.setColor(Color.black);
    	graphics.fillRect(0,0,windowsize,windowsize);
        for(int i = 0; i < bodys.size(); i++) {
        	double loc[] = world2screen(bodys.get(i).getLoc());
       		//ArrayList<double[]> hist = bodys.get(i).getHistory();
        	//graphics.setColor(Color.white);
       		//boolean set = false;
       		//double[] prev = {0.0, 0.0};
       	    /* History drawing commented because of performance issues
       		for(double[] h : hist) {
	       		double[] h1 = world2screen(h);
	       		if(set) {
	       			graphics.drawLine((int)prev[0], (int)prev[1], (int)h1[0], (int)h1[1]);
	       		}
	       		prev = h1;
	       		set = true;
	       	}*/
        	graphics.setColor(bodys.get(i).getColor());
        	int size = bodys.get(i).getSize();
        	graphics.fillOval((int)(loc[0] - 0.5*size), (int)(loc[1] - 0.5*size), size, size);
        }
        
    }
    
    private double[] world2screen(double[] l) {
    	double[] w = new double[2];
    	w[0] = ((l[0] / worldsize) * windowsize) + (0.5 * windowsize);
    	w[1] = ((l[1] / worldsize) * windowsize) + (0.5 * windowsize);
    	return w;
    }
}
