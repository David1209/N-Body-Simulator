/*
 * N-Body Simulator
 * By David van Erkelens, 10264019
 * December 15th, 2013
 */

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class nBodySimulator {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Body> bodies = new ArrayList<Body>();
		double G = 6.67 * 10e-11;
		double timestep = 1e5;
		double worldsize = 7e+11;
		int step = 50;
		if(args.length != 0 && "two".equals(args[0])) {
			Body b = new Body(20, 0.0e00, 4.5e10, 1.0e7, 0.0e00, 1.5e30);
			Body b2 = new Body(20, 0.0e00, -4.5e10, -1.0e7, 0.0e00, 1.5e30);
			b.setColor(Color.blue);
			b2.setColor(Color.red);
			bodies.add(b);
			bodies.add(b2);
			worldsize = 10e10;
			step = 10;
		} else {
			Body b = new Body(20, 1.4960e+11, 0, 0.0000e+00, 2.9800e+7, 5.9740e+24); // earth
			Body b2 = new Body(20, 2.2790e+11, 0, 0.0000e+00, 2.4100e+7, 6.4190e+23); // mars
			Body b3 = new Body(30, 0, 0, 0.0000e+00, 3.5000e+00, 1.9890e+30); // sun
			Body b4 = new Body(20, 1.0820e+11,  0.0000e+00,  0.0000e+00,  3.5000e+7,  4.8690e+24); // venus
			Body b5 = new Body(20, 5.7900e+10,  0.0000e+00,  0.0000e+00,  4.7900e+7,  3.3020e+23); // mercury
			b.setColor(Color.blue);
			b2.setColor(Color.red);
			b3.setColor(Color.yellow);
			b4.setColor(Color.pink);
			b5.setColor(Color.orange);
			bodies.add(b);
			bodies.add(b2);
			bodies.add(b3);
			bodies.add(b4);
			bodies.add(b5);
		}

        BodyPanel canvas = new BodyPanel(bodies, worldsize, 700);
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.setBackground(Color.black);
        int i = 0;
        while(true) {
        	for(int j = 0; j < bodies.size(); j ++) {
        		double fx = 0, fy = 0, ax = 0, ay = 0;
        		double[] s = bodies.get(j).getSpeed();
        		for(int k = 0; k < bodies.size(); k++) {
        			if(j == k) continue;
        			double dist, F;
        			double[] locj = bodies.get(j).getLoc();
        			double[] lock = bodies.get(k).getLoc();
        			dist = bodies.get(j).getDistance(bodies.get(k));
        			F = G * bodies.get(j).getMass() * bodies.get(k).getMass();
        			F /= Math.pow(dist, 2);
        			fx += F * ((lock[0] - locj[0]) / dist);
        			fy += F * ((lock[1] - locj[1]) / dist);
        		}
        		ax = fx / bodies.get(j).getMass() * timestep;
        		ay = fy / bodies.get(j).getMass() * timestep;
        		s[0] += ax;
            	s[1] += ay;
            	bodies.get(j).setSpeed(s);
        	}
        	for(int j = 0; j < bodies.size(); j ++) {
        		bodies.get(j).update();
        	}
        	if(i % step == 0) {
        		canvas.repaint();
        		Thread.sleep(10);
        	}
        	i++;
        }
	}
}
