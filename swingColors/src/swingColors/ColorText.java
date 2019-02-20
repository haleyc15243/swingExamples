package swingColors;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ColorText extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbl;
	private JLabel statusbar;
	private JTextField field;
	public Color col = Color.red;
	
	public ColorText() {
		initUI();
	}
	
	private void initUI() {
		field = new JTextField(15);
		lbl = new JLabel();
		
		field.getDocument().addDocumentListener(new MyDocumentListener());
		
		JComponent[] stuff = {field,lbl};
		createLayout(stuff);
		
		setTitle("Colorful Text");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class MyDocumentListener implements DocumentListener {
		
		private String text;
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			updateLabel(e);
		}
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			updateLabel(e);
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
		}
		
		private void updateLabel(DocumentEvent e) {
			
			Document doc = e.getDocument();
			int len = doc.getLength();
			
			try {
				text = doc.getText(0,  len);
			} catch (BadLocationException ex) {
				Logger.getLogger(ColorText.class.getName())
				.log(Level.WARNING, "Bad Location", ex);
			}
			
			lbl.setText(text);
			lbl.setForeground(col);
		}
	}
	
	private void updateColor() {
		lbl.setForeground(col);
	}
	
	private void createLayout(JComponent[] arg) {
		
		JMenuBar menubar = new JMenuBar();
		JMenu difMenu = new JMenu("Color");
		difMenu.setMnemonic(KeyEvent.VK_F);
		
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		
		ButtonGroup difGroup = new ButtonGroup();
		pane.setLayout(gl);
		
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		
		gl.setHorizontalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
						.addComponent(arg[0])
						.addComponent(arg[1])
						.addGap(250)));
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0], GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[1])
						.addGap(250)));
		
		pack();
		
		JRadioButtonMenuItem redButton = new JRadioButtonMenuItem("Red");
		redButton.setSelected(true);
		difMenu.add(redButton);
		
		redButton.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				lbl.setForeground(Color.red);
				col = Color.red;
			}
		});
		
		JRadioButtonMenuItem greenButton = new JRadioButtonMenuItem("Green");
		difMenu.add(greenButton);
		greenButton.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				lbl.setForeground(Color.green);
				col = Color.green;
			}
		});
		
		JRadioButtonMenuItem blueButton = new JRadioButtonMenuItem("Blue");
		difMenu.add(blueButton);
		
		blueButton.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				lbl.setForeground(Color.blue);
				col = Color.BLUE;
			}
		});
		
		difGroup.add(redButton);
		difGroup.add(greenButton);
		difGroup.add(blueButton);
		
		menubar.add(difMenu);
		
		setJMenuBar(menubar);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			ColorText ex = new ColorText();
			ex.setVisible(true);
		});
	}
}
