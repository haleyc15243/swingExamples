package swingColors;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class DrawingPanel extends JPanel {
	
	private BufferedImage slate;
	private BufferedImage java;
	private BufferedImage pane;
	
	public DrawingPanel() {
		loadImages();
	}
	
	private void loadImages() {
		
		try {
			
			slate = ImageIO.read(new File("src/wood/wood1.jpg"));
			java = ImageIO.read(new File("src/wood/wood2.jpg"));
			pane = ImageIO.read(new File("src/wood/wood3.jpg"));
		
		} catch (IOException ex) {
			
			JOptionPane.showMessageDialog(this, "Could not load images",
					"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		TexturePaint slateTp1 = new TexturePaint(slate, new Rectangle(0,0,90,60));
		TexturePaint slateTp2 = new TexturePaint(slate, new Rectangle(0,0,90,60));
		TexturePaint slateTp3 = new TexturePaint(slate, new Rectangle(0,0,90,60));
		TexturePaint slateTp4 = new TexturePaint(slate, new Rectangle(0,0,90,60));
		TexturePaint javaTp1 = new TexturePaint(java, new Rectangle(0,0,90,60));
		TexturePaint javaTp2 = new TexturePaint(java, new Rectangle(0,0,90,60));
		TexturePaint javaTp3 = new TexturePaint(java, new Rectangle(0,0,90,60));
		TexturePaint javaTp4 = new TexturePaint(java, new Rectangle(0,0,90,60));
		TexturePaint paneTp1 = new TexturePaint(pane, new Rectangle(0,0,90,60));
		TexturePaint paneTp2 = new TexturePaint(pane, new Rectangle(0,0,90,60));
		TexturePaint paneTp3 = new TexturePaint(pane, new Rectangle(0,0,90,60));
		TexturePaint paneTp4 = new TexturePaint(pane, new Rectangle(0,0,90,60));
	
		g2d.setPaint(slateTp1);
		g2d.fillRect(10, 15, 90, 60);
		g2d.setPaint(slateTp2);
		g2d.fillRect(100, 15, 90, 60);
		g2d.setPaint(slateTp3);
		g2d.fillRect(190, 15, 90, 60);
		g2d.setPaint(slateTp4);
		g2d.fillRect(280, 15, 90, 60);
		
		g2d.setPaint(javaTp1);
		g2d.fillRect(10, 75, 90, 60);
		g2d.setPaint(javaTp2);
		g2d.fillRect(100, 75, 90, 60);
		g2d.setPaint(javaTp3);
		g2d.fillRect(190, 75, 90, 60);
		g2d.setPaint(javaTp4);
		g2d.fillRect(280, 75, 90, 60);

		g2d.setPaint(paneTp1);
		g2d.fillRect(10, 135, 90, 60);
		g2d.setPaint(paneTp2);
		g2d.fillRect(100, 135, 90, 60);
		g2d.setPaint(paneTp3);
		g2d.fillRect(190, 135, 90, 60);
		g2d.setPaint(paneTp4);
		g2d.fillRect(280, 135, 90, 60);
	
		g2d.dispose();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		doDrawing(g);
	}
}

class Floor extends JFrame {
	
	public Floor() {
		initUI();
	}
	
	private void initUI() {
		
		DrawingPanel drawingPanel = new DrawingPanel();
		add(drawingPanel);
		
		setTitle("Boards");
		setSize(400,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			Floor ex = new Floor();
			ex.setVisible(true);
		});
	}
}