import java.util.Random;

public class WormGame {

private int fieldWidth;
private int fieldLength;
private int pieceWidth;
private int pieceLength;
private Worm worm;
private Apple apple;
private Random random;
/* class "AvoidOverlappingPieces" contains methods that calculate
the initial spot of the apple and its subsequent positions across the field*/
private AvoidOverlappingPieces properPieces;
protected int applesNumber;

public WormGame(int fieldWidth, int fieldLength) {
    this.fieldWidth = fieldWidth;
    this.fieldLength = fieldLength;
    this.pieceWidth = (this.fieldWidth - 10) / 10;
    this.pieceLength = (this.fieldLength - 10) / 10;
    this.worm = new Worm(0, 0, pieceWidth, pieceLength, Direction.DOWN);
    this.random = new Random();
    this.properPieces = new AvoidOverlappingPieces();
    this.apple = this.properPieces.initialApple(this.worm, this.fieldWidth, this.fieldLength, this.pieceWidth, this.pieceLength);
}

public int getfieldWidth() {
    return this.fieldWidth;
}

public int getfieldLength() {
    return this.fieldLength;
}

public Worm getWorm() {
    return this.worm;
}

public Apple getApple() {
    return this.apple;
}

/*this method accelerates the worm as it grows longer, 
through calculating smaller and smaller values for the number 
of milliseconds that are fed into "Thread.sleep(int number)",
implemented in the method "action()";*/
public int setDelay(Worm worm) {
    int delay = 1500 / worm.getLength();
    return delay;
}

/*this method takes the calculated new piece from method "calculateNewPiece" 
from class "Worm" and does the following:
# checks whether the new piece of the worm is within the confines of the field.
# if the new piece is within these confines the method "move()" from class "Worm" is called.
# if the worm bupms into an apple, the method "grow()" from class "Worm" and 
the method "replaceEatenApple(...)" from class "AvoidOverlappingPieces" are called.
# if the new piece is outside the confines of the field the game is terminated.*/
public void action() {
    int x_nextStep = this.worm.calculateNewPiece().getX();
    int y_nextStep = this.worm.calculateNewPiece().getY();
    if (x_nextStep >= 0 && (x_nextStep + this.pieceWidth) <= this.fieldWidth
            && y_nextStep >= 0 && (y_nextStep + this.pieceLength) <= this.fieldLength) {
        try {
            Thread.sleep(this.setDelay(this.worm));
        } catch (Exception ex) {
        }
        this.worm.move();
        if (this.worm.runsInto(this.apple)) {
            this.worm.setNumberOfApples();
            this.getWorm().getFrame().setTitle("Number of Apples: " + (this.worm.getNumberOfApples()));
            this.worm.grow();
            this.apple = this.properPieces.replaceEatenApple(this.worm, this.worm.getPieces(), this.fieldWidth, this.fieldLength, this.pieceWidth, this.pieceLength);
        }
    } else {
        this.getWorm().getFrame().setTitle("The worm has run into a wall!!! "
                + "Total Number of Apples: " + (this.worm.getNumberOfApples()));
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
        }
        System.exit(0);
    }
}

public int getNumberOfApples() {
    return this.applesNumber;
   }
}
