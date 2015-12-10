package tantrix.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

import tantrix.controller.TantrixController;


public class SolitaireMain extends JPanel implements MouseListener,MouseMotionListener  {

	/**
	 * Variable declaration 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame jFrame;
	static TantrixController tantrixC;
    JButton addNewTileButton;
    JButton validateButton;
    JLabel colorLabel;
    JLabel userScoreLabel;
    JTextField colorTextField;
    JTextField userScoreTextField;
    JButton viewRule;
	//private JLabel label1;
	
	/*
	 * Constructor
	 */
	public SolitaireMain() {
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
        colorTextField = new JTextField("Yellow");
        colorTextField.setBounds(80, 700, 110, 40);
        colorTextField.setEditable(false);
        this.add(colorTextField,BorderLayout.WEST);
        userScoreLabel = new JLabel("User Score");
        userScoreLabel.setLocation(400, 100);
        this.add(userScoreLabel,BorderLayout.WEST);
        userScoreTextField = new JTextField("0");
        userScoreTextField.setBounds(80, 700, 110, 40);
        userScoreTextField.setEditable(false);
        this.add(userScoreTextField,BorderLayout.WEST);
        validateButton = new JButton("Validate");
        validateButton.setBounds(80, 700, 110, 40);
        validateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				validateSolitaire(paramActionEvent);
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
	
    public void paintComponent(Graphics g){
	   	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
       tantrixC.drawDiscoveryTantrix(g2);
        
    }
	
	/*
	 * Main of SolitaireMain
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jFrame = new JFrame();
		tantrixC = TantrixController.getSingleton();
		tantrixC.setDiscovery(false);
		tantrixC.drawBGInit();
		tantrixC.polyInit();
		jFrame = new JFrame();
		jFrame.setSize(1000, 800);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("Enjoy the solitaire game");
		jFrame.add(new SolitaireMain());
		jFrame.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		tantrixC.mouseDraggedEvent(event);
		jFrame.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		tantrixC.managedMouseEventInit();
	}
	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		tantrixC.mouseReleasedEvent(event);
		jFrame.repaint();
	}

	public void addNewTantrixTile(ActionEvent paramActionEvent){
		tantrixC.addNewTantrixTile();
		jFrame.repaint();
	}
	
	public void validateSolitaire(ActionEvent paramActionEvent){
		int validateResult = tantrixC.validateTantrixSolitaire();
		JOptionPane.showMessageDialog(null, "you can try with next puzzle");
		userScoreTextField.setText(validateResult+"");
}
	
	public void setTextField(Color color){
		colorTextField.setText(color.toString());
	}
	
	public void viewRule(ActionEvent paramActionEvent){
		@SuppressWarnings("unused")
		SolitaireRules dr = new SolitaireRules(tantrixC.getRulesOfSolitaire());
	}
	
}
