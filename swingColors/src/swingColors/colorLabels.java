package swingColors;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

class MyLabel extends JLabel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyLabel() {
        super("", null, LEADING);
    }

    @Override
    public boolean isOpaque() {
        return true;
    }
}

public class colorLabels extends JFrame{
	
	JPanel pane;
	JButton quitButton;
	
	public colorLabels() {
        initUI();
    }

    private void initUI() {

        Color[] stdCols = { Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN,
        		Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
        
        String[] colorNames = {"Blue", "Cyan", "Dark Gray", "Green", "Magenta",
        		"Orange", "Pink", "Red", "Yellow"};
        int spot = 0;

        ArrayList<JLabel> labels = new ArrayList<JLabel>();

        for (Color col : stdCols) {

            JLabel lbl = createColouredLabel(col);
            lbl.setToolTipText(colorNames[spot]);
            spot++;
            labels.add(lbl);
        }
        
        quitButton = new JButton("Quit!");
        
        quitButton.addActionListener((event) -> System.exit(0));

        createLayout(labels.toArray(new JLabel[labels.size()]));
        

        setTitle("Guess the color!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel createColouredLabel(Color col) {

        JLabel lbl = new MyLabel();
        lbl.setMinimumSize(new Dimension(90, 40));
        lbl.setBackground(col);

        return lbl;
    }

    private void createLayout(JLabel[] labels) {

        pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(labels[3])
                        .addComponent(labels[4])
                        .addComponent(labels[5]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8])
                        .addComponent(quitButton))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(labels[3])
                        .addComponent(labels[4])
                        .addComponent(labels[5]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8])
                        .addComponent(quitButton))
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            colorLabels ex = new colorLabels();
            ex.setVisible(true);
        });
    }

}
