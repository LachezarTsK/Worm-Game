import java.util.Random;
import java.util.List;

public class AvoidOverlappingPieces {

/*this method calculates the initial position of the apple 
so that the apple is within the field and it does not overlap with the worm*/
public Apple initialApple(Worm worm, int fieldWidth, int fieldLength, int pieceWidth, int pieceLength) {
    Random random = new Random();
    Apple apple = null;
    while (true) {
        int xApple = random.nextInt(fieldWidth - (pieceWidth));
        int yApple = random.nextInt(fieldLength - (pieceLength));
        apple = new Apple(xApple, yApple, pieceWidth, pieceLength);
        if (xApple + (pieceWidth) < worm.getX()) {
            break;
        } else if (xApple > worm.getX() + pieceWidth) {
            break;
        } else if ((xApple + (pieceWidth) >= worm.getX())
                && (xApple <= worm.getX() + pieceWidth)) {
            if (yApple + (pieceLength) < worm.getY()
                    || (yApple > worm.getY() + (pieceLength))) {
                break;
            }
        }
    }
    return apple;
}

/*this method calculates the position of the new apple, after the previous one is eaten
by the worm, so that the apple is within the field and it does not overlap with the worm*/
public Apple replaceEatenApple(Worm worm, List<Piece> piecesWorm, int fieldWidth, int fieldLength, int pieceWidth, int pieceLength) {
    Random random = new Random();
    Apple apple = null;
    while (true) {
        int xApple = random.nextInt(fieldWidth - (pieceWidth));
        int yApple = random.nextInt(fieldLength - (pieceLength));
        Apple newApple = new Apple(xApple, yApple, pieceWidth, pieceLength);
        if (this.fieldExeptWorm(newApple, piecesWorm) == false) {
            apple = newApple;
            break;
        }
    }
    return apple;
}
/*this method calculates the available space, taking account of the current    
position of worm, and it is used in the method "replaceEatenApple(...)"*/
    public boolean fieldExeptWorm(Piece piece, List<Piece> piecesWorm) {
        int counter = 0;
        for (int i = 0; i < piecesWorm.size(); i++) {
        Piece wormPiece = piecesWorm.get(i);
        if ((wormPiece.getX() + (wormPiece.getWidth())) < piece.getX()) {
            counter++;
        } else if (wormPiece.getX() > (piece.getX() + piece.getWidth())) {
            counter++;
        } else if ((wormPiece.getX() + (wormPiece.getWidth())) >= piece.getX()
                && (wormPiece.getX() <= (piece.getX() + piece.getWidth()))) {
            if (wormPiece.getY() + (wormPiece.getLength()) < piece.getY()
                    || (wormPiece.getY() > piece.getY() + (piece.getLength()))) {
                counter++;
            }
        }
    }
    if (counter == piecesWorm.size()) {
        return false;
    }
    return true;
   }
}
