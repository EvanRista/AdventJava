import java.util.ArrayList; 

public class HydroVent {

	public static void main (String [] args) {
		int [] fishArray = {3,4,1,1,5,1,3,1,1,3,5,1,1,5,3,2,4,2,2,2,1,1,1,1,5,1,1,1,1,1,3,1,1,5,4,1,1,1,4,1,1,1,1,2,3,2,5,1,5,1,2,1,1,1,4,1,1,1,1,3,1,1,3,1,1,1,1,1,1,2,3,4,2,1,3,1,1,2,1,1,2,1,5,2,1,1,1,1,1,1,4,1,1,1,1,5,1,4,1,1,1,3,3,1,3,1,3,1,4,1,1,1,1,1,4,5,1,1,3,2,2,5,5,4,3,1,2,1,1,1,4,1,3,4,1,1,1,1,2,1,1,3,2,1,1,1,1,1,4,1,1,1,4,4,5,2,1,1,1,1,1,2,4,2,1,1,1,2,1,1,2,1,5,1,5,2,5,5,1,1,3,1,4,1,1,1,1,1,1,1,4,1,1,4,1,1,1,1,1,2,1,2,1,1,1,5,1,1,3,5,1,1,5,5,3,5,3,4,1,1,1,3,1,1,3,1,1,1,1,1,1,5,1,3,1,5,1,1,4,1,3,1,1,1,2,1,1,1,2,1,5,1,1,1,1,4,1,3,2,3,4,1,3,5,3,4,1,4,4,4,1,3,2,4,1,4,1,1,2,1,3,1,5,5,1,5,1,1,1,5,2,1,2,3,1,4,3,3,4,3}; 
		
		ArrayList <Integer> fish = new ArrayList <> (); 
		
		for (int i = 0; i< fishArray.length; i++) {
			fish.add(fishArray[i]);
		}
	 
				
		runSimulation (fish, 80); 
	}
	
	
	public static ArrayList <Integer> tick (ArrayList <Integer> fish) {
		int repeat = fish.size(); 
		
		for (int i = 0; i < repeat; i++) {
			int timer = fish.get(i);
			
			if (timer != 0) {
				timer--; 	
			}
			
			else {				
				timer = 6; 
				fish.add(8); 
			}
			
		fish.set (i, timer); 
		}
		
		return fish; 
	}
	
	public static void runSimulation (ArrayList <Integer> fish, int Days) {	
		
		for (int i = 0; i < Days; i++) {
		
			if (i == 0) System.out.print ("Initial State:\t");
			else System.out.print ("Day " + i + ":\t\t"); 
			
			System.out.println (fish); 
			fish = tick (fish); 	
		}
		System.out.print ("Day " + Days + ":\t\t"); 
		System.out.println (fish); 
		
	System.out.println (fish.size());
	}
		
}
