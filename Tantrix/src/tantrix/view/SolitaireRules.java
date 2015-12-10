package tantrix.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SolitaireRules extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7648919233739288783L;
    JTextArea solitaireRule;
    JFrame jFrame ;
    
	public SolitaireRules(String rules) {
		// TODO Auto-generated constructor stub
		jFrame = new JFrame();
		jFrame.setSize(400, 400);
		jFrame.setTitle("Rules of Solitaire");
		solitaireRule = new JTextArea();
		solitaireRule.append(rules);
		solitaireRule.setLocation(1000, 600);
		solitaireRule.setSize(100, 100);
		jFrame.add(solitaireRule);
        jFrame.setVisible(true);
	}
}
