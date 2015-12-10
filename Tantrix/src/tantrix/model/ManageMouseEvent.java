package tantrix.model;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.SwingUtilities;

public class ManageMouseEvent {

	//member variables
	private boolean isMouseDragged;
	Polygon selectedPolygon;
	Shape selectedShape;
	Vector<GeneralPath> selectedGeneralPath;
	Vector<GeneralPath> newGeneralPath;
	private Map<Shape,Vector<GeneralPath>> tantrixTiles = new HashMap<Shape,Vector<GeneralPath>>();
	private Map<Integer,Vector<Integer>> BGValues = new HashMap<Integer,Vector<Integer>>();
	private Map<Shape,Integer> tantrixIndex = new HashMap<Shape,Integer>();
	CreateTile createTile = new CreateTile();
	Point mousePressPoint,mouseReleasePoint,mouseDraggedPoint;
	private int indexCount;// = 0;
	
	//member functions
	public void init(Map<Shape,Vector<GeneralPath>> tempTantrixTiles, Map<Integer,Vector<Integer>> tempBGValues,Map<Shape,Integer> tempTantrixIndex){
		setTantrixTiles(tempTantrixTiles);
		setBGValues(tempBGValues);
		setTantrixIndex(tempTantrixIndex);
	}
	
	public void mouseClickEvent(MouseEvent event){
//		System.out.println("Mouse Click ");// + isMouseDragged());
		int count = 0;
		for(Shape tempShape : tantrixTiles.keySet()){
			if(tempShape.contains(event.getPoint())){
//				System.out.println("Click is on the shape ");
				selectedShape = tempShape;
				selectedGeneralPath = tantrixTiles.get(selectedShape);
				indexCount = count;
				//selectedPath = BGValues.get(count);
				selectedPolygon = (Polygon)selectedShape;
//				System.out.println("Shape is selected");
				break;
			}else{
				selectedShape = null;
				selectedGeneralPath = null;
//				System.out.println("Null is selected");
			}
			count++;
		}
		
		if(SwingUtilities.isLeftMouseButton(event)){
			leftMouseEvent(event);
		}else if(SwingUtilities.isRightMouseButton(event)){
			rightMouseEvent(event);
		}
	}
	
	public void mousePressEvent(MouseEvent event){
		mousePressPoint = event.getPoint();
	}
	
	public void leftMouseEvent(MouseEvent event){
		if(selectedShape!=null){
//			System.out.println("Left Mouse Clicked on Shape");
			int[] xPoints = selectedPolygon.xpoints;
			int[] yPoints = selectedPolygon.ypoints;
			System.out.println("");
			newGeneralPath = PathGenerator.pathLeftRotator(xPoints,yPoints,indexCount,selectedGeneralPath);
			tantrixTiles.put(selectedShape, newGeneralPath);
		}else{
			System.out.println("Left Mouse - Shape is null");
		}
	}
	
	public void rightMouseEvent(MouseEvent event){
		if(selectedShape!=null){
//			System.out.println("Right Mouse Clicked on Shape");
			int[] xPoints = selectedPolygon.xpoints;
			int[] yPoints = selectedPolygon.ypoints;
			newGeneralPath = PathGenerator.pathRightRotator(xPoints,yPoints,indexCount,selectedGeneralPath);
			tantrixTiles.put(selectedShape, newGeneralPath);
		}else{
			System.out.println("Right Mouse - Shape is null");
		}
	}
	
	public void mouseDraggedEvent(MouseEvent event){
		mouseDraggedPoint = event.getPoint();
		//int count = 0;
		boolean polygonIsFound = false;
		for(Shape tempShape : tantrixTiles.keySet()){
			if(tempShape.contains(event.getPoint())){
//				System.out.println("Click is on the shape ");
				selectedShape = tempShape;
				selectedGeneralPath = tantrixTiles.get(selectedShape);
//				System.out.println("Size of the tatrix index : "+tantrixIndex.size());
				indexCount = tantrixIndex.get(selectedShape);
				selectedPolygon = (Polygon)selectedShape;
				polygonIsFound = true;
				break;
			}else{
				selectedShape = null;
				selectedGeneralPath = null;
			}
		}
		if(polygonIsFound){
			tantrixTiles.remove(selectedShape);
			tantrixIndex.remove(selectedShape);
			createTile.setBGValues(BGValues);
			Map<Shape,Vector<GeneralPath>> newTantrixTiles = createTile.updateTantrixTile(mouseDraggedPoint.x, mouseDraggedPoint.y, indexCount);
//			System.out.println("Size of new Tile : "+newTantrixTiles.size());
			for(Map.Entry<Shape,Vector<GeneralPath>> tempTantrixTile : newTantrixTiles.entrySet()){
				tantrixTiles.put(tempTantrixTile.getKey(), tempTantrixTile.getValue());
				tantrixIndex.put(tempTantrixTile.getKey(), indexCount);
			}
		}

	}
	
	public void mouseReleasedEvent(MouseEvent event){
		mouseReleasePoint = event.getPoint();
	}
	
	//getters and setters
	public boolean isMouseDragged() {
		return isMouseDragged;
	}

	public void setMouseDragged(boolean isMouseDragged) {
		this.isMouseDragged = isMouseDragged;
	}
	
	public Polygon getSelectedPolygon() {
		return selectedPolygon;
	}

	public void setSelectedPolygon(Polygon selectedPolygon) {
		this.selectedPolygon = selectedPolygon;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	public Map<Shape, Vector<GeneralPath>> getTantrixTiles() {
		return tantrixTiles;
	}

	public void setTantrixTiles(Map<Shape, Vector<GeneralPath>> tantrixTiles) {
		this.tantrixTiles = tantrixTiles;
	}

	public Map<Integer, Vector<Integer>> getBGValues() {
		return BGValues;
	}

	public void setBGValues(Map<Integer, Vector<Integer>> bGValues) {
		BGValues = bGValues;
	}

	public Map<Shape, Integer> getTantrixIndex() {
		return tantrixIndex;
	}

	public void setTantrixIndex(Map<Shape, Integer> tantrixIndex) {
		this.tantrixIndex = tantrixIndex;
	}

}
