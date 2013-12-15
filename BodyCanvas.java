package nBodySimulator;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class BodyCanvas extends Canvas {
	Body[] bodys;
	
    public BodyCanvas() {
    }
 
    public BodyCanvas(Body[] bodys) {
    	this.bodys = bodys;
    }
    public void paint(Graphics graphics) {    	
        for(int i = 0; i < 2; i++) {
        	double loc[] = bodys[i].getLoc();
        	ArrayList<double[]> hist = bodys[i].getHistory();
        	graphics.setColor(Color.white);
        	boolean set = false;
        	double[] prev = {0.0, 0.0};
        	for(double[] h : hist) {
        		if(set) {
        			graphics.drawLine((int)prev[0], (int)prev[1], (int)h[0], (int)h[1]);
        		}
        		prev = h;
        		set = true;
        	}
        	graphics.setColor(bodys[i].getColor());
        	int size = bodys[i].getSize();
        	graphics.fillOval((int)(loc[0] - 0.5*size), (int)(loc[1] - 0.5*size), size, size);
        }
        
    }
}
