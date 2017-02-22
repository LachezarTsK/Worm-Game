import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Worm extends Piece {

private int growth;
Direction direction;
private List<Piece> piecesWorm;
private JFrame frame;

public Worm(int x, int y, int width, int length, Direction originalDirection) {
    super(x, y, width, length);
    this.growth = 0;
    this.direction = originalDirection;
    this.piecesWorm = new ArrayList<Piece>();
    this.piecesWorm.add(new Piece(x, y, width, length));
    frame = new JFrame("Number of Apples: " + super.getNumberOfApples());
}

public JFrame getFrame() {
    return this.frame;
}

public Direction getDirection() {
    return this.direction;
}

public void setDirection(Direction dir) {
    this.direction = dir;
}

public int getLength() {
    return this.piecesWorm.size();
}

public List<Piece> getPieces() {
    return this.piecesWorm;
}

/*this method takes the calculated new piece from method "calculateNewPiece"
and does the following:
# moves the worm(adds an element to the head and substructs an element from the tail) 
# makes the worm grow(only adds an element to the head)
# terminates the game if the worm runs into itself*/
public void move() {
    if (this.runsIntoItself(this.calculateNewPiece()) == false) {
        if (this.piecesWorm.size() < 3) {
            this.piecesWorm.add(this.calculateNewPiece());
        } else if (this.piecesWorm.size() >= 3) {
            if (this.growth == 0) {
                this.piecesWorm.add(this.calculateNewPiece());
                this.piecesWorm.remove(0);
            } else if (this.growth == 1) {
                this.piecesWorm.add(this.calculateNewPiece());
                this.growth = 0;
            }
        }
    } else {
        this.frame.setTitle("The worm has run into itself!!! "
                + "Total Number of Apples: " + (this.getNumberOfApples()));
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
        }
        System.exit(0);
    }
}
/*this method calculates the next piece of the worm according to its direction*/
public Piece calculateNewPiece() {
    // lpbm stands for "lastPieceBeforeMoving"
    Piece lpbm = null;
    Piece newPiece = null;
    if (this.piecesWorm.size() == 1) {
        lpbm = this.piecesWorm.get(0);
    } else {
        lpbm = this.piecesWorm.get(this.piecesWorm.size() - 1);
    }
    int x = lpbm.getX();
    int y = lpbm.getY();

    if (this.direction.equals(Direction.LEFT)) {
        newPiece = new Piece(x - 1 - super.getWidth(), y, super.getWidth(), super.getLength());

    } else if (this.direction.equals(Direction.RIGHT)) {
        newPiece = new Piece(x + 1 + super.getWidth(), y, super.getWidth(), super.getLength());

    } else if (this.direction.equals(Direction.DOWN)) {
        newPiece = new Piece(x, y + 1 + super.getLength(), super.getWidth(), super.getLength());

    } else if (this.direction.equals(Direction.UP)) {
        newPiece = new Piece(x, y - 1 - super.getLength(), super.getWidth(), super.getLength());
    }
    return newPiece;
}

/*this method sets the conditions that determines whether the worm will grow or not when
the method "move()" is called*/
public void grow() {
    this.growth = 1;
}

/*this method checks whether the worm runs into an apple*/
public boolean runsInto(Piece piece) {
    Piece headPieceOfWorm = this.piecesWorm.get(this.piecesWorm.size() - 1);
    if ((headPieceOfWorm.getX() + (headPieceOfWorm.getWidth())) < piece.getX()) {
        return false;
    } else if (headPieceOfWorm.getX() > (piece.getX() + piece.getWidth())) {
        return false;
    } else if ((headPieceOfWorm.getX() + (headPieceOfWorm.getWidth())) >= piece.getX()
            && (headPieceOfWorm.getX() <= (piece.getX() + piece.getWidth()))) {
        if (headPieceOfWorm.getY() + (headPieceOfWorm.getLength()) < piece.getY()
                || (headPieceOfWorm.getY() > piece.getY() + (piece.getLength()))) {
            return false;
        }
    }
    return true;
}

/*this method checks whether the worm runs into itself*/
public boolean runsIntoItself(Piece piece) {
    if (this.piecesWorm.contains(piece)) {
        return true;
    }
    return false;
}

@Override
public String toString() {
    return "(" + super.getX() + ", " + super.getY() + ", " + super.getWidth()
            + ", " + super.getLength() + ", " + this.getDirection() + ")";
   }
}
