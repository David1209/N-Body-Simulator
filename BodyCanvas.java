package nBodySimulator;

import java.awt.*;
import javax.swing.*;
public class BodyCanvas extends Canvas {
	Body[] bodys;
	
    public BodyCanvas() {
    }
 
    public BodyCanvas(Body[] bodys) {
    	this.bodys = bodys;
    }
    public void paint(Graphics graphics) {
        /* We would be using this method only for the sake
         * of brevity throughout the current section. Note
         * that the Graphics class has been acquired along
         * with the method that we overrode. */
    	
        for(int i = 0; i < 1; i++) {
        	double loc[] = bodys[i].getLoc();
        	graphics.setColor(bodys[i].getColor());
        	graphics.fillOval((int)loc[0], (int)loc[1], bodys[i].getSize(), bodys[i].getSize());
        }
        
    }
}
