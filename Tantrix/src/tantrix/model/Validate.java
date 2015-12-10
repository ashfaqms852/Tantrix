package tantrix.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.plaf.SliderUI;

public class Validate {

	
	private static Validate validate;
	private static Map<Shape,Vector<GeneralPath>> tantrixTiles = new HashMap<Shape,Vector<GeneralPath>>();
	private static Map<Shape,Integer> tantrixIndex = new HashMap<Shape,Integer>();
	private static Map<Integer,Vector<Integer>> BGValues = new HashMap<Integer,Vector<Integer>>();
	private static List<Color>colorList = new ArrayList<Color>();
	private static Map<Color,String> colorNameMap = new HashMap<Color,String>();
	String colorName = "";
	private static int colorIndex=0;
	boolean loopValidation;
	int solitairePoints;
	
	public static Validate getInstances(){
		if(validate==null){
			validate = new Validate();
		}
		return validate;
	}
	
	private Validate(){
		colorList.add(Color.YELLOW);
		colorList.add(Color.RED);
		colorList.add(Color.RED);
		colorList.add(Color.BLUE);
		colorList.add(Color.RED);
		colorList.add(Color.BLUE);
		colorList.add(Color.YELLOW);
		colorList.add(Color.RED);
		colorList.add(Color.BLUE);
		colorList.add(Color.YELLOW);
		colorNameMap.put(Color.YELLOW,"Yellow");
		colorNameMap.put(Color.RED,"Red");
		colorNameMap.put(Color.BLUE,"Blue");
	}
	
	/*public void init(){
		
	}*/
	
	public void validateDiscovery(){
		loopValidation = false;
		int tantrixTilesCount = (tantrixTiles.size() -1);
		System.out.println("tantrix tils count : "+tantrixTilesCount);
		Color currentColorCheck = colorList.get(tantrixTilesCount-2);
		System.out.println("Current Color : "+currentColorCheck);
		//checking if any tiles outside of the loop
		int checkGeneralPathIndex;
		if(currentColorCheck.equals(Color.RED)){
			checkGeneralPathIndex = 0;
		}else if(currentColorCheck.equals(Color.YELLOW)){
			checkGeneralPathIndex = 1;
		}else if(currentColorCheck.equals(Color.YELLOW)){
			checkGeneralPathIndex = 2;
		}else{
			checkGeneralPathIndex = 0;
		}
		Point oldStartPoint= new Point();
		Point oldEndPoint= new Point();
		int count = 0;
		
		for(Vector<GeneralPath> generalPath : tantrixTiles.values()){
			GeneralPath tempGeneralPathForCheck = generalPath.get(checkGeneralPathIndex);
			double[][] pathArray = PathGenerator.getXYPoints(tempGeneralPathForCheck);
			Point newStartPoint= new Point();
			Point newEndPoint= new Point();
			if(count == 0){
				oldStartPoint.setLocation(pathArray[0][0],pathArray[0][1]);
				oldEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
			}else{
				newStartPoint.setLocation(pathArray[0][0],pathArray[0][1]);
				newEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
				int xDiff = Math.abs(newStartPoint.x-oldEndPoint.x);
				int yDiff = Math.abs(oldEndPoint.y-newStartPoint.y); 
				System.out.println(" xDiff : "+xDiff+"\nyDiff : "+yDiff);
				int diffVal = (tantrixTilesCount+2)*20;
				if(oldEndPoint.equals(newStartPoint) || (xDiff<diffVal && yDiff<diffVal)){//  && xDiff>=0 && yDiff>=0))){// || (xDiff>-5 && yDiff>-5 && xDiff<=0 && yDiff<=0))){
					loopValidation = true;
				}else{
					loopValidation = false;
					break;					
				}
			}
			count++;
		}
		//}
		
	}
	
