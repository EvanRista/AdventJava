package day5;

import java.util.ArrayList; 

public class Day5 {

	 public static void main(String[] args) {
		    dangerSpots("day5input.txt");
		 
		  }

	 public static int[][] fillArray (ArrayList<HydroPoint> points) {
			int[][] map = new int [1000][1000];
			    
			for (int index = 0; index < points.size(); index++) {
			  int x1 = points.get(index).getx1(); 
			  int y1 = points.get(index).gety1(); 
			  int x2 = points.get(index).getx2(); 
			  int y2 = points.get(index).gety2(); 
			  int run = x2 - x1;
			  int rise = y2 - y1;
			  int slope = 0;
			      
	      if ((run > 0 || run < 0) && (rise > 0 || rise < 0)) {
	        slope = rise / run; 
	      }
			      
			    //System.out.println (rise +"\t / \t" +run + "\t\t" + slope);
			      
			  int minX = Math.min(x1, x2);
			  int maxX = Math.max(x1, x2);
			  int minY = Math.min(y1, y2);
			  int maxY = Math.max(y1, y2);
			          

	      if (rise == 0) {
			    for (int col = 0; col < map[0].length; col++) {
	          if (col >= minX && col <= maxX) {
	            map[y1][col]++;
			      }
			    }
	      } 
	      else if (run == 0) {
			    for (int row = 0; row < map.length; row++) {
			      if (row >= minY && row <= maxY ) {
	            map[row][x1]++;
			      }
			    }
	      }
			     
			       //If the points are not on the same axis, then the slope is calculated      
	        	  else if (slope != 0) {

	        		  for (int col = minX; col <= maxX; col += Math.abs(slope)) {
	            
	              if (slope > 0) {
	                  if (minY <= maxY) {
	                    map[minY][col]++; 
	                    minY += slope; 
	                  }
	              }
	              else {
	                  if (minY <= maxY) {
	                    map[maxY][col]++;
	                    maxY += slope;
	                  }


	              	}

	        	}
	        }


	      }

	   return map; 
	   }
		    
		  public static void printArray (int[][] map) {

		    for (int row = 0; row < map.length; row++) {
		        for (int col = 0; col < map[0].length; col++) {
		          System.out.print (map[row][col] + "");

		        }
		        System.out.println (); 
		    }
		  }
		  
		  //Since the way the test works, I had to change our other methods to work around this one. 
		  public static int dangerSpots(String data){
		    ArrayList<HydroPoint> points = DataImporting.getData(data);
		      
		      int dangerPoints = 0; 
		      int[][] map = fillArray(points);

		      for (int row = 0; row < map.length; row++) { 
		          for (int col = 0; col < map[0].length; col++) {
		            if (map[col][row] >= 2) dangerPoints++;
		          }
		      }

		    printArray(map);
		    System.out.println (dangerPoints + " POINTS FOUND");

		    return dangerPoints; 
		  }

}
