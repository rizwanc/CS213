package model;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

public class Board {
	
	/**
	 * Chess board
	 * lower case letters represent black pieces
	 * Upper case letters represent white pieces
	 * Letter N,n represent knights and the letter K,k represent
	 * the king
	 */
	 public static String chessBoard[][]={
		    {"r","n","b","q","k","b","n","r"},
	        {"p","p","p","p","p","p","p","p"},
	        {" "," "," "," "," "," "," "," "},
	        {" "," "," "," "," "," "," "," "},
	        {" "," "," "," "," "," "," "," "},
	        {" "," "," "," "," "," "," "," "},
	        {"P","P","P","P","P","P","P","P"},
	        {"R","N","B","Q","K","B","N","R"}};

	 
	 public static void makeMove(String move){		 
			 chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))] = chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))];
			 chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = " ";
	 }	
}
