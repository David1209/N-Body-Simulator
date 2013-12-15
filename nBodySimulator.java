package nBodySimulator;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class nBodySimulator {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Body> bodys = new ArrayList<Body>();
		Body b = new Body(20, 200.0, 200.0, 0.0, 0.0, 3400000000000.0);
		Body b2 = new Body(20, 600.0, 672.0, -4.0, -6.0, 3);
		Body b3 = new Body(20, 10.0, 567.0, 2.0, -2.5, 3);
		bodys.add(b);
		bodys.add(b2);
		bodys.add(b3);
		double G = 6.67 * 10e-11;
		System.out.println("Bodys size: " + bodys.size());

        BodyCanvas canvas = new BodyCanvas(bodys);
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.setBackground(Color.black);
        for(int i = 0; i < 2000; i++) {
        	for(int j = 0; j < bodys.size(); j ++) {
        		double fx = 0, fy = 0, ax = 0, ay = 0;
        		double[] s = bodys.get(j).getSpeed();
        		for(int k = 0; k < bodys.size(); k++) {
        			if(j == k) continue;
        			double dist, F;
        			double[] locj = bodys.get(j).getLoc();
        			double[] lock = bodys.get(k).getLoc();
        			dist = bodys.get(j).getDistance(bodys.get(k));
        			F = G * bodys.get(j).getMass() * bodys.get(k).getMass();
        			F /= Math.pow(dist, 2);
        			fx += F * ((lock[0] - locj[0]) / dist);
        			fy += F * ((lock[1] - locj[1]) / dist);
        		}
        		ax = fx / bodys.get(j).getMass();
        		ay = fy / bodys.get(j).getMass();
        		s[0] += ax;
            	s[1] += ay;
            	bodys.get(j).setSpeed(s);
        	}
        	for(int j = 0; j < bodys.size(); j ++) {
        		bodys.get(j).update();
        	}
        	canvas.repaint();
        	Thread.sleep(50);
        }
	}
}
