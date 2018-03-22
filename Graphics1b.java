package Graphics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//example of how to use Swing graphics
public class Graphics1b extends JFrame {

	public static void main(String[] args) {
		new Graphics1b();
	}

	Color NAVY = new Color(0,0,128);
	private Graphics1b(){
		//Set up JFrame
		this.setTitle("Graphics Example");
		this.setSize(800,300);
		this.setBackground(Color.BLUE);//doesn't work?!
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//set up JPanel
		/*JPanel panel = new JPanel();
		panel.setBackground(NAVY);
		
		this.add(panel);*/
		setupPanel();
		
		
		this.setLocationRelativeTo(null);//second last thing
		this.setVisible(true);//last thing you do
		
		
		
	}
	
	void setupPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(NAVY);
		
		JButton b1 = new JButton("Click me");
		b1.setFont(new Font("Arial", Font.PLAIN,24));
		b1.setBackground(Color.ORANGE);
		JLabel label1 = new JLabel("Welcome");
		panel.add(label1);
		//panel.add(b1);
		
		for(int i = 0; i < 10; i++) {
			panel.add(new MyButton("B" + i));
		}
		this.add(panel);
		label1.setForeground(Color.WHITE);
	}
	class MyButton extends JButton {
		MyButton(String t){
			this.setFont(new Font("Arial", Font.PLAIN, 24));
			this.setForeground(Color.ORANGE);
			this.setText(t);
		}
	}
	
}
