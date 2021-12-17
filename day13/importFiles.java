package day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class importFiles {
	
		public static ArrayList<foldPoint> getData (String filename) {
		return convert(importFile(filename));
		}
	
	  public static ArrayList<String> importFile (String fileName){
		  ArrayList<String> words = new ArrayList<>();
		  try {
		    File myObj = new File(fileName);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      words.add(data);
		    }
		    myReader.close();
		  } catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		  }
      //System.out.println(words);
		  return words;
		}

	  //Converts each element in the ArrayList into a new object, and then adds it into a new Hydropoint ArrayList
	  private static ArrayList<foldPoint> convert (ArrayList<String> list) {
	    ArrayList <foldPoint> point = new ArrayList <> ();

	    for (int i = 0; i < list.size(); i++) {      
          String word = list.get(i);

        if (word.indexOf(",") != -1) {
	        int x = Integer.parseInt(word.substring(0, word.indexOf(",")));
	        int y = Integer.parseInt(word.substring(word.indexOf(",") + 1)); 
	        point.add(new foldPoint(x, y));
          i--;
          list.remove(0);
        }
      }
    
	    return point; 
	    }
    
    public static ArrayList<foldPoint> convertInstructions (ArrayList<String> list) {
      	ArrayList <foldPoint> points = new ArrayList <> (); 

        for (int i = 0; i < list.size(); i++) {   
          int x = -1;
          int y = -1; 

          String word = list.get(i);
          if (word.indexOf("y") >= 0) { 
            y = Integer.parseInt(word.substring(word.indexOf("y") + 2)); 
          points.add(new foldPoint(x, y));
          System.out.println ("POINT " + y + " on y-axis (Goes left and right)");
          }
          else if (word.indexOf ("x") >= 0) {
            x = Integer.parseInt (word.substring(word.indexOf("x") + 2));
            points.add(new foldPoint(x, y));
            System.out.println ("POINT " + x + " on x-axis (Goes up and down)");

          }

          }
        return points; 
        }

      
    


	}