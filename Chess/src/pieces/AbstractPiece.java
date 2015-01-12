package pieces;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import model.Board;

public abstract class AbstractPiece implements Piece {
	
	public boolean isKingSafe(){
		 //bishop/queen
        int temp=1;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(Board.chessBoard[King.kingPositionC/8+temp*i][King.kingPositionC%8+temp*j])) {temp++;}
                    if ("b".equals(Board.chessBoard[King.kingPositionC/8+temp*i][King.kingPositionC%8+temp*j]) ||
                            "q".equals(Board.chessBoard[King.kingPositionC/8+temp*i][King.kingPositionC%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        //rook/queen
        for (int i=-1; i<=1; i+=2) {
            try {
                while(" ".equals(Board.chessBoard[King.kingPositionC/8][King.kingPositionC%8+temp*i])) {temp++;}
                if ("r".equals(Board.chessBoard[King.kingPositionC/8][King.kingPositionC%8+temp*i]) ||
                        "q".equals(Board.chessBoard[King.kingPositionC/8][King.kingPositionC%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(Board.chessBoard[King.kingPositionC/8+temp*i][King.kingPositionC%8])) {temp++;}
                if ("r".equals(Board.chessBoard[King.kingPositionC/8+temp*i][King.kingPositionC%8]) ||
                        "q".equals(Board.chessBoard[King.kingPositionC/8+temp*i][King.kingPositionC%8])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
        }
        //knight
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    if ("k".equals(Board.chessBoard[King.kingPositionC/8+i][King.kingPositionC%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {}
                try {
                    if ("k".equals(Board.chessBoard[King.kingPositionC/8+i*2][King.kingPositionC%8+j])) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        //pawn
        if (King.kingPositionC>=16) {
            try {
                if ("p".equals(Board.chessBoard[King.kingPositionC/80-1][King.kingPositionC%8-1])) {
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("p".equals(Board.chessBoard[King.kingPositionC/80-1][King.kingPositionC%8+1])) {
                    return false;
                }
            } catch (Exception e) {}
            //king
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (i!=0 || j!=0) {
                        try {
                            if ("a".equals(Board.chessBoard[King.kingPositionC/8+i][King.kingPositionC%8+j])) {
                                return false;
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return true;
    }

}
