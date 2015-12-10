package tantrix.view;

//import java.awt.Color;
import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.RenderingHints;
//import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;





//import java.awt.geom.Ellipse2D;
//import java.awt.geom.GeneralPath;
//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Map;
import javax.swing.JButton;
//import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;





//import javax.swing.JTextArea;
import javax.swing.JTextField;

import tantrix.controller.TantrixController;

public class DiscoveryMain extends JPanel implements MouseListener,MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6497129136319021509L;
    private static JFrame jFrame;
    static TantrixController tantrixC;
    JButton addNewTileButton;
    JButton validateButton;
    JLabel colorLabel;
    JTextField colorTextField;
    JButton viewRule;
     
	
    public DiscoveryMain() {
		// TODO Auto-generated constructor stub
        addMouseMotionListener(this);
        addMouseListener(this);
        
        addNewTileButton = new JButton("Add New Tile");
        addNewTileButton.setBounds(80, 410, 110, 40);
        addNewTileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				addNewTantrixTile(paramActionEvent);
			}
		});
        this.add(addNewTileButton,BorderLayout.WEST);
        colorLabel = new JLabel("Built Color");
        colorLabel.setLocation(400, 100);
        this.add(colorLabel,BorderLayout.WEST);
        colorTextField = new JTextField(tantrixC.getCurrentWorkingColorName());
        colorTextField.setBounds(80, 700, 110, 40);
        colorTextField.setEditable(false);
        this.add(colorTextField,BorderLayout.WEST);
        validateButton = new JButton("Validate");
        validateButton.setBounds(80, 700, 110, 40);
        validateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				validateDiscovery(paramActionEvent);
			}
		});
        this.add(validateButton,BorderLayout.WEST);
        viewRule = new JButton("View Rule");
        viewRule.setBounds(80, 700, 110, 40);
        viewRule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				viewRule(paramActionEvent);
			}
		});
        this.add(viewRule);
       

	}
    @Override
	public void paintComponent(Graphics g){
	   	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tantrixC.drawDiscoveryTantrix(g2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tantrixC = TantrixController.getSingleton();
		tantrixC.setDiscovery(true);
		tantrixC.drawBGInit();
		tantrixC.polyInit();
		jFrame = new JFrame();
		jFrame.setSize(1000, 800);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("Enjoy the discovery game");
		jFrame.add(new DiscoveryMain());
		jFrame.setVisible(true);
	}
	@Override
	public void mouseDragged(MouseEvent event) {
		tantrixC.mouseDraggedEvent(event);
		jFrame.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		tantrixC.mouseClickEvent(event);
		jFrame.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		tantrixC.managedMouseEventInit();
	}
	@Override
	public void mouseReleased(MouseEvent event) {
		tantrixC.mouseReleasedEvent(event);
		jFrame.repaint();
	}
	
	
	public void addNewTantrixTile(ActionEvent paramActionEvent){
		tantrixC.addNewTantrixTile();
		colorTextField.setText(tantrixC.getCurrentWorkingColorName());
		jFrame.repaint();
		addNewTileButton.setVisible(false);
		//System.out.println("Add new tantrix tile action performed");
	}
	
	public void validateDiscovery(ActionEvent paramActionEvent){
		boolean validateResult = tantrixC.validateTantrixDiscovery();
		if(validateResult){
			JOptionPane.showMessageDialog(null, "You are win, you can try with next puzzle");
			addNewTileButton.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "Check the puzzle");
		}
	}
	
	public void viewRule(ActionEvent paramActionEvent){
		@SuppressWarnings("unused")
		DiscoveryRules dr = new DiscoveryRules(tantrixC.getRulesOfDiscovery());
	}

}
