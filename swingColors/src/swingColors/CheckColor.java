package swingColors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class CheckColor extends JFrame {
	
	private JLabel statusbar;
	private JLabel colorbar;
	
	public CheckColor() {
		initUI();
	}
	
	private void initUI() {
		
		colorbar = createLabel();
		colorbar.setVisible(true);
		colorbar.setOpaque(true);
		
		createMenuBar();
		
		statusbar = new JLabel("View Different Colors");
		statusbar.setBorder(BorderFactory.createEtchedBorder());
		add(statusbar, BorderLayout.SOUTH);
				
		setTitle("ColorChecker");
		setSize(360,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private JLabel createLabel() {
		JLabel label = new JLabel();
		label.setMinimumSize(new Dimension(300, 150));
		label.setBackground(Color.red);
		return label;
	}
	
	private void createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		JMenu difMenu = new JMenu("Color");
		difMenu.setMnemonic(KeyEvent.VK_F);
		
		ButtonGroup difGroup = new ButtonGroup();
		
		JPanel pane = (JPanel) getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);
		
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		
		gl.setHorizontalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
						.addComponent(colorbar)));
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup()
						.addComponent(colorbar)));
		
		JRadioButtonMenuItem redButton = new JRadioButtonMenuItem("Red");
		redButton.setSelected(true);
		difMenu.add(redButton);
		
		redButton.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				statusbar.setText("Red");
				displayColor(Color.red);
			}
		});
		
		JRadioButtonMenuItem greenButton = new JRadioButtonMenuItem("Green");
		difMenu.add(greenButton);
		greenButton.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				statusbar.setText("Green");
				displayColor(Color.GREEN);
			}
		});
		
		JRadioButtonMenuItem blueButton = new JRadioButtonMenuItem("Blue");
		difMenu.add(blueButton);
		
		blueButton.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				statusbar.setText("Blue");
				displayColor(Color.BLUE);
			}
		});
		
		difGroup.add(redButton);
		difGroup.add(greenButton);
		difGroup.add(blueButton);
		
		menubar.add(difMenu);
		
		setJMenuBar(menubar);
		
		pack();
	}
	
	private void displayColor(Color col) {
		colorbar.setBackground(col);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			CheckColor ex = new CheckColor();
			ex.setVisible(true);
		});
	}
}
