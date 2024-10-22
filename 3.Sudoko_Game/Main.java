package Sudoko_Game;
class Main {


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//


	private static  final int  Grid_Size = 9;
	  public static void main(String[] args) {
	int[][] board = { 
	    {5, 3, 0, 0, 7, 0, 0, 0, 0},
	    {6, 0, 0, 1, 9, 5, 0, 0, 0},
	    {0, 9, 8, 0, 0, 0, 0, 6, 0},
	    {8, 0, 0, 0, 6, 0, 0, 0, 3},
	    {4, 0, 0, 8, 0, 3, 0, 0, 1},
	    {7, 0, 0, 0, 2, 0, 0, 0, 6},
	    {0, 6, 0, 0, 0, 0, 2, 8, 0},
	    {0, 0, 0, 4, 1, 9, 0, 0, 5},
	    {0, 0, 0, 0, 8, 0, 0, 7, 9}
	};


	    int[][] boardUnDone = new int[][] {
	        {2, 8, 3, 0, 0, 7, 0, 0, 0},
	        {6, 1, 7, 0, 0, 4, 0, 0, 0},
	        {9, 4, 5, 0, 0, 6, 0, 0, 0},
	        {3, 7, 5, 0, 0, 9, 0, 0, 0},
	        {4, 6, 9, 0, 0, 2, 0, 0, 0},
	        {8, 1, 2, 0, 0, 3, 0, 0, 0},
	        {7, 9, 2, 0, 0, 5, 0, 0, 0},
	        {1, 5, 3, 0, 0, 8, 0, 0, 0},
	        {5, 6, 8, 0, 0, 1, 0, 0, 0},
	    };

	    int[][] boardDone = {
	        {5, 3, 0, 0, 7, 0, 0, 0, 0},
	        {6, 0, 0, 1, 9, 5, 0, 0, 0},
	        {0, 9, 8, 0, 0, 0, 0, 6, 0},
	        {8, 0, 0, 0, 6, 0, 0, 0, 3},
	        {4, 0, 0, 8, 0, 3, 0, 0, 1},
	        {7, 0, 0, 0, 2, 0, 0, 0, 6},
	        {0, 6, 0, 0, 0, 0, 2, 8, 0},
	        {0, 0, 0, 4, 1, 9, 0, 0, 5},
	        {0, 0, 0, 0, 8, 0, 0, 7, 9},
	    };

	    int[][] boarDone = {
	        {7, 0, 2, 0, 5, 0, 6, 0, 0},
	        {0, 0, 0, 0, 0, 3, 0, 0, 0},
	        {1, 0, 0, 0, 0, 9, 5, 0, 0},
	        {8, 0, 0, 0, 0, 0, 0, 9, 0},
	        {0, 4, 3, 0, 0, 0, 7, 5, 0},
	        {0, 9, 0, 0, 0, 0, 0, 0, 8},
	        {0, 0, 9, 7, 0, 0, 0, 0, 5},
	        {0, 0, 0, 2, 0, 0, 0, 0, 0},
	        {0, 0, 7, 0, 4, 0, 2, 0, 3},
	    };

	    
	    

	    printBoard(board);
	    System.out.println();
	    
	    if(SolveBoard(board)){
	      System.out.println("Successfully Solved!");
	    }
	    else{
	      System.out.println("UnSolvable Sudoku!");
	    }
	    System.out.println();
	    
	    printBoard(board);
	    
	    
	    
	  }

	  private static void printBoard(int[][] board){
	    for(int row = 0; row < Grid_Size; row++){
	      if(row % 3 == 0 && row != 0 ){
	        System.out.println("---------------");
	      }
	      for(int column = 0; column < Grid_Size; column++){
	       if(column % 3 == 0 && column != 0 ){
	         System.out.print("| ");
	       }
	        System.out.print(board[row][column] +" ");
	      }
	      System.out.println();
	      
	    }
	    
	  }


	  private static boolean isNumberInRow(int[][] board, int number, int row){

	    for(int i = 0; i< Grid_Size; i++){
	      if(board[row][i] == number){
	        return true;
	      }
	    }

	    return false;
	  }

	  private static boolean isNumberInColumn(int[][] board, int number, int column){

	    for(int i = 0; i< Grid_Size; i++){
	      if(board[i][column] == number){
	        return true;
	      }
	    }

	    return false;
	  }

	  private static boolean isNumberInBox(int[][] board, int number, int row, int column){

	    int localBoxRow = row - row % 3;
	    int localBoxColumn = column - column % 3;

	    for(int i = localBoxRow; i< localBoxRow + 3; i++){
	      for(int j = localBoxColumn; j < localBoxColumn + 3; j++){
	        if(board[i][j] == number){
	          return true;
	      }
	    }
	  }

	    return false;
	  }

	  //This is the most imporatnt Method
	  //if all of the Three Methods return False
	  //that means this PLACE IS VALID to ADD.

	  // if the Row Method returns False -> that means in this Domain of Row it's oaky to Add a number here.

	  // if the Column Method returns Flase -> that means in this Domain of Column it's okay to Add a number here. 

	  //if the isNumberInBox Method returns Flase -> that means in this Domain of This Box of 3x3 field it's okay to Add a number here.

	  private static boolean isValidPlacement(int[][] board, int number, int row, int column){
	    return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column) && !isNumberInBox(board, number, row, column);
	    
	  }


	  private static boolean SolveBoard(int [][] board){

	    for(int row = 0; row < Grid_Size; row ++){
	      for(int column = 0; column < Grid_Size; column ++){
	        if(board[row][column] == 0){
	          for(int numberToTry = 1; numberToTry <= Grid_Size; numberToTry ++){
	            if(isValidPlacement(board, numberToTry, row, column)){
	              board[row][column] = numberToTry;
	              if(SolveBoard(board)){
	                return true;
	              }
	              else{
	                board[row][column] = 0;
	              }
	            }
	          }
	          
	          return false;
	        }
	      }
	    }

	    return true;
	    
	  }

	  
	  

	  
	}