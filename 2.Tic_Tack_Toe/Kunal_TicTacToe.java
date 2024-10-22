package Tic_Tack_Toe;

import java.util.Scanner;

public class Kunal_TicTacToe {

	public static void main(String[] args) {
		
		  
		  
		  char [][] board = new char [3][3];
		  
		  for(int row = 0; row < board.length; row++) {
			  for(int col = 0; col < board[row].length; col++) {
				  board[row][col] = ' ';
			  }
		  }
		  
		  char player = 'X';
		  boolean gameOver = false;
		    
		  Scanner scanner = new Scanner(System.in);
		  
		// while (!gameOVer) == it is << the same >>  == while (gameOver == false) 
		  
		  while(!gameOver) {
			  printBoard(board);
			  System.out.print("Player " + player + " enter: ");
			  int row = scanner.nextInt();
			  int col = scanner.nextInt();
			  
			  if(board[row][col] == ' ' ) {
				  
				  //place the element
				   board[row][col] = player;
				   gameOver = hasWon(board, player);
				   
				   if(gameOver) {
					   System.out.println("Player " + player + " has won! ");
				   }
				   else {
					
//					   if(player == 'X') {
//						   player = 'O';
//					   }
//						   else {
//							   player = 'X';
//						   }
					   
					   //this line is the same condition with above!
					   player = (player == 'X') ? 'O' : 'X';
					      
					   }  
				  
			  }
		  
			  else {
				  
				 // gameOver = true;
				 // if(! gameOver) {
				  System.out.println("Invalid Move. Try Again!");
				  }
				 // else
					
			  
			  
		  }

	}
	
	
	
	public static boolean hasWon (char[][] board, char player) {
		
		//check the rows
		 for(int row = 0; row < board.length; row++) {
			 if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				 return true;
			 }
		 }
		
		//check the columns 
		 for(int col = 0; col < board[0].length; col++) {
			 if(board[0][col] == player && board[1][col] == player && board[2 ][col] == player) {
				 return true;
			 }
		 }
		 
		//check the diagonals 
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		
		return false;

	}
	
	public static void printBoard (char[][] board) {
		
		 for(int row = 0; row < board.length; row++) {
			  for(int col = 0; col < board[row].length; col++) {
				  System.out.print(board[row][col]  + " | ");
			  }
			  
			  System.out.println();
		  }
		  
	}
	
}
