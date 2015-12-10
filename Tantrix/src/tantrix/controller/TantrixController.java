package tantrix.controller;

//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
//import java.awt.Point;
//import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;

import tantrix.model.CreateBG;
import tantrix.model.CreateTile;
import tantrix.model.DrawDiscovery;
import tantrix.model.ManageMouseEvent;
import tantrix.model.Rules;
import tantrix.model.Validate;

public class TantrixController {

	private Map<Shape,Vector<GeneralPath>> tantrixTiles = new HashMap<Shape,Vector<GeneralPath>>();
	private Map<Shape,Integer> tantrixIndex = new HashMap<Shape,Integer>();
	private Map<Integer,Vector<Integer>> BGValues = new HashMap<Integer,Vector<Integer>>();
	private boolean mouseDragged;
	private int indexCount = 0;
	CreateTile createTile = null;
	DrawDiscovery drawDiscovery = null;
	ManageMouseEvent manageMouseEvent = null;
	Validate validate = null;
	CreateBG createBG = null;
	Rules rules = null;
	private static TantrixController tc;
	boolean isDiscovery;
	String currentWorkingColorName = "";
	
	//Singleton
	public static TantrixController getSingleton(){
		if(tc==null){
			tc = new TantrixController();
		}
		return tc;
	}
	
	//Constructor
	private TantrixController() {
		// TODO Auto-generated constructor stub
		createTile = new CreateTile(); 
		drawDiscovery = DrawDiscovery.getInstance();
		createBG = new CreateBG();
		manageMouseEvent = new ManageMouseEvent();
		validate = Validate.getInstances();
		rules = new Rules();
	}
	
	public void drawBGInit(){
		BGValues = createBG.drawHexGridLoop(new Point(500,400),14,30,0);
		createTile.setBGValues(BGValues);
		drawDiscovery.drawBGInit();
	}
	
	public void polyInit(){
		createTile.setDiscovery(isDiscovery);
		if(isDiscovery){
			for(int i=0;i<3;i++){
				addNewTantrixTile();
			}
		}else{
			addNewTantrixTile();
		}
		//System.out.println("Tantrix Controller - drawInit - Size of the tantrix tiles : "+tantrixTiles.size());
		drawDiscovery.setTantrixIndex(tantrixIndex);
		drawDiscovery.drawDiscoveryTilesInit(tantrixTiles);
	}
	
	public void drawDiscoveryTantrix(Graphics2D g){
			drawDiscovery.drawAll(g);
	}
	
	public void addNewTantrixTile(){
		if(indexCount<10){
			Map<Shape,Vector<GeneralPath>> tempNewTantrix = createTile.createTantrix(indexCount);
			for(Map.Entry<Shape,Vector<GeneralPath>> temp : tempNewTantrix.entrySet()){
				Shape tempShape = temp.getKey();
				Vector<GeneralPath> tempArrayList = temp.getValue();
				tantrixTiles.put(tempShape, tempArrayList);
				if(isDiscovery){
					tantrixIndex.put(tempShape,indexCount);
				}else{
					System.out.println("Index value in Tantrix controller : "+createTile.getRandomInt());
					tantrixIndex.put(tempShape,createTile.getRandomInt());
				}
			}
			indexCount++;
		}else if(!isDiscovery){
			if(indexCount<14){
				Map<Shape,Vector<GeneralPath>> tempNewTantrix = createTile.createTantrix(indexCount);
				for(Map.Entry<Shape,Vector<GeneralPath>> temp : tempNewTantrix.entrySet()){
					Shape tempShape = temp.getKey();
					Vector<GeneralPath> tempArrayList = temp.getValue();
					tantrixTiles.put(tempShape, tempArrayList);
					System.out.println("Index value in Tantrix controller : "+createTile.getRandomInt());
					tantrixIndex.put(tempShape,createTile.getRandomInt());
				}
				indexCount++;
			}else{
				JOptionPane.showMessageDialog(null, "You can't add no more tiles !!");
			}
		}else{
			JOptionPane.showMessageDialog(null, "You can't add no more tiles !!");
		}
	}
	
	public void managedMouseEventInit(){
//		System.out.println("Size of tantrix index count : "+drawDiscovery.getTantrixIndex().size());
		manageMouseEvent.init(drawDiscovery.getTantrixTiles(), drawDiscovery.getBGValues(),drawDiscovery.getTantrixIndex());
		//setMouseActionPerformed(true);
	}
	
	public void mouseClickEvent(MouseEvent event){
		manageMouseEvent.mouseClickEvent(event);
		mouseEventUpdation();
	}
	
	public void mousePressEvent(MouseEvent event){
		
	}
	
	public void mouseDraggedEvent(MouseEvent event){
		manageMouseEvent.mouseDraggedEvent(event);
		mouseEventUpdation();
	}
	
	public void mouseReleasedEvent(MouseEvent event){
		manageMouseEvent.mouseReleasedEvent(event);
		mouseEventUpdation();
	}

	public void mouseEventUpdation(){
		drawDiscovery.setBGValues(manageMouseEvent.getBGValues());
		drawDiscovery.setTantrixTiles(manageMouseEvent.getTantrixTiles());
		drawDiscovery.setTantrixIndex(manageMouseEvent.getTantrixIndex());
		managedMouseEventInit();
	}
	
	public boolean validateTantrixDiscovery(){
		validate.setBGValues(drawDiscovery.getBGValues());
		validate.setTantrixIndex(drawDiscovery.getTantrixIndex());
		validate.setTantrixTiles(drawDiscovery.getTantrixTiles());
		//if(isDiscovery){
			validate.validateDiscovery();
			return validate.isLoopValidation();
		/*}else{
			validate.validateSolitaire();
		}*/
	}
	
	public int validateTantrixSolitaire(){
		validate.setBGValues(drawDiscovery.getBGValues());
		validate.setTantrixIndex(drawDiscovery.getTantrixIndex());
		validate.setTantrixTiles(drawDiscovery.getTantrixTiles());
		validate.validateSolitaire();
		return validate.getSolitairePoints();
	}
	
	public String getRulesOfSolitaire(){
		return rules.getSolitaireRule();
	}
	
	public String getRulesOfDiscovery(){
		return rules.getDiscoveryRule();
	}
	
	//Getters and Setter
	public boolean isMouseDragged() {
		return mouseDragged;
	}

	public Map<Shape, Integer> getTantrixIndex() {
		return tantrixIndex;
	}

	public void setTantrixIndex(Map<Shape, Integer> tantrixIndex) {
		this.tantrixIndex = tantrixIndex;
	}

	public boolean isDiscovery() {
		return isDiscovery;
	}

	public void setDiscovery(boolean isDiscovery) {
		this.isDiscovery = isDiscovery;
	}

	public String getCurrentWorkingColorName() {
		validate.setBGValues(drawDiscovery.getBGValues());
		validate.setTantrixIndex(drawDiscovery.getTantrixIndex());
		validate.setTantrixTiles(drawDiscovery.getTantrixTiles());
		return validate.getColorName();
	}

}
