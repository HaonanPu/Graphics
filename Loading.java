package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//import Graphics.TimerRotate.TimerAL;

//import Graphics.TimerRotate.TimerAL;

public class Loading implements KeyListener {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Loading();
			}
		});

	}

	static final int SIZE = 500;
	DrawingPanel mainPanel = new DrawingPanel();
	
	Timer timer;
	int t_speed = 5;
	int t_pause = 1000;
	int time;
	
	ArrayList <Balls> balls = new ArrayList();
	private int radius = 25;//!!!
	
	ArrayList <PointinloadingIcon> points = new ArrayList();
	
	
	//setup
	Loading(){
		JFrame window = new JFrame();
		window.setTitle("Loading Icon");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SIZE, SIZE);
		window.addKeyListener(this);
		window.add(mainPanel);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		points.add(new PointinloadingIcon(170,130));//point of 0	  corner1
		points.add(new PointinloadingIcon(230,130));
		points.add(new PointinloadingIcon(290,130));				//corner2
		points.add(new PointinloadingIcon(290,190));
		points.add(new PointinloadingIcon(290,250));				//corner3
		points.add(new PointinloadingIcon(230,250));
		points.add(new PointinloadingIcon(170,250));				//corner4
		points.add(new PointinloadingIcon(170,190));//point of 7
		
		balls.add(new Balls(points.get(0).x,points.get(0).y,radius,radius, Color.RED));			//first point 
		balls.add(new Balls(points.get(1).x,points.get(1).y,radius,radius, Color.ORANGE));
		balls.add(new Balls(points.get(2).x,points.get(2).y,radius,radius, Color.YELLOW));
		balls.add(new Balls(points.get(3).x,points.get(3).y,radius,radius, Color.GREEN));
		balls.add(new Balls(points.get(4).x,points.get(4).y,radius,radius, Color.CYAN));
		balls.add(new Balls(points.get(5).x,points.get(5).y,radius,radius, Color.BLUE));
		balls.add(new Balls(points.get(6).x,points.get(6).y,radius,radius, Color.DARK_GRAY ));
		balls.add(new Balls(points.get(7).x,points.get(7).y,radius,radius, Color.BLACK));		//7th point
		//all timer stuff (start after window is shown)
		
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0); //if we don't do this, then restarting the timer is delayed

		}
			/********************************************/
			/*  Inner class for Timer's ActionListener  */
			/********************************************/
			private class TimerAL implements ActionListener{

				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					time++;
				    for(Balls b : balls) {
				    	
				        if(b.x >= 170 && b.x < 290 && b.y == 130) {
				        	b.x += 2;
				        } 
				        if(b.x >= 290 && b.y >= 130 && b.y < 250) {
				              b.y += 2;
				        }
				        if (b.y >= 250 && b.x <= 290 && b.x > 170) {
				        	b.x -= 2;
				        } 
				        if (b.x <= 170 && b.y <= 250 && b.y >= 130) {
			            	 b.y -= 2;
			            }
				    }
				    mainPanel.repaint();
				    
					}
				
			}
	
	
	
	private class DrawingPanel extends JPanel {
		//Draw all objects here
		int n = 0;
		boolean decrease = true;
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			for(Balls ball : balls) {
				g2d.setColor(ball.getColor());
				g2d.fillOval(ball.x + n,ball.y + n,ball.getWidth() - 2*n, ball.getHeight() - 2*n);
			}//end of the circles staff
			g.drawString("TIME1=" + time*t_speed, 50,50);
			g.drawString("Loading...", 220,310);
			g2d.dispose(); //only dispose of graphics objects that you have created	
			
			if (time % 5 == 0) {
				if (decrease)
					n++;
				else
					n--;
			}
			if (n >= radius / 5) {
				decrease = false;
			}
			if (n <= 0) {
				decrease = true;
			}
		}
			
    }
		
		
		
	
	
	
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.restart();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
