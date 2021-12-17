package day13;

	import java.util.ArrayList;

	class Day13 {
	  public static void main(String[] args) {
	    //importFile.convertInstructions(importFile.importFiles("testData.txt"));
	    
	   System.out.println(folding("day13input.txt"));
	  }
	  
	  public static int folding(String fileName){
	    
	    String[][] board = makeBoard(895, 1311); 
	    // Size of board is 2 * num on first instruction +1 rows = y axis flip, columns = x axis flip

	    board = addPoints(board, importFiles.getData(fileName));
	    printMe(board);

	    board = fold(importFiles.convertInstructions(importFiles.importFile(fileName)).size(), board, importFiles.convertInstructions(importFiles.importFile(fileName)));

	    int count = 0;

	    for(int row = 0; row < board.length; row++){
	      for(int col = 0; col < board[0].length; col++){
	        if(board[row][col].equals("#")) count++;
	      }
	    }


	    return count;
	  }

	  public static String[][] fold (int num, String[][] board, ArrayList<foldPoint> lines){

	    for(int i = 0; i < num; i++){
	      foldPoint foldLine = lines.get(i);

	      if(foldLine.getx() != -1){
	        board = moveLeft(board, foldLine.getx());
	      }
	      else if(foldLine.gety() != -1){
	        board = moveUp(board, foldLine.gety());
	      }
	      printMe(board);
	    }
	    
	    return board;
	  }

	  public static String[][] moveUp(String[][] board, int horzLine){
	    String[][] newBoard = makeBoard(horzLine + 1, board[0].length);
	    
	    //Make in class
	    for (int row = 0; row < board.length; row++) {
	      for (int col = 0; col < board[0].length; col++) {
	        if (board[row][col].equals("#") && horzLine > row) {
	          newBoard[row][col] = "#";

	        }
	        else if(board[row][col].equals("#") && horzLine < row){
	          newBoard[row - (row - horzLine) * 2][col] = "#";
	        }
	      }
	    }



	    return newBoard;
	  }

	  public static String[][] moveLeft(String[][] board, int vertLine){
	        String[][] newBoard = makeBoard(board.length, vertLine + 1);

	    //Make in class
	    for (int row = 0; row < board.length; row++) {
	      for (int col = 0; col < board[0].length; col++) {
	        if (board[row][col].equals("#") && vertLine > col) {
	          newBoard[row][col] = "#";

	        }
	        else if (board[row][col].equals("#") && vertLine < col) {
	          newBoard[row][col - (col - vertLine) * 2] = "#"; 
	        }
	      }
	    }


	    return newBoard;
	  }

	  public static String[][] addPoints(String[][] board, ArrayList<foldPoint> points){
		    for(int i = 0; i < points.size(); i++){
		      board[points.get(i).gety()][points.get(i).getx()] = "#";
		    }
	    
	    return board;
	  }

	  public static String[][] makeBoard(int rows, int cols){
	    String[][] board = new String[rows][cols];

	    for(int row = 0; row < board.length; row++){
	      for(int col = 0; col < board[0].length; col++){
	        board[row][col] = "-";
	      }
	    }
	    
	    return board;
	  }

	  public static void printMe(String[][] board){

	    for(int row = 0; row < board.length; row++){
	      for(int col = 0; col < board[0].length; col++){
	        System.out.print(board[row][col] + " ");
	      }
	      System.out.println();
	    }

	  }

	}


