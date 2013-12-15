package nBodySimulator;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class nBodySimulator {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Body> bodys = new ArrayList<Body>();
//		Body b = new Body(20, 1.4960e+11, 0, 0.0000e+00, 2.9800e+04, 5.9740e+24); // earth
//		Body b2 = new Body(20, 2.2790e+11, 0, 0.0000e+00, 2.4100e+04, 6.4190e+23); // mars
//		Body b3 = new Body(30, 0, 0, 0.0000e+00, 3.5000e+04, 1.9890e+30); // sun
//		b.setColor(Color.blue);
//		b2.setColor(Color.red);
//		b3.setColor(Color.yellow);
//		bodys.add(b);
//		bodys.add(b2);
//		bodys.add(b3);
		Body b = new Body(20, 0.0e00, 4.5e10, 1.0e7, 0.0e00, 1.5e30);
		Body b2 = new Body(20, 0.0e00, -4.5e10, -1.0e7, 0.0e00, 1.5e30);
		b.setColor(Color.blue);
		b2.setColor(Color.red);
		bodys.add(b);
		bodys.add(b2);
		double G = 6.67 * 10e-11;
		double timestep = 1e5;
		System.out.println("Bodys size: " + bodys.size());

        BodyCanvas canvas = new BodyCanvas(bodys, 12e10, 700);
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.setBackground(Color.black);
        for(int i = 0; i < 200000; i++) {
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
        		ax = fx / bodys.get(j).getMass() * timestep;
        		ay = fy / bodys.get(j).getMass() * timestep;
        		s[0] += ax;
            	s[1] += ay;
            	bodys.get(j).setSpeed(s);
        	}
        	for(int j = 0; j < bodys.size(); j ++) {
        		bodys.get(j).update();
        	}
        	if(i % 8 == 0) {
        		canvas.repaint();
        		System.out.println("I: " + i);
        		Thread.sleep(10);
        	}
        	
        }
	}
}
