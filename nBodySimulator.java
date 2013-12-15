package nBodySimulator;

import java.awt.Color;

import javax.swing.JFrame;

public class nBodySimulator {
	public static void main(String[] args) throws InterruptedException {
		Body[] bodys = new Body[128];
		bodys[0] = new Body(20, 1);
		bodys[1] = new Body();
		double loc[] = {200.0, 200.0, 0.0};
		double speed[] = {0.0, 0.0};
		double loc2[] = {600.0, 672.0, 0.0};
		double speed2[] = {-4.0, -6.0};
		double G = 6.67 * 10e-11;
		bodys[0].setLoc(loc);
		bodys[0].setSpeed(speed);
		bodys[0].setMass(4000000000000.0);
		bodys[1].setLoc(loc2);
		bodys[1].setSpeed(speed2);
		bodys[1].setMass(3);
		System.out.println("Body size: " + bodys[0].getSize());
		System.out.println("Distance: " + bodys[0].getDistance(bodys[1]));
		System.out.println("Bodys size: " + bodys.length);

        BodyCanvas canvas = new BodyCanvas(bodys);
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.setBackground(Color.black);
        for(int i = 0; i < 2000; i++) {
        	double fx0, fy0, fx1, fy1, dist, F, ax0, ay0, ax1, ay1;
        	double[] loc0 = bodys[0].getLoc();
        	double[] loc1 = bodys[1].getLoc();
        	double[] s0 = bodys[0].getSpeed();
        	double[] s1 = bodys[1].getSpeed();
         	dist = bodys[0].getDistance(bodys[1]);
        	F = G * bodys[0].getMass() * bodys[1].getMass();
        	System.out.println("F: " + F);
        	F /= Math.pow(dist, 2);
        	fx0 = F * ((loc1[0] - loc0[0]) / dist);
        	fy0 = F * ((loc1[1] - loc0[1]) / dist);
        	fx1 = F * ((loc0[0] - loc1[0]) / dist);
        	fy1 = F * ((loc0[1] - loc1[1]) / dist);
        	System.out.println("fx0: " + fx0);
        	ax0 = fx0 / bodys[0].getMass();
        	ay0 = fy0 / bodys[0].getMass();
        	ax1 = fx1 / bodys[1].getMass();
        	ay1 = fy1 / bodys[1].getMass();
        	System.out.println("ax0: " + ax0);
        	s0[0] += ax0;
        	s0[1] += ay0;
        	s1[0] += ax1;
        	s1[1] += ay1;
        	bodys[0].setSpeed(s0);
        	bodys[1].setSpeed(s1);
        	bodys[0].update();
        	bodys[1].update();
        	canvas.repaint();
        	Thread.sleep(50);
        }
	}
}
