package tantrix.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DiscoveryRules extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3000260885325747693L;
    JTextArea discoveryRule;
    JFrame jFrame ;
	public DiscoveryRules(String rules) {
		// TODO Auto-generated constructor stub
		jFrame = new JFrame();
		jFrame.setSize(400, 400);
		jFrame.setTitle("Rules of Discovery");
        discoveryRule = new JTextArea();
        discoveryRule.append(rules);
        discoveryRule.setLocation(1000, 600);
        discoveryRule.setSize(100, 100);
        jFrame.add(discoveryRule);
        jFrame.setVisible(true);
    }
}
