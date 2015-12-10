package tantrix.model;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class PathGenerator {
	
	
	public static Vector<GeneralPath> generatePath(int[] xPoint,int[] yPoint,int indexCount){
		Vector<GeneralPath> pathList = new Vector<GeneralPath>();
		/*
		 *newPath0 = RED
		 *newPath1 = Yellow
		 *newPath2 = BLUE 
		 */
		GeneralPath newPath0 = null,newPath1 = null,newPath2 = null;
		Point p0 = new Point(xPoint[0],yPoint[0]);
		Point p1 = new Point(xPoint[1],yPoint[1]);
		Point p2 = new Point(xPoint[2],yPoint[2]);
		Point p3 = new Point(xPoint[3],yPoint[3]);
		Point p4 = new Point(xPoint[4],yPoint[4]);
		Point p5 = new Point(xPoint[5],yPoint[5]);
		Point middlePoint01 = findMidPoint(p0, p1);
		Point middlePoint12 = findMidPoint(p1, p2);
		Point middlePoint23 = findMidPoint(p2, p3);
		Point middlePoint34 = findMidPoint(p3, p4);
		Point middlePoint45 = findMidPoint(p4, p5);
		Point middlePoint50 = findMidPoint(p5, p0);
		int pathLength = 2;
		switch(indexCount){
		case 0:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint50.getX(), middlePoint50.getY());
			newPath0.lineTo(middlePoint12.getX(),middlePoint12.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint23.getX(), middlePoint23.getY());
			newPath1.lineTo(middlePoint34.getX(),middlePoint34.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath2.lineTo(middlePoint01.getX(),middlePoint01.getY());
			
			break;
		case 1:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint50.getX(), middlePoint50.getY());
			newPath0.lineTo(middlePoint01.getX(),middlePoint01.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint23.getX(), middlePoint23.getY());
			newPath1.lineTo(middlePoint34.getX(),middlePoint34.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath2.lineTo(middlePoint12.getX(),middlePoint12.getY());
			break;
		case 2:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint23.getX(), middlePoint23.getY());
			newPath0.lineTo(middlePoint34.getX(),middlePoint34.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath1.lineTo(middlePoint12.getX(),middlePoint12.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath2.lineTo(middlePoint50.getX(), middlePoint50.getY());
			break;
		case 3:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint50.getX(), middlePoint50.getY());
			newPath0.lineTo(middlePoint34.getX(),middlePoint34.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath1.lineTo(middlePoint23.getX(),middlePoint23.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath2.lineTo(middlePoint12.getX(), middlePoint12.getY());
			break;
		case 4:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint50.getX(), middlePoint50.getY());
			newPath0.lineTo(middlePoint23.getX(),middlePoint23.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath1.lineTo(middlePoint45.getX(),middlePoint45.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath2.lineTo(middlePoint12.getX(), middlePoint12.getY());
			break;
		case 5:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath0.lineTo(middlePoint23.getX(),middlePoint23.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint12.getX(), middlePoint12.getY());
			newPath1.lineTo(middlePoint45.getX(),middlePoint45.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath2.lineTo(middlePoint50.getX(), middlePoint50.getY());
			break;
		case 6:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath0.lineTo(middlePoint23.getX(),middlePoint23.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint12.getX(), middlePoint12.getY());
			newPath1.lineTo(middlePoint50.getX(),middlePoint50.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath2.lineTo(middlePoint45.getX(), middlePoint45.getY());
			break;
		case 7:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath0.lineTo(middlePoint45.getX(),middlePoint45.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint12.getX(), middlePoint12.getY());
			newPath1.lineTo(middlePoint50.getX(),middlePoint50.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath2.lineTo(middlePoint23.getX(), middlePoint23.getY());
			break;
		case 8:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint12.getX(), middlePoint12.getY());
			newPath0.lineTo(middlePoint45.getX(),middlePoint45.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath1.lineTo(middlePoint23.getX(),middlePoint23.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath2.lineTo(middlePoint50.getX(), middlePoint50.getY());	
			break;
		case 9:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint12.getX(), middlePoint12.getY());
			newPath0.lineTo(middlePoint50.getX(),middlePoint50.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath1.lineTo(middlePoint45.getX(),middlePoint45.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath2.lineTo(middlePoint23.getX(), middlePoint23.getY());
			break;
		case 10:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath0.lineTo(middlePoint50.getX(),middlePoint50.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath1.lineTo(middlePoint12.getX(),middlePoint12.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath2.lineTo(middlePoint23.getX(), middlePoint23.getY());
			break;
		case 11:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath0.lineTo(middlePoint50.getX(),middlePoint50.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath1.lineTo(middlePoint23.getX(), middlePoint23.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint34.getX(), middlePoint34.getY());
			newPath2.lineTo(middlePoint12.getX(),middlePoint12.getY());
			break;
		case 12:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint23.getX(), middlePoint23.getY());
			newPath0.lineTo(middlePoint12.getX(),middlePoint12.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath1.lineTo(middlePoint34.getX(),middlePoint34.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath2.lineTo(middlePoint50.getX(), middlePoint50.getY());
			break;
		case 13:
			newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath0.moveTo(middlePoint23.getX(), middlePoint23.getY());
			newPath0.lineTo(middlePoint34.getX(),middlePoint34.getY());
			newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath1.moveTo(middlePoint01.getX(), middlePoint01.getY());
			newPath1.lineTo(middlePoint12.getX(),middlePoint12.getY());
			newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
			newPath2.moveTo(middlePoint45.getX(), middlePoint45.getY());
			newPath2.lineTo(middlePoint50.getX(), middlePoint50.getY());
			break;
		default:
			System.out.println("Check the index Count\n"
					+ "The value of indexCount : "+indexCount);
		
		}
		pathList.add(newPath0);
		pathList.add(newPath1);
		pathList.add(newPath2);
		return pathList;
	}
	
	static Point findMidPoint(Point X, Point Y){
		Point MiddlePoint;
		int valueX = (int) ((X.getX()+Y.getX())/2);
		int valueY = (int) ((X.getY()+Y.getY())/2);
		MiddlePoint = new Point();
		MiddlePoint.setLocation(valueX, valueY);
		return MiddlePoint;
	}
	
	public static Vector<GeneralPath> pathLeftRotator(int[] xPoint,int[] yPoint,int indexCount,Vector<GeneralPath> oldGeneralPath){
		Vector<GeneralPath> pathList = new Vector<GeneralPath>();
		GeneralPath newPath0 = null,newPath1 = null,newPath2 = null;
		GeneralPath oldPath0 = null,oldPath1 = null,oldPath2 = null;

		Point newStartingPoint0 = null;
		Point newEndingPoint0 = null;
		Point newStartingPoint1 = null;
		Point newEndingPoint1 = null;
		Point newStartingPoint2 = null;
		Point newEndingPoint2 = null;
		int pathLength = 2;
		//rotating first
			oldPath0 = oldGeneralPath.get(0);
			double[][] oldPathPoints = getXYPoints(oldPath0);
			Point oldPathPointStart = new Point();
			oldPathPointStart.setLocation((int)oldPathPoints[0][0], (int)oldPathPoints[0][1]);
			Point oldPathPointEnd = new Point();
			oldPathPointEnd.setLocation((int)oldPathPoints[1][0], (int)oldPathPoints[1][1]);

			for(int i=0;i<6;i++){
//				System.out.println("Old Path 0 Itr");
				Point tempPoint0;
				Point tempPoint1;
				Point middlePointT0T1 = null;
				if(i<5){
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}else{
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[0],yPoint[0]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}
//				System.out.println("Middle Point, X : "+middlePointT0T1.getX()+" Y : "+ middlePointT0T1.getY());
				if(oldPathPointStart.equals(middlePointT0T1) || oldPathPointEnd.equals(middlePointT0T1)){
//					System.out.println("Old Path 0 contains the middle point");
					Point innertempPoint0;
					Point innertempPoint1;
					Point innermiddlePointT0T1 = null;
						if(middlePointT0T1.equals(oldPathPointStart)){//;// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the starting point");
							if(i<4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[(i+2)],yPoint[(i+2)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[0],yPoint[0]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[0],yPoint[0]);
								innertempPoint1 = new Point(xPoint[1],yPoint[1]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newStartingPoint0 = innermiddlePointT0T1;
						}
						if(middlePointT0T1.equals(oldPathPointEnd)){// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the ending point");
							if(i<4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[(i+2)],yPoint[(i+2)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[0],yPoint[0]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[0],yPoint[0]);
								innertempPoint1 = new Point(xPoint[1],yPoint[1]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newEndingPoint0 = innermiddlePointT0T1;
						}
					//}
				}
			}
			if(newEndingPoint0!= null && newStartingPoint0!=null){
//				System.out.println("Got the new path :) :)");
				newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
				newPath0.moveTo(newStartingPoint0.getX(), newStartingPoint0.getY());
				newPath0.lineTo(newEndingPoint0.getX(),newEndingPoint0.getY());
			}
		//rotating second
			oldPath1 = oldGeneralPath.get(1);
			oldPathPoints = getXYPoints(oldPath1);
//				System.out.println("Old  X : "+oldPathPoints[0][0]+" Y : "+oldPathPoints[0][1]);
//				System.out.println("Old  X : "+oldPathPoints[1][0]+" Y : "+oldPathPoints[1][1]);
				oldPathPointStart = new Point();
				oldPathPointStart.setLocation((int)oldPathPoints[0][0], (int)oldPathPoints[0][1]);
				oldPathPointEnd = new Point();
				oldPathPointEnd.setLocation((int)oldPathPoints[1][0], (int)oldPathPoints[1][1]);
			for(int i=0;i<6;i++){
//				System.out.println("Old Path 0 Itr");
				Point tempPoint0;
				Point tempPoint1;
				Point middlePointT0T1 = null;
				if(i<5){
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}else{
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[0],yPoint[0]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}
//				System.out.println("Middle Point, X : "+middlePointT0T1.getX()+" Y : "+ middlePointT0T1.getY());
				if(oldPathPointStart.equals(middlePointT0T1) || oldPathPointEnd.equals(middlePointT0T1)){
//					System.out.println("Old Path 0 contains the middle point");
					Point innertempPoint0;
					Point innertempPoint1;
					Point innermiddlePointT0T1 = null;
					if(middlePointT0T1.equals(oldPathPointStart)){//;// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the starting point");
							if(i<4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[(i+2)],yPoint[(i+2)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[0],yPoint[0]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[0],yPoint[0]);
								innertempPoint1 = new Point(xPoint[1],yPoint[1]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newStartingPoint1 = innermiddlePointT0T1;
						}
						if(middlePointT0T1.equals(oldPathPointEnd)){// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the ending point");
							if(i<4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[(i+2)],yPoint[(i+2)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[0],yPoint[0]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[0],yPoint[0]);
								innertempPoint1 = new Point(xPoint[1],yPoint[1]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newEndingPoint1 = innermiddlePointT0T1;
						}
					//}
				}
			}
			if(newEndingPoint1!= null && newStartingPoint1!=null){
				newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
				newPath1.moveTo(newStartingPoint1.getX(), newStartingPoint1.getY());
				newPath1.lineTo(newEndingPoint1.getX(),newEndingPoint1.getY());
			}
		//rotating third
			oldPath2 = oldGeneralPath.get(2);
			oldPathPoints = getXYPoints(oldPath2);
//				System.out.println("Old  X : "+oldPathPoints[0][0]+" Y : "+oldPathPoints[0][1]);
//				System.out.println("Old  X : "+oldPathPoints[1][0]+" Y : "+oldPathPoints[1][1]);
				oldPathPointStart = new Point();
				oldPathPointStart.setLocation((int)oldPathPoints[0][0], (int)oldPathPoints[0][1]);
				oldPathPointEnd = new Point();
				oldPathPointEnd.setLocation((int)oldPathPoints[1][0], (int)oldPathPoints[1][1]);
			for(int i=0;i<6;i++){
//				System.out.println("Old Path 0 Itr");
				Point tempPoint0;
				Point tempPoint1;
				Point middlePointT0T1 = null;
				if(i<5){
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}else{
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[0],yPoint[0]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}
//				System.out.println("Middle Point, X : "+middlePointT0T1.getX()+" Y : "+ middlePointT0T1.getY());
				if(oldPathPointStart.equals(middlePointT0T1) || oldPathPointEnd.equals(middlePointT0T1)){
//					System.out.println("Old Path 0 contains the middle point");
					Point innertempPoint0;
					Point innertempPoint1;
					Point innermiddlePointT0T1 = null;
					if(middlePointT0T1.equals(oldPathPointStart)){//;// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the starting point");
							if(i<4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[(i+2)],yPoint[(i+2)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[0],yPoint[0]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[0],yPoint[0]);
								innertempPoint1 = new Point(xPoint[1],yPoint[1]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newStartingPoint2 = innermiddlePointT0T1;
						}
						if(middlePointT0T1.equals(oldPathPointEnd)){// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the ending point");
							if(i<4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[(i+2)],yPoint[(i+2)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==4){
								innertempPoint0 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
								innertempPoint1 = new Point(xPoint[0],yPoint[0]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[0],yPoint[0]);
								innertempPoint1 = new Point(xPoint[1],yPoint[1]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newEndingPoint2 = innermiddlePointT0T1;
						}
					//}
				}
			}
			if(newEndingPoint2!= null && newStartingPoint2!=null){
				newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
				newPath2.moveTo(newStartingPoint2.getX(), newStartingPoint2.getY());
				newPath2.lineTo(newEndingPoint2.getX(),newEndingPoint2.getY());
			}
			
		pathList.add(newPath0);
		pathList.add(newPath1);
		pathList.add(newPath2);
		return pathList;
	
	}
	public static Vector<GeneralPath> pathRightRotator(int[] xPoint,int[] yPoint,int indexCount,Vector<GeneralPath> oldGeneralPath){
		Vector<GeneralPath> pathList = new Vector<GeneralPath>();
		GeneralPath newPath0 = null,newPath1 = null,newPath2 = null;
		GeneralPath oldPath0 = null,oldPath1 = null,oldPath2 = null;
		Point newStartingPoint0 = null;
		Point newEndingPoint0 = null;
		Point newStartingPoint1 = null;
		Point newEndingPoint1 = null;
		Point newStartingPoint2 = null;
		Point newEndingPoint2 = null;
		int pathLength = 2;
		//rotating first
			oldPath0 = oldGeneralPath.get(0);
			double[][] oldPathPoints = getXYPoints(oldPath0);
			Point oldPathPointStart = new Point();
				oldPathPointStart.setLocation((int)oldPathPoints[0][0], (int)oldPathPoints[0][1]);
				Point oldPathPointEnd = new Point();
				oldPathPointEnd.setLocation((int)oldPathPoints[1][0], (int)oldPathPoints[1][1]);
			//}
			for(int i=0;i<6;i++){
//				System.out.println("Old Path 0 Itr");
				Point tempPoint0;
				Point tempPoint1;
				Point middlePointT0T1 = null;
				if(i<5){
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}else{
					tempPoint0 = new Point(xPoint[5],yPoint[5]);
					tempPoint1 = new Point(xPoint[0],yPoint[0]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}
//				System.out.println("Middle Point, X : "+middlePointT0T1.getX()+" Y : "+ middlePointT0T1.getY());
				if(oldPathPointStart.equals(middlePointT0T1) || oldPathPointEnd.equals(middlePointT0T1)){
//					System.out.println("Old Path 0 contains the middle point");
					Point innertempPoint0;
					Point innertempPoint1;
					Point innermiddlePointT0T1 = null;
					if(middlePointT0T1.equals(oldPathPointStart)){//;// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the starting point");
							if(i>1){
								innertempPoint0 = new Point(xPoint[(i-2)],yPoint[(i-2)]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==1){
								innertempPoint0 = new Point(xPoint[5],yPoint[5]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[4],yPoint[4]);
								innertempPoint1 = new Point(xPoint[5],yPoint[5]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newStartingPoint0 = innermiddlePointT0T1;
						}
						if(middlePointT0T1.equals(oldPathPointEnd)){// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the ending point");
							if(i>1){
								innertempPoint0 = new Point(xPoint[(i-2)],yPoint[(i-2)]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==1){
								innertempPoint0 = new Point(xPoint[5],yPoint[5]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[4],yPoint[4]);
								innertempPoint1 = new Point(xPoint[5],yPoint[5]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newEndingPoint0 = innermiddlePointT0T1;
						}
					//}
				}
			}
			if(newEndingPoint0!= null && newStartingPoint0!=null){
//				System.out.println("Got the new path :) :)");
				newPath0 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
				newPath0.moveTo(newStartingPoint0.getX(), newStartingPoint0.getY());
				newPath0.lineTo(newEndingPoint0.getX(),newEndingPoint0.getY());
			}
		//rotating second
			oldPath1 = oldGeneralPath.get(1);
			oldPathPoints = getXYPoints(oldPath1);
//				System.out.println("Old  X : "+oldPathPoints[0][0]+" Y : "+oldPathPoints[0][1]);
//				System.out.println("Old  X : "+oldPathPoints[1][0]+" Y : "+oldPathPoints[1][1]);
				oldPathPointStart = new Point();
				oldPathPointStart.setLocation((int)oldPathPoints[0][0], (int)oldPathPoints[0][1]);
				oldPathPointEnd = new Point();
				oldPathPointEnd.setLocation((int)oldPathPoints[1][0], (int)oldPathPoints[1][1]);
			for(int i=0;i<6;i++){
//				System.out.println("Old Path 0 Itr");
				Point tempPoint0;
				Point tempPoint1;
				Point middlePointT0T1 = null;
				if(i<5){
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}else{
					tempPoint0 = new Point(xPoint[5],yPoint[5]);
					tempPoint1 = new Point(xPoint[0],yPoint[0]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}
//				System.out.println("Middle Point, X : "+middlePointT0T1.getX()+" Y : "+ middlePointT0T1.getY());
				if(oldPathPointStart.equals(middlePointT0T1) || oldPathPointEnd.equals(middlePointT0T1)){
//					System.out.println("Old Path 0 contains the middle point");
					Point innertempPoint0;
					Point innertempPoint1;
					Point innermiddlePointT0T1 = null;
					if(middlePointT0T1.equals(oldPathPointStart)){//;// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the starting point");
							if(i>1){
								innertempPoint0 = new Point(xPoint[(i-2)],yPoint[(i-2)]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==1){
								innertempPoint0 = new Point(xPoint[5],yPoint[5]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[4],yPoint[4]);
								innertempPoint1 = new Point(xPoint[5],yPoint[5]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newStartingPoint1 = innermiddlePointT0T1;
						}
						if(middlePointT0T1.equals(oldPathPointEnd)){// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the ending point");
							if(i>1){
								innertempPoint0 = new Point(xPoint[(i-2)],yPoint[(i-2)]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==1){
								innertempPoint0 = new Point(xPoint[5],yPoint[5]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[4],yPoint[4]);
								innertempPoint1 = new Point(xPoint[5],yPoint[5]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newEndingPoint1 = innermiddlePointT0T1;
						}
					//}
				}
			}
			if(newEndingPoint1!= null && newStartingPoint1!=null){
				newPath1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
				newPath1.moveTo(newStartingPoint1.getX(), newStartingPoint1.getY());
				newPath1.lineTo(newEndingPoint1.getX(),newEndingPoint1.getY());
			}
		//rotating third
			oldPath2 = oldGeneralPath.get(2);
			oldPathPoints = getXYPoints(oldPath2);
//				System.out.println("Old  X : "+oldPathPoints[0][0]+" Y : "+oldPathPoints[0][1]);
//				System.out.println("Old  X : "+oldPathPoints[1][0]+" Y : "+oldPathPoints[1][1]);
				oldPathPointStart = new Point();
				oldPathPointStart.setLocation((int)oldPathPoints[0][0], (int)oldPathPoints[0][1]);
				oldPathPointEnd = new Point();
				oldPathPointEnd.setLocation((int)oldPathPoints[1][0], (int)oldPathPoints[1][1]);
			for(int i=0;i<6;i++){
//				System.out.println("Old Path 0 Itr");
				Point tempPoint0;
				Point tempPoint1;
				Point middlePointT0T1 = null;
				if(i<5){
					tempPoint0 = new Point(xPoint[i],yPoint[i]);
					tempPoint1 = new Point(xPoint[(i+1)],yPoint[(i+1)]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}else{
					tempPoint0 = new Point(xPoint[5],yPoint[5]);
					tempPoint1 = new Point(xPoint[0],yPoint[0]);
					middlePointT0T1 = findMidPoint(tempPoint0, tempPoint1);
				}
//				System.out.println("Middle Point, X : "+middlePointT0T1.getX()+" Y : "+ middlePointT0T1.getY());
				if(oldPathPointStart.equals(middlePointT0T1) || oldPathPointEnd.equals(middlePointT0T1)){
//					System.out.println("Old Path 0 contains the middle point");
					Point innertempPoint0;
					Point innertempPoint1;
					Point innermiddlePointT0T1 = null;
					if(middlePointT0T1.equals(oldPathPointStart)){//;// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the starting point");
							if(i>1){
								innertempPoint0 = new Point(xPoint[(i-2)],yPoint[(i-2)]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==1){
								innertempPoint0 = new Point(xPoint[5],yPoint[5]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[4],yPoint[4]);
								innertempPoint1 = new Point(xPoint[5],yPoint[5]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newStartingPoint2 = innermiddlePointT0T1;
						}
						if(middlePointT0T1.equals(oldPathPointEnd)){// || innermiddlePointT0T1==oldEndingPoint){
//							System.out.println("Got the ending point");
							if(i>1){
								innertempPoint0 = new Point(xPoint[(i-2)],yPoint[(i-2)]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else if(i==1){
								innertempPoint0 = new Point(xPoint[5],yPoint[5]);
								innertempPoint1 = new Point(xPoint[(i-1)],yPoint[(i-1)]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}else{
								innertempPoint0 = new Point(xPoint[4],yPoint[4]);
								innertempPoint1 = new Point(xPoint[5],yPoint[5]);
								innermiddlePointT0T1 = findMidPoint(innertempPoint0, innertempPoint1);
							}
							newEndingPoint2 = innermiddlePointT0T1;
						}
					//}
				}
			}
			if(newEndingPoint2!= null && newStartingPoint2!=null){
				newPath2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,pathLength);
				newPath2.moveTo(newStartingPoint2.getX(), newStartingPoint2.getY());
				newPath2.lineTo(newEndingPoint2.getX(),newEndingPoint2.getY());
			}
			
		pathList.add(newPath0);
		pathList.add(newPath1);
		pathList.add(newPath2);
		return pathList;
	}

	public static double[][] getXYPoints(GeneralPath path) {
		PathIterator pi = path.getPathIterator(null);
		Vector<double[]> pointList = new Vector<double[]>();
	    double[] coords = new double[6];
	    while (!pi.isDone()) {
	        switch (pi.currentSegment(coords)) {
	        case PathIterator.SEG_MOVETO:
	            pointList.add(Arrays.copyOf(coords, 2));
	            break;
	        case PathIterator.SEG_LINETO:
	            pointList.add(Arrays.copyOf(coords, 2));
	            break;
	        }
	        pi.next();
	    }
	    return pointList.toArray(new double[pointList.size()][]);
	}
	
}
