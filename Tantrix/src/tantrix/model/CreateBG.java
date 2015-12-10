package tantrix.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class CreateBG {
	
    public Map<Integer,Vector<Integer>> drawHexGridLoop(Point origin, int size, int radius, int padding) {
    	Map<Integer,Vector<Integer>> BGValues = new HashMap<Integer,Vector<Integer>>();
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;
        int count = 0;
        for (int row = 0; row < size; row++) {
            int cols = size - java.lang.Math.abs(row - half);
            
            for (int col = 0; col < cols; col++) {
            	Vector<Integer> tempList = new Vector<>();
                int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                int y = (int) (origin.y + yOff * (row - half) * 3);
                tempList.add(x);
                tempList.add(y);
                tempList.add(radius);
                BGValues.put(count, tempList);
                count++;            
            }
            
        }
        return BGValues;
    }
    

}
