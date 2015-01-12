package pieces;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import model.Board;

public class Rook extends AbstractPiece{

	public String possibleMoves(int i, int k){
		String list="";
		String oldPiece;
        int r=i;
        int c=k;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            try {
                while(" ".equals(Board.chessBoard[r][c+temp*j]))
                {
                    oldPiece=Board.chessBoard[r][c+temp*j];
                    Board.chessBoard[r][c]=" ";
                    Board.chessBoard[r][c+temp*j]="R";
                    if (isKingSafe()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    Board.chessBoard[r][c]="R";
                    Board.chessBoard[r][c+temp*j]=oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(Board.chessBoard[r][c+temp*j].charAt(0))) {
                    oldPiece=Board.chessBoard[r][c+temp*j];
                    Board.chessBoard[r][c]=" ";
                    Board.chessBoard[r][c+temp*j]="R";
                    if (isKingSafe()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece+" ";
                    }
                    Board.chessBoard[r][c]="R";
                    Board.chessBoard[r][c+temp*j]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(Board.chessBoard[r+temp*j][c]))
                {
                    oldPiece=Board.chessBoard[r+temp*j][c];
                    Board.chessBoard[r][c]=" ";
                    Board.chessBoard[r+temp*j][c]="R";
                    if (isKingSafe()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    Board.chessBoard[r][c]="R";
                    Board.chessBoard[r+temp*j][c]=oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(Board.chessBoard[r+temp*j][c].charAt(0))) {
                    oldPiece=Board.chessBoard[r+temp*j][c];
                    Board.chessBoard[r][c]=" ";
                    Board.chessBoard[r+temp*j][c]="R";
                    if (isKingSafe()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece+" ";
                    }
                    Board.chessBoard[r][c]="R";
                    Board.chessBoard[r+temp*j][c]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
        }
        return list;
	}
}
