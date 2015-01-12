package control;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import java.util.Arrays;
import java.util.Scanner;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

import model.Board;

public class Chess {
	
	public static void main(String[] args){
		
		//Keep track of whether each player's turn is over or not
		boolean whitesTurnOver = false;
		boolean blacksTurnOver = false;
		
		//Stores the possible moves that a particular piece can make
		String wMoves = "";
		String bMoves = "";
		
		//Creates all the pieces for the white side, player 1
		King wKing = new King();
		Queen wQueen = new Queen();
		Knight wKnight = new Knight();
		Bishop wBishop = new Bishop();
		Rook wRook = new Rook();
	    Pawn wPawn = new Pawn();
	    
	    //Creates all the pieces for the black side, player 2
	    King bKing = new King();
		Queen bQueen = new Queen();
		Knight bKnight = new Knight();
		Bishop bBishop = new Bishop();
		Rook bRook = new Rook();
	    Pawn bPawn = new Pawn();
		
	    System.out.println("Coordinates of the board work in the opposite \n" +
	    		"direction from the specified way " +
				"in the assignment page.  Black pieces coordinates \n" +
				"work starting at 0 and then goes down to white ending " +
				"at 7.  So in order to move a black piece you \n" +
				"would specify for example b1 to b3 which move a pawn. \n  " +
				"In order to move a white piece you would specify" +
				"b6 to b5 which would also move a pawn.  ");
		
	    
		//Display the board
		displayBoard();
		
		//Main game loop
		while(true){
			
		//Player 1's turn (white)
		while(!whitesTurnOver){
			//King.kingPositionC = King.returnWKingPosition();
			//King.kingPositionL = King.returnWKingPosition();
			
			System.out.println("Whites turn :");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("resign")){
				return;
			}
			
			if(input.length() == 11 && input.charAt(6) == 'd'){
				System.out.println("does black accept draw? ");
				input = sc.nextLine();
				if(input.equalsIgnoreCase("draw")){
					return;
				}else{
					continue;
				}
			}
			
			if(!input.contains(" ")){
				System.out.println("Command not in valid format, must be in a form such as: e2 e4");
				continue;
			}
		
			String pieceCoordinate = input.substring(0, input.indexOf(" "));
			String moveCoordinate = input.substring(input.indexOf(" ") + 1);
			
			pieceCoordinate = translateMove(pieceCoordinate);
			
			if(Character.getNumericValue(pieceCoordinate.charAt(0)) == -1){
				System.out.println("Not a valid move");
				continue;
			}
			
			moveCoordinate  = translateMove(moveCoordinate);
			
			if(Character.getNumericValue(moveCoordinate.charAt(0)) == -1){
				System.out.println("Not a valid move");
				continue;
			}
			
			if(pieceCoordinate.equalsIgnoreCase(moveCoordinate)){
				System.out.println("The piece coordinate cannot be the same as the move coordinate");
				continue;
			}
			
			switch(Board.chessBoard[Character.getNumericValue(pieceCoordinate.charAt(0))][Character.getNumericValue(pieceCoordinate.charAt(1))]){
			
			case "P":
				
				wMoves = wPawn.possibleMoves(Character.getNumericValue(pieceCoordinate.charAt(0)), Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("Here " + wMoves);
				
				break;
			case "R":
				
				wMoves = wRook.possibleMoves(Character.getNumericValue(pieceCoordinate.charAt(0)), Character.getNumericValue(pieceCoordinate.charAt(1)));
				
				break;
			case "N":
				
				wMoves = wKnight.possibleMoves(Character.getNumericValue(pieceCoordinate.charAt(0)), Character.getNumericValue(pieceCoordinate.charAt(1)));
				
				break;
			case "B":
				
				wMoves = wBishop.possibleMoves(Character.getNumericValue(pieceCoordinate.charAt(0)), Character.getNumericValue(pieceCoordinate.charAt(1)));
				
				break;
			case "Q":
				
				wMoves = wQueen.possibleMoves(Character.getNumericValue(pieceCoordinate.charAt(0)), Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("Here " + wMoves);
				
				break;
			case "K":
				
				wMoves = wKing.possibleMoves(Character.getNumericValue(pieceCoordinate.charAt(0)), Character.getNumericValue(pieceCoordinate.charAt(1)));
				
				break;
			
			default:
				System.out.println("Entered move for black piece it is white's turn ");
				continue;
			}
			
		    boolean validMove = isValid(wMoves, moveCoordinate);
		    
		    if(validMove == true){
		    	Board.makeMove(pieceCoordinate + "" + moveCoordinate);
		    	displayBoard();
		    	whitesTurnOver = true;
		    }
		}
		
		//Player 2's turn (black)
         while(!blacksTurnOver){
        	 
			System.out.println("Blacks turn :");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("resign")){
				return;
			}
			
			if(input.length() == 11 && input.charAt(6) == 'd'){
				System.out.println("does white accept draw? ");
				input = sc.nextLine();
				if(input.equalsIgnoreCase("draw")){
					return;
				}else{
					continue;
				}
			}
			
			if(!input.contains(" ")){
				System.out.println("Command not in valid format, must be in a form such as: e2 e4");
				continue;
			}
		
			String pieceCoordinate = input.substring(0, input.indexOf(" "));
			String moveCoordinate = input.substring(input.indexOf(" ") + 1);
			
			pieceCoordinate = translateMove(pieceCoordinate);
			
			if(Character.getNumericValue(pieceCoordinate.charAt(0)) == -1){
				System.out.println("Not a valid move");
				continue;
			}
			
			moveCoordinate  = translateMove(moveCoordinate);
			
			if(Character.getNumericValue(moveCoordinate.charAt(0)) == -1){
				System.out.println("Not a valid move");
				continue;
			}
			
			if(pieceCoordinate.equals(moveCoordinate)){
				System.out.println("The piece coordinate cannot be the same as the move coordinate");
				continue;
			}
			
	        switch(Board.chessBoard[Character.getNumericValue(pieceCoordinate.charAt(0))][Character.getNumericValue(pieceCoordinate.charAt(1))]){
			
			case "p":
				
				flipBoard();
				bMoves = bPawn.possibleMoves(7-Character.getNumericValue(pieceCoordinate.charAt(0)), 7-Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("Pawn " + bMoves);
				
				break;
			case "r":
				
				flipBoard();
				bMoves = bRook.possibleMoves(7-Character.getNumericValue(pieceCoordinate.charAt(0)), 7-Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("Rook " + bMoves);
				
				break;
			case "n":
				
				flipBoard();
				bMoves = bKnight.possibleMoves(7-Character.getNumericValue(pieceCoordinate.charAt(0)), 7-Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("Knigh " + bMoves);
				
				break;
			case "b":
				
				flipBoard();
				bMoves = bBishop.possibleMoves(7-Character.getNumericValue(pieceCoordinate.charAt(0)), 7-Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("bishop " + bMoves);
				
				break;
			case "q":
				
				flipBoard();
				bMoves = bQueen.possibleMoves(7-Character.getNumericValue(pieceCoordinate.charAt(0)), 7-Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("Queen " + bMoves);
				
				break;
			case "k":
				
				flipBoard();
				bMoves = bKing.possibleMoves(7-Character.getNumericValue(pieceCoordinate.charAt(0)), 7-Character.getNumericValue(pieceCoordinate.charAt(1)));
				//System.out.println("King " + bMoves);
				
				break;
				
			default:
				System.out.println("Entered move for white piece it is blacks's turn ");
				continue;
			}
		
            int row = Character.getNumericValue(moveCoordinate.charAt(0));
            row = 7-row;
            
            int col = Character.getNumericValue(moveCoordinate.charAt(1));
            col = 7-col;
         
		    boolean validMove = isValid(bMoves, row + "" + col);
        
		    if(validMove == true){
		    	flipBoard();
		    	Board.makeMove(pieceCoordinate + "" + moveCoordinate);
		    	displayBoard();
		    	blacksTurnOver = true;
		    }
	    }	
        whitesTurnOver = false;
        blacksTurnOver = false;
    }
}
	
	/**
	 * Display the chess board
	 */
	private static void displayBoard(){
		
		for(int i = 0; i < 8; i++){
			System.out.println(Arrays.toString(Board.chessBoard[i]) + " " + i);
		}
		
		System.out.println(" -  -  -  -  -  -  -  -");
		System.out.println(" a, b, c, d, e, f, g, h");
	}
	
	/**
	 * Flip the board every time it is a players moves
	 */
	public static void flipBoard() {
        String temp;
        int r;
        int c;
        for (int i=0;i<32;i++) {
        	
        	r = i/8;
        	c = i%8;
        	
            if (Character.isUpperCase(Board.chessBoard[r][c].charAt(0))) {
                temp = Board.chessBoard[r][c].toLowerCase();
            } else {
                temp = Board.chessBoard[r][c].toUpperCase();
            }
            
            if (Character.isUpperCase(Board.chessBoard[7-r][7-c].charAt(0))) {
                Board.chessBoard[r][c] = Board.chessBoard[7-r][7-c].toLowerCase();
            } else {
                Board.chessBoard[r][c] = Board.chessBoard[7-r][7-c].toUpperCase();
            }
            Board.chessBoard[7-r][7-c] = temp;
        }
        int kingTemp = King.kingPositionC;
        King.kingPositionC = 63-King.kingPositionL;
        King.kingPositionL = 63-kingTemp;
    }

	/**
	 * Validate whether the coordinates the piece is to be moved to is valid
	 */
	private static boolean isValid(String moves,String moveCoordinate){
		
		if(moves.length() < 1){
			System.out.println("There are no more moves/invalid move!");
			return false;
		}
		
		//System.out.println("inside Validate here is the moveCoordinate " + moveCoordinate);
		
		String sub = moves.substring(0, moves.indexOf(" "));
		
		//System.out.println("inside Validate here is the sub " + sub);
		
		String rest = moves.substring(moves.indexOf(" ")+1);
		
		//System.out.println("inside Validate here is the rest " + rest);
		
		for(int i = 0; i < moves.length(); i++){
			
			if(sub.length() == 0){
				System.out.println("No match");
				break;
			}
			
			if(Character.getNumericValue(moveCoordinate.charAt(0)) == Character.getNumericValue(sub.charAt(2)) 
					&& Character.getNumericValue(moveCoordinate.charAt(1)) == Character.getNumericValue(sub.charAt(3))){
				
				return true;
				
			} else {
				sub = rest;
				
				//System.out.println("Here is sub which is now set to rest " + sub);
				
				if(rest.length() == 0){
					System.out.println("No match");
					break;
				}
				
				if(sub.length() == 4){
					continue;
				}
					
				sub = sub.substring(0, rest.indexOf(" "));
				//System.out.println("Here is the second substring of sub " + sub);
					
				rest = rest.substring(rest.indexOf(" ") + 1);
				//System.out.println("Here is the second rest " + rest);
					
				}
			} 
		return false;
	}
	
	/**
	 * Gets the move provided by the player
	 * finds the piece associated with the given coordinate
	 * returns the location location of the piece in terms of the
	 * array
	 * @return
	 */
	private static String translateMove(String coordinate){
		
		String finalc = "";
		char num;
		int row;
		int col;
		
		if(Character.getNumericValue(coordinate.charAt(1)) > 7){
			return "-1";
		}
		
		if(Character.isAlphabetic(coordinate.charAt(1))){
			return finalc = "-1";
		}
		
		switch(coordinate.charAt(0)){
		case 'a':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 0;
		    
		    finalc = row + "" + col;
			break;
		case 'b':
			 num = coordinate.charAt(1);
			 row = Character.getNumericValue(num);  
		     col = 1;
		    
		     finalc = row + "" + col;
			 break;
		case 'c':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 2;
		    
		    finalc = row + "" + col;
			break;
		case 'd':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 3;
		    
		    finalc = row + "" + col;
			break;
		case 'e':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 4;
		    
		    finalc = row + "" + col;
			break;
		case 'f':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 5;
		    
		    finalc = row + "" + col;
			break;
		case 'g':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 6;
		    
		    finalc = row + "" + col;
			break;
		case 'h':
			num = coordinate.charAt(1);
			row = Character.getNumericValue(num);  
		    col = 7;
		    
		    finalc = row + "" + col;
			break;
		default:
			return finalc = "-1";
		}
			
		return finalc;
	}
	
}