	public void validateSolitaire(){
		//int tantrixTilesCount = (tantrixTiles.size() -1);
		solitairePoints = 0;
		int tantrixTilesCount = (tantrixTiles.size() -1);
		System.out.println("tantrix tils count : "+tantrixTilesCount);
		Point oldRedEndPoint= new Point();
		//Point oldGreenStartPoint= new Point();
		Point oldGreenEndPoint= new Point();
		//Point oldBlueStartPoint= new Point();
		Point oldBlueEndPoint= new Point();
		int count = 0;
		int redPoints = 1, greenPoint = 1, bluePoints = 1; 
		for(Vector<GeneralPath> generalPath : tantrixTiles.values()){
			for(int i=0;i<3;i++){
				GeneralPath tempGeneralPathForCheck = generalPath.get(i);
				double[][] pathArray = PathGenerator.getXYPoints(tempGeneralPathForCheck);
				Point newStartPoint= new Point();
				Point newEndPoint= new Point();
				if(count == 0){
					if(i==0)
						oldRedEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
					else if(i==1)
						oldGreenEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
					else if(i==2)
						oldBlueEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
				}else{
					newStartPoint.setLocation(pathArray[0][0],pathArray[0][1]);
					newEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
					/*int xDiff = Math.abs(newStartPoint.x-oldEndPoint.x);
					int yDiff = Math.abs(oldEndPoint.y-newStartPoint.y); */
					int xRedDiff=0,yRedDiff=0,xGreenDiff=0,yGreenDiff=0,xBlueDiff=0,yBlueDiff=0;
					if(i==0){
						xRedDiff = Math.abs(newStartPoint.x-oldRedEndPoint.x);
						yRedDiff = Math.abs(oldRedEndPoint.y-newStartPoint.y);
					}else if(i==1){
						xGreenDiff = Math.abs(newStartPoint.x-oldGreenEndPoint.x);
						yGreenDiff = Math.abs(oldGreenEndPoint.y-newStartPoint.y);
					}else if(i==2){
						xBlueDiff = Math.abs(newStartPoint.x-oldBlueEndPoint.x);
						yBlueDiff = Math.abs(oldBlueEndPoint.y-newStartPoint.y);
					}
					//System.out.println(" xDiff : "+xDiff+"\nyDiff : "+yDiff);
					int diffVal = (tantrixTilesCount+2)*20;
					if(i==0){
						if(oldRedEndPoint.equals(newStartPoint) || (xRedDiff<diffVal && yRedDiff<diffVal)){
							redPoints++;
						}else{
							//loopRedValidation = false;
							/*loopValidation = false;
							break;	*/				
						}
					}else if(i==1){
						if(oldGreenEndPoint.equals(newStartPoint) || (xGreenDiff<diffVal && yGreenDiff<diffVal)){
							greenPoint++;
						}else{
							//loopGreenValidation = false;
							/*loopValidation = false;
							break;	*/				
						}
					}else if(i==2){
						if(oldBlueEndPoint.equals(newStartPoint) || (xBlueDiff<diffVal && yBlueDiff<diffVal)){
							bluePoints++;
							//loopValidation = true;
						}else{
							//loopBlueValidation = false;
							/*loopValidation = false;
							break;*/					
						}
					}
				}
			}
			count++;
		}
		if(greenPoint>bluePoints || greenPoint>redPoints){
			if(validateColorSolitaire(1))
				solitairePoints = 2*greenPoint;
			else
				solitairePoints = greenPoint;
		}else if(bluePoints>redPoints){
			if(validateColorSolitaire(2))
				solitairePoints = 2*bluePoints;
			else
				solitairePoints = bluePoints;
		}else{
			if(validateColorSolitaire(0))
				solitairePoints = 2*redPoints;
			else
				solitairePoints = redPoints;	
		}
		if(solitairePoints == 0){
			solitairePoints=1;
		}
	}
	
	public boolean validateColorSolitaire(int tempcheckGeneralPathIndex){
		loopValidation = false;
		int tantrixTilesCount = (tantrixTiles.size() -1);
		System.out.println("tantrix tils count : "+tantrixTilesCount);
		/*
		 * Red - 0
		 * Yellow - 1
		 * Blue	- 2
		 */
		int checkGeneralPathIndex = tempcheckGeneralPathIndex;
		Point oldStartPoint= new Point();
		Point oldEndPoint= new Point();
		int count = 0;
		
		for(Vector<GeneralPath> generalPath : tantrixTiles.values()){
			for(int i=0;i<3;i++){
				GeneralPath tempGeneralPathForCheck = generalPath.get(checkGeneralPathIndex);
				double[][] pathArray = PathGenerator.getXYPoints(tempGeneralPathForCheck);
				Point newStartPoint= new Point();
				Point newEndPoint= new Point();
				if(count == 0){
					oldStartPoint.setLocation(pathArray[0][0],pathArray[0][1]);
					oldEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
				}else{
					newStartPoint.setLocation(pathArray[0][0],pathArray[0][1]);
					newEndPoint.setLocation(pathArray[1][0],pathArray[1][1]);
					int xDiff = Math.abs(newStartPoint.x-oldEndPoint.x);
					int yDiff = Math.abs(oldEndPoint.y-newStartPoint.y); 
					System.out.println(" xDiff : "+xDiff+"\nyDiff : "+yDiff);
					int diffVal = (tantrixTilesCount+2)*10;
					if(oldEndPoint.equals(newStartPoint) || (xDiff<diffVal && yDiff<diffVal)){
						loopValidation = true;
					}else{
						loopValidation = false;
						break;					
					}
				}
			}
			count++;
		}
		return loopValidation;
	}

	public static Map<Shape, Vector<GeneralPath>> getTantrixTiles() {
		return tantrixTiles;
	}

	public void setTantrixTiles(Map<Shape, Vector<GeneralPath>> tantrixTiles) {
		Validate.tantrixTiles = tantrixTiles;
	}

	public static Map<Shape, Integer> getTantrixIndex() {
		return tantrixIndex;
	}

	public void setTantrixIndex(Map<Shape, Integer> tantrixIndex) {
		Validate.tantrixIndex = tantrixIndex;
	}

	public static Map<Integer, Vector<Integer>> getBGValues() {
		return BGValues;
	}

	public void setBGValues(Map<Integer, Vector<Integer>> bGValues) {
		BGValues = bGValues;
	}

	public static int getColorIndex() {
		return colorIndex;
	}

	public static void setColorIndex(int colorIndex) {
		Validate.colorIndex = colorIndex;
	}

	public boolean isLoopValidation() {
		return loopValidation;
	}

	public void setLoopValidation(boolean loopValidation) {
		this.loopValidation = loopValidation;
	}

	public String getColorName() {
		int tantrixTilesCount = (tantrixTiles.size() -1);
		//System.out.println("tantrix tils count : "+tantrixTilesCount);
		Color currentColorCheck = colorList.get(tantrixTilesCount-2);
		//System.out.println("Current Color : "+currentColorCheck);
		colorName = colorNameMap.get(currentColorCheck);
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public int getSolitairePoints() {
		return solitairePoints;
	}

	public void setSolitairePoints(int solitairePoints) {
		this.solitairePoints = solitairePoints;
	}
	
}
