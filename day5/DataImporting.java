package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataImporting {
	
		public static ArrayList<HydroPoint> getData (String filename) {
		return convert(importFile(filename));
		}
	

	  public static ArrayList<String> importFile (String fileName){
		  ArrayList<String> nums = new ArrayList<>();
		  try {
		    File myObj = new File(fileName);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      nums.add(data);
		    }
		    myReader.close();
		  } catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		  }
		  return nums;
		}

	  //Converts each element in the ArrayList into a new object, and then adds it into a new Hydropoint ArrayList
	  public static ArrayList<HydroPoint> convert (ArrayList<String> list) {
	    ArrayList <HydroPoint> points = new ArrayList <> ();

	    for (int i = 0; i < list.size(); i++) {      
	      int index = list.get(i).indexOf(" "); 

	      String word = ""; 

	        word = list.get(i).substring(0, index); 
	        int x1 = Integer.parseInt(word.substring(0, word.indexOf(",")));
	        int y1 = Integer.parseInt(word.substring(word.indexOf(",") + 1)); 
	      
	        word = list.get(i).substring(index + 4);
	        int x2 = Integer.parseInt(word.substring(0, word.indexOf(",")));
	        int y2 = Integer.parseInt(word.substring(word.indexOf(",") + 1)); 

	        points.add(new HydroPoint(x1, y1, x2, y2));
	      }

	    return points; 
	    }
	 
	}
	
