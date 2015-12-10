package tantrix.model;

//import java.awt.Point;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;


public class CreateTile {



	private Map<Integer,Vector<Integer>> BGValues = new HashMap<Integer,Vector<Integer>>();
	private Vector<Integer> tantrixIndex = new Vector<Integer>();
	boolean isDiscovery;
	int randomInt;

	
	
	

	//member functions
	Vector<GeneralPath> createPath(int[] xPoint,int[] yPoint,int indexCount){
		Vector<GeneralPath> newPath = null;
		if(isDiscovery){
			newPath = PathGenerator.generatePath(xPoint,yPoint,indexCount);
		}else{
			Random random = new Random();
			for(;;){
				randomInt = random.nextInt(14);
				if(!tantrixIndex.contains(randomInt)){
					System.out.println("Random Int : "+randomInt);
					tantrixIndex.add(randomInt);
					break;
				}			
			}
			newPath = PathGenerator.generatePath(xPoint,yPoint,randomInt);
		}
		//System.out.println("Size of the newPath in createPath in create Tile : "+newPath.size());
		return newPath;
	}
	
	public Shape createTile(int indexCount){
		Shape newTile = null;
		int yVal = 70,xVal=150;
		int numPoints = 6;
        int[] xpoints = new int[numPoints];
        int[] ypoints = new int[numPoints];
        for(int i=0;i<indexCount;i++){
            if(i==5){//to make the polygon to print in the second row
                yVal+= 150;
                xVal =150;
            }//end of if
            xVal+=150;
        }
        int[][] XYPoints = getPolygonArrays(xVal,yVal,30,6);
		xpoints = XYPoints[0];
		ypoints = XYPoints[1];
		newTile = new Polygon(xpoints, ypoints,numPoints); 
		return newTile;
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
	
	void printPolygonVal(int[] xPoint,int[] yPoint){
		System.out.println("Printing Polygon Values,");
		System.out.println("X Values,");
		int i=0;
		for(i=0;i<xPoint.length;i++){
			System.out.println("X["+ i +"] : "+ xPoint[i]);
			System.out.println("Y["+ i +"] : "+ yPoint[i]);
		}
		/*System.out.println("y Values,");*/
	}
	
	public Map<Shape,Vector<GeneralPath>> createTantrix(int indexCount){
		Map<Shape,Vector<GeneralPath>> newTantrixTiles = new HashMap<Shape,Vector<GeneralPath>>();
		if(indexCount<3){
			Vector<Integer> tempList = BGValues.get(60+indexCount);
			int[][] XYPoints = getPolygonArrays(tempList.get(0),tempList.get(1),tempList.get(2),6);
			int[] xpoints = XYPoints[0];
			int[] ypoints = XYPoints[1];
			//printPolygonVal(xpoints, ypoints);
			Shape newTile =  new Polygon(xpoints, ypoints,6); 
			Polygon tempPoly = (Polygon) newTile;
			Vector<GeneralPath> newPath = createPath(tempPoly.xpoints, tempPoly.ypoints, indexCount);
			newTantrixTiles.put(newTile, newPath);
			return newTantrixTiles;
		}		
		Vector<Integer> tempList = BGValues.get(24+indexCount);
		int[][] XYPoints = getPolygonArrays(tempList.get(0),tempList.get(1),tempList.get(2),6);
		int[] xpoints = XYPoints[0];
		int[] ypoints = XYPoints[1];
		//printPolygonVal(xpoints, ypoints);
		Shape newTile =  new Polygon(xpoints, ypoints,6); 
		Polygon tempPoly = (Polygon) newTile;
		Vector<GeneralPath> newPath = createPath(tempPoly.xpoints, tempPoly.ypoints, indexCount);
		newTantrixTiles.put(newTile, newPath);
		return newTantrixTiles;
	}
	
	public Map<Shape,Vector<GeneralPath>> updateTantrixTile(int dragX,int dragY,int indexCount){
		boolean temp = isDiscovery();
		if(!temp)
			setDiscovery(true);
		Map<Shape,Vector<GeneralPath>> newTantrixTiles = new HashMap<Shape,Vector<GeneralPath>>();
		int[][] XYPoints = getPolygonArrays(dragX,dragY,30,6);
		int[] xpoints = XYPoints[0];
		int[] ypoints = XYPoints[1];
		Shape newShape =  new Polygon(xpoints, ypoints,6); 
		Polygon tempPoly = (Polygon) newShape;
		Vector<GeneralPath> newPath = createPath(tempPoly.xpoints, tempPoly.ypoints, indexCount);
		newTantrixTiles.put(newShape, newPath);
		if(!temp)
			setDiscovery(false);
		return newTantrixTiles;
	}
	
	//getters and setters
	public void setBGValues(Map<Integer, Vector<Integer>> bGValues) {
		BGValues = bGValues;
	}

	public boolean isDiscovery() {
		return isDiscovery;
	}

	public void setDiscovery(boolean isDiscovery) {
		this.isDiscovery = isDiscovery;
	}

	public int getRandomInt() {
		return randomInt;
	}

	public void setRandomInt(int randomInt) {
		this.randomInt = randomInt;
	}

	
	
}
