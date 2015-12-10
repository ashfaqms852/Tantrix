package tantrix.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DrawDiscovery {

	private static Map<Shape,Vector<GeneralPath>> tantrixTiles = new HashMap<Shape,Vector<GeneralPath>>();
	private static Map<Shape,Integer> tantrixIndex = new HashMap<Shape,Integer>();
	private static Map<Integer,Vector<Integer>> BGValues = new HashMap<Integer,Vector<Integer>>();
	int numPoints = 6;
	static DrawDiscovery drawDiscovery = null;
	/*int bgR = 0,bgX = 0,bgY = 0;*/
	
	//Singleton
	public static DrawDiscovery getInstance(){
		if(drawDiscovery==null){
			drawDiscovery = new DrawDiscovery();
		}
		return drawDiscovery;
	}
	
	//constructor
	private DrawDiscovery(){
		
	}
	
	//member functions
	private void drawBG(Graphics g, int x, int y, int r){
        int[] xpoints = new int[numPoints];
        int[] ypoints = new int[numPoints];
        int[][] XYPoints = getPolygonArrays(x, y, r,numPoints);
		xpoints = XYPoints[0];
		ypoints = XYPoints[1];
        Polygon tempPoly = new Polygon(xpoints, ypoints,numPoints); 
        g.setColor(new Color(0xFFDD88));
        g.drawPolygon(tempPoly);
	}
	
   
    private int[][] getPolygonArrays(int cx, int cy, int R, int sides) {
    	int SIDES = sides;
    	Point[] points = new Point[SIDES];
        Point center = new Point(cx, cy);
        int radius = R;
        int rotation = 90;
    	int[] xpoints = new int[sides];
        int[] ypoints = new int[sides];
        for (int p = 0; p < SIDES; p++) {
            double angle = ((double) p / SIDES) * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
            int x = (int) (center.x + Math.cos(angle) * radius);
            int y = (int) (center.y + Math.sin(angle) * radius);
            Point point = new Point(x,y);
            xpoints[p] = point.x;
            ypoints[p] = point.y;
            points[p] = point;
            //System.out.printf("%d. (%d, %d)\n", p, point.x, point.y);
        }
        return new int[][]{ xpoints, ypoints };
    }
    
	public void drawBGInit(){
		CreateBG cbg = new CreateBG();
		BGValues = cbg.drawHexGridLoop(new Point(500,400),14,30,0);
		//updateTantrixPositionInit();
	}
	
    public void drawDiscoveryTilesInit(Map<Shape,Vector<GeneralPath>> tempTantrixTiles){
    	tantrixTiles = tempTantrixTiles;
    }
    
    public void drawAll(Graphics2D g){
    	//Drawing background
    	//System.out.println("Print ALL");
    	for(Vector<Integer> tempList : BGValues.values()){
			drawBG(g, tempList.get(0), tempList.get(1), tempList.get(2));
		}
    	//drawing tiles
    	for(Map.Entry<Shape,Vector<GeneralPath>> temp : tantrixTiles.entrySet()){
			Shape tempShape = temp.getKey();
			Vector<GeneralPath> tempArrayList = temp.getValue();
        	//System.out.println("Adding Polygon,");
        	g.setColor(Color.BLACK);
    		g.fill(tempShape);
    		g.setColor(Color.RED);
    		try{
	    		g.draw(tempArrayList.get(0));
	    		g.setColor(Color.YELLOW);
	    		g.draw(tempArrayList.get(1));
	    		g.setColor(Color.BLUE);
	    		g.draw(tempArrayList.get(2));
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}//end of for loop
    }

  
    //getters and setters
	public Map<Shape, Vector<GeneralPath>> getTantrixTiles() {
		return tantrixTiles;
	}


	public void setTantrixTiles(Map<Shape, Vector<GeneralPath>> tantrixTiles) {
		DrawDiscovery.tantrixTiles = tantrixTiles;
	}


	public Map<Integer, Vector<Integer>> getBGValues() {
		return BGValues;
	}


	public void setBGValues(Map<Integer, Vector<Integer>> bGValues) {
		BGValues = bGValues;
	}


	public int getNumPoints() {
		return numPoints;
	}


	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	
	public Map<Shape, Integer> getTantrixIndex() {
		return tantrixIndex;
	}

	public void setTantrixIndex(Map<Shape, Integer> tantrixIndex) {
		DrawDiscovery.tantrixIndex = tantrixIndex;
	}

	public static DrawDiscovery getDrawDiscovery() {
		return drawDiscovery;
	}

	public static void setDrawDiscovery(DrawDiscovery drawDiscovery) {
		DrawDiscovery.drawDiscovery = drawDiscovery;
	}
    
    
    
}
