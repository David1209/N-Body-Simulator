package nBodySimulator;

import java.awt.Color;

import javax.swing.JFrame;

public class nBodySimulator {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello world!");
		Body[] bodys = new Body[128];
		bodys[0] = new Body(20, 1);
		double loc[] = {1.0, 1.0, 0.0};
		bodys[0].setLoc(loc);
		System.out.println("Body size: " + bodys[0].getSize());
		

        BodyCanvas canvas = new BodyCanvas(bodys);
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.setBackground(Color.black);
        for(int i = 0; i < 2000; i++) {
        	loc[0] = i;
        	loc[1] = i * 2;
        	bodys[0].setLoc(loc);
        	canvas.repaint();
        	Thread.sleep(100);
        }
	}
}
