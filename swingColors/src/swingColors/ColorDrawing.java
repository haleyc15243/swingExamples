package swingColors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawPanel extends JPanel {
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Color[] colors = {Color.red,Color.green,Color.yellow,Color.MAGENTA,Color.black};
		
		int counter = 0;
		g2d.setColor(colors[counter]);
		
		for (int i=0; i <= 100000; i++) {
			
			Dimension size = getSize();
			Insets insets = getInsets();
			
			int w = size.width - insets.left - insets.right;
			int h = size.height - insets.top - insets.bottom;
			
			Random r = new Random();
			int x = Math.abs(r.nextInt()) % w;
			int y = Math.abs(r.nextInt()) % h;
			g2d.drawLine(x, y, x, y);
			
			counter++;
			if (counter == 5) {
				counter = 0;
			}
			g2d.setColor(colors[counter]);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		doDrawing(g);
	}
}

public class ColorDrawing extends JFrame {
	
	public ColorDrawing() {
		initUI();
	}
	
	private void initUI() {
		
		DrawPanel drawPanel = new DrawPanel();
		add(drawPanel);
		
		setSize(350, 250);
		setTitle("Points");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			ColorDrawing ex = new ColorDrawing();
			ex.setVisible(true);
		});
	}
}
