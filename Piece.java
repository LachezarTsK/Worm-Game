public class Piece {

private int x;
private int y;
private int width;
private int length;
private int numberOfApples;

public Piece(int x, int y, int width, int length) {
    this.x = x;
    this.y = y;
    this.length = length;
    this.width = width;
}

public void setNumberOfApples() {
    this.numberOfApples += 1;
}

public int getNumberOfApples() {
    return this.numberOfApples;
}

public int getX() {
    return this.x;
}

public int getY() {
    return this.y;
}

public int getWidth() {
    return this.width;
}

public int getLength() {
    return this.length;
}

/*we use the following two override methods in order to check when the worm runs into itself.
This checking is done through the method "public boolean runsIntoItself(Piece piece)" in class "Worm"*/
@Override
public boolean equals(Object object) {
    if (this.getClass() == null) {
        return false;
    }

    if (this.getClass() != object.getClass()) {
        return false;
    }

    Piece compared = (Piece) object;
    if (this.x != compared.x || this.y != compared.y
            || this.width != compared.width || this.length != compared.length) {
        return false;
    }
    return true;
}

@Override
public int hashCode() {
    if (this.getClass() == null) {
        return 1;
    }
    return this.x + this.y + this.width + this.length;
}

@Override
public String toString() {
    return "(" + this.x + ", " + this.y + ", " + this.width + ", " + this.length + ")";
  }
}
