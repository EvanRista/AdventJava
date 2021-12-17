package day5;

public class HydroPoint {

	private int x1;
	private int y1;
	private int x2;
	private int y2;



	public HydroPoint (int xOne, int yOne, int xTwo, int yTwo) {
	  this.x1 = xOne;
	  this.y1 = yOne;
	  this.x2 = xTwo;
	  this.y2 = yTwo;
	}

	public int getx1 () {
	  return this.x1; 
	}
	public int gety1 () {
	  return this.y1; 
	}
	public int getx2 () {
	  return this.x2;
	}
	public int gety2 () {
	  return this.y2; 
	}

}

